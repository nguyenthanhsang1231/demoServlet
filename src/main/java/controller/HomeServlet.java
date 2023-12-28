package controller;

import model.Class;
import model.Student;
import service.ClassService;
import service.NameComparator;
import service.StudentService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "HomeServlet", value = "/home")
public class HomeServlet extends HttpServlet {
    ClassService classService = new ClassService();
    StudentService studentService = new StudentService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "sortage":
                SortByAge(request, response);
                break;
            case "sortname":
                SortByName(request, response);
                break;
            default:
                showlistStudent(request, response);
                break;
        }
    }

    private void SortByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        NameComparator nameComparator = new NameComparator();
        ArrayList<Student> students = new ArrayList<>();
        students = studentService.findAll();
        students.sort(nameComparator);
        ArrayList<Class> classes = classService.findAll();
        request.setAttribute("cls", classes);
        request.setAttribute("std", students);
        request.getRequestDispatcher("/home/index.jsp").forward(request, response);
    }

    private void SortByAge(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Student> students = new ArrayList<>();
        students = studentService.findAll();
        students.sort(studentService);
        ArrayList<Class> classes = classService.findAll();
        request.setAttribute("cls", classes);
        request.setAttribute("std", students);
        request.getRequestDispatcher("/home/index.jsp").forward(request, response);
    }

    private void showlistStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String search = request.getParameter("search");
        System.out.println(search);
        ArrayList<Student> students = new ArrayList<>();
        if (search!=null) {
            students = studentService.findByName(search);
        }
        else {
            students = studentService.findAll();
        }
        ArrayList<Class> classes = classService.findAll();
        request.setAttribute("cls", classes);
        request.setAttribute("std", students);
        request.getRequestDispatcher("/home/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}