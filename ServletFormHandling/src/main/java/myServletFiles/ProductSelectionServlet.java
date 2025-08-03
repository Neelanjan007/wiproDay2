package myServletFiles;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

@SuppressWarnings("serial")
public class ProductSelectionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String selected = request.getParameter("product"); 
        String[] parts = selected.split("-");

        String productName = parts[0];
        String price = parts[1];

        request.setAttribute("productName", productName);
        request.setAttribute("price", price);

        RequestDispatcher rd = request.getRequestDispatcher("enterQuantity.jsp");
        rd.forward(request, response);
    }
}
