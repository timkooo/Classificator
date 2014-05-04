package main.mbeans;

import main.ejb.UserDAO;
import main.entity.UsersEntity;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by timko_000 on 02.05.2014.
 */

@WebFilter("/pages/private/*")
public class UserFilter implements Filter {

    @Inject
    LoginBean loginBean;

    @Inject
    CookieBean cookieBean;

    @EJB
    UserDAO userDAO;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        UsersEntity usersEntity = (UsersEntity) session.getAttribute("user");

        if (usersEntity == null) {
            try {
                String userSessionId = cookieBean.getFromCookies("userSessionId");
                if (userSessionId != null) {
                    UsersEntity user = userDAO.findUser(userSessionId);
                    session.setAttribute("user", user);
                    response.sendRedirect(request.getContextPath() + "/pages/home.xhtml");
                }
            } catch (NullPointerException e) {
//                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("uri", request.getRequestURI());
                String uri = request.getRequestURI();
                String uri2 = uri.replace(request.getContextPath(),"");
                response.sendRedirect(request.getContextPath() + "/login.xhtml?uri=" + uri2);
            }
        } else {
            filterChain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
