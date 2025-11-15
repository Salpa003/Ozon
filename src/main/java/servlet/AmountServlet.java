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

@WebServlet(value = "/amount", name = "amount")
public class AmountServlet extends HttpServlet {
    private static UserService service= new UserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/amount.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       int sum = Integer.parseInt(req.getParameter("sum"));
        Cookie[] cookies = req.getCookies();
        long id = -1;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("id"))
                    id = Long.parseLong(cookie.getValue());
            }
        }
      boolean b = service.donate(id,sum);
        String message;
        if (b) {
            message = String.format("%d donated",sum);
        } else {
            message = "error";
        }
        req.setAttribute("message",message);
        req.getRequestDispatcher("/jsp/amount.jsp").forward(req,resp);
    }
}
