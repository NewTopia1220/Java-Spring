package hello.servlet.web.frontcontroller.v4.Controller;

import hello.servlet.web.ModelView;
import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.V3.ControllerV3;
import hello.servlet.web.frontcontroller.V3.MemberFormControkkerV3;
import hello.servlet.web.frontcontroller.V3.MemberListControllerV3;
import hello.servlet.web.frontcontroller.V3.MemberSaveControllerV3;
import hello.servlet.web.frontcontroller.v4.ControllerV4;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jspecify.annotations.NonNull;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@WebServlet(name="frontControllerServlertV4", urlPatterns="/front-controller/v4/*")
public class FroneControllerServletV4 extends HttpServlet {

    private Map<String, ControllerV4>controllerMap=new HashMap<>();

    public FroneControllerServletV4() {
        controllerMap.put("/front-controller/v4/members/new-form", new MemberFormControkkerV4());
        controllerMap.put("/front-controller/v4/members/save",new MemberSaveControllerV4());
        controllerMap.put("/front-controller/v4/members",new MemberListControllerV4());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String requestURI = request.getRequestURI();
        ControllerV4 controller = controllerMap.get(requestURI);

        if(controller==null){
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("그런 거 없다 (404 Not Found)");
            return;
        }

        Map<String, String> paramMap = CreateParaMap(request);
        Map<String,Object> model=new HashMap<>();

        String viewName = controller.process(paramMap, model);
        MyView view= viewResolver(viewName);
        view.render(model,request, response);
    }

    private static @NonNull MyView viewResolver(String vieName) {
        return new MyView("/WEB-INF/views" + vieName + ".jsp");
    }

    private static @NonNull Map<String, String> CreateParaMap(HttpServletRequest request) {
        Map<String,String> paramMap=new HashMap<>();
        request.getParameterNames().asIterator().forEachRemaining(
                paramNames -> paramMap.put(paramNames, request.getParameter(paramNames)));
        return paramMap;
    }
}
