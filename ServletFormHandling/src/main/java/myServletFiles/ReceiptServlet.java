package myServletFiles;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

@SuppressWarnings("serial")
public class ReceiptServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String product = request.getParameter("productName");
        int price = Integer.parseInt(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        int total = price * quantity;

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<h2>Receipt</h2>");
        out.println("<p>Product: " + product + "</p>");
        out.println("<p>Price: ₹" + price + "</p>");
        out.println("<p>Quantity: " + quantity + "</p>");
        out.println("<p><strong>Total: ₹" + total + "</strong></p>");
    }
}
