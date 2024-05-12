package xsy.javaweb.servletdemo;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-Type","text/html;charset-UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        try (Connection conn = ConnectConfig.getConnection()) {
            String sql = "DELETE FROM tb_users WHERE username = ? and password = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                //response.sendRedirect("");
                response.getWriter().println("删除成功");
            } else {
                //response.sendRedirect("\");
                response.getWriter().println("删除失败");

            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("数据库错误");
        }
    }
}