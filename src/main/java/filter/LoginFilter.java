package filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter(servletNames = {"home"})
public class LoginFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        Cookie[] cookies = req.getCookies();
        boolean isLogin = false;
        if (cookies!= null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("id"))
                    isLogin = true;
            }
        }
        if (!isLogin) {
           req.getRequestDispatcher("/reg").forward(req,res);
        }
        super.doFilter(req, res, chain);
    }
}
