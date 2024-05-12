package xsy.javaweb.servletdemo;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-Type","text/html;charset-UTF-8");

        System.out.println(request.getRemoteHost());

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try (Connection conn = ConnectConfig.getConnection()) {
            String sql = "SELECT * FROM tb_users WHERE username = ? AND password = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                // 登录成功，可以设置session
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                response.sendRedirect("http://localhost:1125/ServletDemo/Home.jsp");
                //response.getWriter().println("登录 成功");
            } else {
                //response.sendRedirect("");
                response.getWriter().println("登录 失败");
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("数据出错.");
        }
    }
}