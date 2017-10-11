import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class ControllerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String x = req.getParameter("Xcor");
        String y = req.getParameter("Ycor");
        String r = req.getParameter("Rrad");
        if(req.getParameter("exprcalc") != null) {
            req.getRequestDispatcher("/check").forward(req, resp);
        }else if(req.getParameter("exprcalc") != null || req.getParameter("Ajax") != null) {
            req.getRequestDispatcher("/check").forward(req, resp);
        } else if (x == null || y == null || r == null || !isValidParameters(x, y, r)) {
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("/check").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    private static boolean isValidParameters(String xs, String ys, String rs) {
        int x;
        double y, r;
        try {
            x = Integer.parseInt(xs);
            y = Double.parseDouble(ys);
            r = Double.parseDouble(rs);
        } catch (Exception e) {
            return false;
        }
        if (x < -3 || x > 5 || y < -5 || y > 5)
            return false;

        for (double i = 1.0; i <= 3; i += 0.5) {
            if (Double.compare(r, i) == 0)
                return true;
        }
        return false;
    }
}
