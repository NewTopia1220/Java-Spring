package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name="requestParamServlet", urlPatterns = "/request-param")
public class RequestParamSevlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("전체 파라매터 조회");
        request.getParameterNames().asIterator().forEachRemaining(para-> System.out.println(para +"," + request.getParameter(para)));
        System.out.println();

        System.out.println("단일 파라미터 조회");
        String age = request.getParameter("age");

        System.out.println("age = " + age);

        response.getWriter().write(age);
    }
}
