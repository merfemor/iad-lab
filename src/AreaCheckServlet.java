import point.Point;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

public class AreaCheckServlet extends HttpServlet {
    private List<Point> previousPointList;

    @Override
    public void init(ServletConfig config) throws ServletException {
        previousPointList = new LinkedList<>();
        config.getServletContext().setAttribute("previousPointList", previousPointList);
    }

    protected void ajaxProcess(HttpServletResponse resp, Point p) throws IOException {
        resp.getWriter().println(p.isInRegion);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        double x = Double.parseDouble(req.getParameter("Xcor"));
        double y = Double.parseDouble(req.getParameter("Ycor"));
        double r = Double.parseDouble(req.getParameter("Rrad"));
        Point point = new Point(x, y, r);
        previousPointList.add(point);

        if (req.getParameter("Ajax") != null) {
            ajaxProcess(resp, point);
            return;
        }

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println("<html>\n" +
                "<head>\n" +
                "<style>\n" +
                "    TD, TH {\n" +
                "    border: 1px solid;\n" +
                "        padding: 8px;\n" +
                "    }\n" +
                "    TABLE {\n" +
                "       \n" +
                "    }\n" +
                "</style>\n" +
                "</head>\n");
        out.println("<body>\n" +
                "<b>Entered values</b>:<br>\n" +
                "\t<table cellspacing='1'>\n" +
                "\t\t<tr> <td>x</td> <td>" + point.x + "</td> </tr>\n" +
                "\t\t<tr> <td>y</td> <td>" + point.y + "</td> </tr>\n" +
                "\t\t<tr> <td>r</td> <td>" + point.radius + "</td> </tr>\n" +
                "\t</table><br>\n" +
                "The point is in the region: <font color=\"");
        if (point.isInRegion) {
            out.print("green\"><b>true</b>");
        } else {
            out.print("red\"><b>false</b>");
        }
        out.println("</font><br>");
        out.println("<a href='" + req.getContextPath() + "'>Return to main page</a>");
        out.println("</body>\n</html>");
    }
}
