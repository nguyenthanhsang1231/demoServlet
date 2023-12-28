package controller;

import model.Class;
import service.ClassService;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ClassServlet", urlPatterns = "/classes")

public class ClassServlet extends HttpServlet {
    private ClassService classService;

    public void init() {
        classService = new ClassService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            default:
                showList(request, response);
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Class> classes = classService.findAll();
        request.setAttribute("cls", classes);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/class/list.jsp");
        dispatcher.forward(request, response);
    }

}