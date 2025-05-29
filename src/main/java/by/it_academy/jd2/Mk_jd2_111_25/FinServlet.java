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

        int totalNumber = 0;
        long totalSum = 0;
        for (String row: rows){
            String[] cells = row.split(",");
            totalSum = totalSum + Long.parseLong(cells[0])*Long.parseLong(cells[1]);
            totalNumber = totalNumber + Integer.parseInt(cells[1]);
        }
        long averagePrice = totalSum/totalNumber;
        writer.write("<p>");
        writer.write("<div id=average-price-container>\n" +
                            "<div class=\"medium-title\">\n" +
                            "Средняя цена\n" +
                            "</div>\n" +
                            "<div class=\"fs-2 green\">" + averagePrice + "</div>" +
                        "</div>");
        writer.write("<div id=total-count-container>\n" +
                            "<div class=\"medium-title\">\n" +
                            "Общая численность\n" +
                            "</div>\n" +
                            "<div class=\"fs-2\">" + totalNumber + "</div>" +
                        "</div>");
        writer.write("<div id=total-amount-container>\n" +
                            "<div class=\"medium-title\">\n" +
                            "Общая сумма\n" +
                            "</div>\n" +
                            "<div class=\"fs-2\">" + totalSum + "</div>" +
                        "</div>");
        writer.write("</p>");
    }
}
