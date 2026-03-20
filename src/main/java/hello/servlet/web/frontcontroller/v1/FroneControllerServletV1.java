package hello.servlet.web.frontcontroller.v1;

import hello.servlet.web.frontcontroller.v1.Controller.MemberFormControllerV1;
import hello.servlet.web.frontcontroller.v1.Controller.MemberListControllerV1;
import hello.servlet.web.frontcontroller.v1.Controller.MemberSaveControllerV1;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;




@WebServlet(name="frontControllerServlertV1", urlPatterns="/front-controller/v1/*")
public class FroneControllerServletV1 extends HttpServlet {

    private Map<String,ControllerV1>controllerMap=new HashMap<>();

    public FroneControllerServletV1() {
        controllerMap.put("/front-controller/v1/members/new-form",new MemberFormControllerV1());
        controllerMap.put("/front-controller/v1/members/save",new MemberSaveControllerV1());
        controllerMap.put("/front-controller/v1/members",new MemberListControllerV1());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String requestURI = request.getRequestURI();
        ControllerV1 controller = controllerMap.get(requestURI);
        if(controller==null){
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("그런 거 없다 (404 Not Found)");
            return;
        }

        controller.process(request,response);
    }
}
