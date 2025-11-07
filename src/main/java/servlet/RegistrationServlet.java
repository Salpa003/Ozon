package servlet;

import dao.SessionPool;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.UserService;

import java.io.IOException;

@WebServlet("/reg")
public class RegistrationServlet extends HttpServlet {
    private static UserService service = new UserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/reg.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String login = req.getParameter("login");
       String password = req.getParameter("password");
        System.out.println(login);
        System.out.println(password);
       long id = service.createUser(login,password);
        Cookie cookie = new Cookie("id",String.valueOf(id));
        cookie.setMaxAge(1000*60*60);
        resp.addCookie(cookie);
        resp.getWriter().println("Yes");
    }
}
