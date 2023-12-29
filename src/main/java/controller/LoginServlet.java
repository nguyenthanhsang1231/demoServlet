package controller;

import model.User;
import service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/homelogin")
public class LoginServlet extends HttpServlet {
    UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/home/login.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String passWord = request.getParameter("passWord");
        boolean checkLogin = userService.checkUser(passWord);
        if (checkLogin == true) {
            response.sendRedirect("/home");
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/home/register.jsp");
            dispatcher.forward(request, response);
        }
    }
}