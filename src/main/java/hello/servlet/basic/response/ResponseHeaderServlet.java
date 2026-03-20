package hello.servlet.basic.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(name="responseHeaderServlet",urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setStatus(HttpServletResponse.SC_OK);

        response.setHeader("Content-Type","text/plain;charset=UTF-8");
        response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
        response.setHeader("Pragma","no-cache");
        response.setHeader("my-header","hello");
        response.getWriter().write("asd");

        cokkoe(response);
        redirect(response);


    }



    private static void cokkoe(HttpServletResponse response) {
        Cookie cc= new Cookie("my-cookie","asd");
        cc.setMaxAge(600);
        response.addCookie(cc);
    }

    private void redirect(HttpServletResponse response) throws IOException {
//Status Code 302
//Location: /basic/hello-form.html
//response.setStatus(HttpServletResponse.SC_FOUND); //302
//response.setHeader("Location", "/basic/hello-form.html");
        response.sendRedirect("/basic/hello-form.html");

    }
}
