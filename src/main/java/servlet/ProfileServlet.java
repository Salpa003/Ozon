package servlet;

import entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.UserService;

import java.io.IOException;

@WebServlet(value = "/profile", name = "profile")
public class ProfileServlet extends HttpServlet {
    private static UserService service = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        long id = -1;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("id"))
                id = Long.parseLong(cookie.getValue());
            }
        }
        User user = service.get(id);

        req.setAttribute("id", user.getId());
        req.setAttribute("login", user.getLogin());
        req.setAttribute("password", user.getPassword());
        req.setAttribute("amount", user.getAmount());
        req.getRequestDispatcher("/jsp/profile.jsp").forward(req, resp);


    }
}
