package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.UserService;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static UserService service = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        long id = service.login(login, password);
        String errorMessage = "";
        if (id == -1) {
            errorMessage = "User dont found";
            req.setAttribute("errorMessage", errorMessage);
            req.setAttribute("login", login);
            req.setAttribute("password", password);
            doGet(req,resp);
        } else if (id == -2) {
            errorMessage = "Password dont correct";
            req.setAttribute("errorMessage", errorMessage);
            req.setAttribute("login", login);
            req.setAttribute("password", password);

            doGet(req,resp);
        } else {
            Cookie cookie = new Cookie("id", String.valueOf(id));
            cookie.setMaxAge(1000 * 60 * 60);
            resp.addCookie(cookie);
            req.getRequestDispatcher("/home").forward(req, resp);
        }

    }
}
