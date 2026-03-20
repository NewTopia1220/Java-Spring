package hello.servlet.web.frontcontroller.V2;

import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.V2.Controller.MemberFormControllerV2;
import hello.servlet.web.frontcontroller.V2.Controller.MemberListControllerVw;
import hello.servlet.web.frontcontroller.V2.Controller.MemberSaveControllerV2;
import hello.servlet.web.frontcontroller.v1.Controller.MemberFormControllerV1;
import hello.servlet.web.frontcontroller.v1.Controller.MemberListControllerV1;
import hello.servlet.web.frontcontroller.v1.Controller.MemberSaveControllerV1;
import hello.servlet.web.frontcontroller.v1.ControllerV1;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@WebServlet(name="frontControllerServlertV2", urlPatterns="/front-controller/v2/*")
public class FroneControllerServletV2 extends HttpServlet {

    private Map<String, ControllerV2>controllerMap=new HashMap<>();

    public FroneControllerServletV2() {
        controllerMap.put("/front-controller/v2/members/new-form", new MemberFormControllerV2());
        controllerMap.put("/front-controller/v2/members/save",new MemberSaveControllerV2());
        controllerMap.put("/front-controller/v2/members",new MemberListControllerVw());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String requestURI = request.getRequestURI();
        ControllerV2 controller = controllerMap.get(requestURI);

        if(controller==null){
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("그런 거 없다 (404 Not Found)");
            return;
        }

        MyView view = controller.process(request, response);
        view.render(request, response);
    }
}
