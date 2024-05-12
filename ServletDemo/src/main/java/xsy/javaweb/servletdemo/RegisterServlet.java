package xsy.javaweb.servletdemo;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-Type","text/html;charset-UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (isUsernameOrPasswordExists(username)) {
            // 用户名或密码已存在
            //response.sendRedirect("");
            response.getWriter().println("用户名已存在");

        } else {
            try (Connection conn = ConnectConfig.getConnection()) {
                String sql = "INSERT INTO tb_users (username, password) VALUES (?, ?)";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, username);
                pstmt.setString(2, password);

                int rowsAffected = pstmt.executeUpdate();
                if (rowsAffected > 0) {
                    //response.sendRedirect("");
                    response.getWriter().println("注册成功");
                } else {
                    //response.sendRedirect("");
                    response.getWriter().println("注册失败");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                response.getWriter().println("内部出错");
            }
        }
    }
    private boolean isUsernameOrPasswordExists(String username) {
        try (Connection conn = ConnectConfig.getConnection()) {
            String sql = "SELECT username FROM tb_users WHERE username = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return true; // 用户名存在
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
