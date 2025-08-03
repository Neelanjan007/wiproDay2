package myServletFiles;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

@SuppressWarnings("serial")
public class CartServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String[] selectedItems = request.getParameterValues("item");

        if (selectedItems != null) {
            for (String item : selectedItems) {
                Cookie cookie = new Cookie(item, item);
                cookie.setMaxAge(24 * 60 * 60); // 1 day
                response.addCookie(cookie);
            }
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<h2>Items added to cart!</h2>");
        out.println("<a href='cart.html'>Go back to shopping</a><br>");
        out.println("<a href='viewCart'>View Cart</a>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        Cookie[] cookies = request.getCookies();

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<h2>Your Cart:</h2>");

        boolean found = false;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                String value = cookie.getValue();

                if (name.equals(value)) {
                    out.println("<p>" + value + "</p>");
                    found = true;
                }
            }
        }

        if (!found) {
            out.println("<p>No items in your cart.</p>");
        }

        out.println("<br><a href='cart.html'>Back to Shop</a>");
    }
}

