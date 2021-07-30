package hello.servlet.basic.Response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "responseHeaderServlet" , urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //[status-Line]
        response.setStatus(HttpServletResponse.SC_OK);       // HTTP 응답 코드 200을 직접 적지 말고 서블릿응답 사용

        //[response-header]
        response.setHeader("Content-Type", "text/plain;charset=utf-8");
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");     //캐쉬 무효화
        response.setHeader("Pragma", "no-cache");   //캐쉬 무효화 (과거 버전까지 다)
        response.setHeader("my-header", "hello");   //내가 원하는 임의의 헤더도 생성 가능

        //[Header 편의 메서드]
        content(response);



        PrintWriter writer = response.getWriter();
        writer.println("ok");
    }
    //content 편의 메서드
    private void content(HttpServletResponse response) {
        //Content-Type: text/plain;charset=utf-8
        //Content-Length: 2
        //response.setHeader("Content-Type", "text/plain;charset=utf-8");
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        //response.setContentLength(2); //(생략시 자동 생성)
    }

