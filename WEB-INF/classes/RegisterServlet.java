import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        try {
            // 🔍 Debug
            System.out.println("RegisterServlet called");

            String reg_no = req.getParameter("reg_no");
            String name = req.getParameter("name");
            String password = req.getParameter("password");
            String year = req.getParameter("year");
            String semester = req.getParameter("semester");
            String branch = req.getParameter("branch");

            System.out.println(reg_no + " " + name);

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
               "INSERT INTO students (reg_no, name, password, year, semester, branch) VALUES (?,?,?,?,?,?)"
            );

            ps.setString(1, reg_no);
            ps.setString(2, name);
            ps.setString(3, password);
            ps.setInt(4, Integer.parseInt(year));
            ps.setInt(5, Integer.parseInt(semester));
            ps.setString(6, branch);

            int i = ps.executeUpdate();

            if (i > 0) {
                System.out.println("Insert success");

                // ✅ VERY IMPORTANT (prevents blank page)
                res.sendRedirect("login.jsp?msg=success");

            } else {
                out.println("<h3>Registration Failed</h3>");
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();

            // ✅ show error in browser (helps debugging)
            out.println("<h3 style='color:red;'>Error: " + e.getMessage() + "</h3>");
        }
    }
}