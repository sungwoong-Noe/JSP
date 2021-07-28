package hello.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest reqest, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("HelloServlet.service");
        System.out.println("reqest = " + reqest);
        System.out.println("response = " + response);

        String username = reqest.getParameter("username");  //쿼리 파라미터를 서블릿으로 쉽게 읽도록 지원해줌
        System.out.println("username =" + username);

        response.setContentType("text/plain");      //단순문자를 보냄
        response.setCharacterEncoding("utf-8");
        response.getWriter().write("hello " + username); //.write(): Http 메세지body에  들어감

    }           //서블릿이 호출되면 서비스 메소드가 호출이 되는 코드
}
