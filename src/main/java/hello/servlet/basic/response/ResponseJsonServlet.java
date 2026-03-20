package hello.servlet.basic.response;

import hello.servlet.basic.HelloData;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;

@WebServlet(name="responseJsonServlert", urlPatterns ="/response-json" )
public class ResponseJsonServlet extends HttpServlet {

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("application/json;charset=UTF-8");
        HelloData helloData = new HelloData();
        helloData.setUsername("kim");
        helloData.setAge(20);
        String result = mapper.writeValueAsString(helloData);
        response.getWriter().println(result);

    }
}
