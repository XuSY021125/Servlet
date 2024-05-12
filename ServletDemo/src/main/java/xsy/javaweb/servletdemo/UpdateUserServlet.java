package xsy.javaweb.servletdemo;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-Type","text/html;charset-UTF-8");

        String oldUsername = request.getParameter("oldUsername");
        String newUsername = request.getParameter("newUsername");
        String newPassword = request.getParameter("newPassword");

        try (Connection conn = ConnectConfig.getConnection()) {
            String sql = "UPDATE tb_users SET username = ?,password = ? WHERE username = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newUsername);
            pstmt.setString(2, newPassword);
            pstmt.setString(3, oldUsername);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                //response.sendRedirect("");
                response.getWriter().println("修改成功");
            } else {
                //response.sendRedirect("");
                response.getWriter().println("修改失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("Database error.");
        }
    }
}
