package controller;

import model.Class;
import model.Student;
import service.ClassService;
import service.StudentService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@WebServlet(name = "StudentServlet", urlPatterns = "/students")
public class StudentServlet extends HttpServlet {
    StudentService studentService = new StudentService();
    ClassService classService = new ClassService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create" :
                showCreateGet(request, response);
                break;
            case "delete" :
                deleteStudent(request, response);
                break;
            case "edit" :
                editStudentGet(request, response);
                break;
        }
    }

    private void editStudentGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = studentService.findById(id);
        request.setAttribute("student", student);
        request.setAttribute("classes",classService.findAll());
        request.getRequestDispatcher("/student/edit.jsp").forward(request, response);
    }

    private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        studentService.delete(id);
        response.sendRedirect("/home");
    }

    private void showCreateGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Class> classes = classService.findAll();
        request.setAttribute("classes", classes);
        request.getRequestDispatcher("/student/add.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create" :
                showCreatePost(request, response);
                break;
            case "edit" :
                editStudentPost(request, response);
                break;
//            default:
//                showList(request, response);
    }
}

    private void editStudentPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        int classId = Integer.parseInt(request.getParameter("classId"));
        Class clazz = classService.findById(classId);
        Student student = new Student(name, age, clazz);
        studentService.update(id, student);
        response.sendRedirect("/home");
    }

    private void showCreatePost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        int classId = Integer.parseInt(request.getParameter("classId"));
        Class clazz = classService.findById(classId);
        studentService.add(new Student(0, name, age, clazz));
        response.sendRedirect("/home");
    }
}