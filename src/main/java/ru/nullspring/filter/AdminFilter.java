package ru.nullspring.filter;

import ru.nullspring.model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/admin/*")
public class AdminFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain filterChain)
            throws IOException, ServletException {

        HttpSession session = ((HttpServletRequest)request).getSession();
        User user = (User) session.getAttribute("user");
        String role = user.getRole();

        if (role.equals("admin")) {
            filterChain.doFilter(request, response);
        } else {
            ((HttpServletResponse) response).sendRedirect("/accessDenied");
        }

    }

    @Override
    public void destroy() {

    }


}
