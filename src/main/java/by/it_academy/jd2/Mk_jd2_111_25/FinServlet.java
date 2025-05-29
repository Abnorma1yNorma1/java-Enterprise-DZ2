package by.it_academy.jd2.Mk_jd2_111_25;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/fin")
public class FinServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp) throws ServletException, IOException {
        String[] rows = req.getParameterValues("rows");

        PrintWriter writer = resp.getWriter();
        writer.write("<table border='1'>");
        for (String row : rows) {
            String[] cells = row.split(",");
            writer.write("<tr>");
            for (String cell : cells) {
                writer.write("<td>" + cell + "</td>");
            }
            long result = Long.parseLong(cells[0]) * Long.parseLong(cells[1]);
            writer.write("<td>" + result + "</td>");
            writer.write("</tr>");
        }
        writer.write("</table>");
    }
}
