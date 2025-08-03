package myServletFiles;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

@SuppressWarnings("serial")
public class InputServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String name = request.getParameter("name");
        int marks = Integer.parseInt(request.getParameter("marks"));

        request.setAttribute("studentName", name);
        request.setAttribute("studentMarks", marks);

        // Forward to GradeServlet
        RequestDispatcher dispatcher = request.getRequestDispatcher("grade");
        dispatcher.forward(request, response);
    }
}

