import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class FeedbackServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        try {
            HttpSession session = req.getSession(false);
            String reg_no = (String) session.getAttribute("user");

            if (reg_no == null) {
                res.sendRedirect("login.jsp");
                return;
            }

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO feedback(reg_no,faculty_name,subject,"
                + "q1,q2,q3,q4,q5,q6,q7,q8,q9,q10,q11,q12,q13,q14,q15,comments)"
                + " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"
            );

            ps.setString(1, reg_no);
            ps.setString(2, req.getParameter("faculty"));
            ps.setString(3, req.getParameter("subject"));

            for (int i = 1; i <= 15; i++) {
                ps.setInt(i + 3, Integer.parseInt(req.getParameter("q" + i)));
            }

            ps.setString(19, req.getParameter("comments"));

            ps.executeUpdate();
            con.close();

            // ✅ REDIRECT TO THANK YOU PAGE
            res.sendRedirect("thankyou.jsp");

        } catch (Exception e) {
            e.printStackTrace();
            res.getWriter().println("Error: " + e.getMessage());
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException {
        res.sendRedirect("dashboard.jsp");
    }
}