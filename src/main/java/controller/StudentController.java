package controller;

import java.io.*;
import java.util.List;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.Student;
import model.StudentDAO;

public class StudentController extends HttpServlet {

    private StudentDAO dao;

    @Override
    public void init() {
        dao = new StudentDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String course = request.getParameter("course");

        String errorMessage = null;

        // ✅ Validation checks
        if (name == null || name.trim().isEmpty()) {
            errorMessage = "Name cannot be empty!";
        } 
        else if (!name.matches("^[a-zA-Z\\s]+$")) {
            errorMessage = "Name must contain only letters!";
        } 
        else if (email == null || email.trim().isEmpty()) {
            errorMessage = "Email ID is required!";
        } 
        else if (!email.equals(email.toLowerCase())) {
            errorMessage = "Email must be in lowercase only!";
        } 
        else if (!email.matches("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,}$")) {
            errorMessage = "Invalid email format!";
        }
        else if(course == null || course.trim().isEmpty()) {
        	errorMessage = "Course name cannot be empty!";
        }

        if (errorMessage != null) {
            // ❌ Validation failed → show same form again
            request.setAttribute("errorMessage", errorMessage);
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
            return; // 🔴 Stop further execution
        }

        // ✅ Valid data → save and redirect
        Student s = new Student();
        s.setName(name);
        s.setEmail(email);
        s.setCourse(course);

        if(dao.saveStudent(s)) {
        	response.sendRedirect("student");
        } else {
        	request.setAttribute("errorMessage", "Database insert failed!");
        	request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        List<Student> list = dao.getAllStudents();
        req.setAttribute("students", list);

        RequestDispatcher rd = req.getRequestDispatcher("studentList.jsp");
        rd.forward(req, resp);
    }
}
