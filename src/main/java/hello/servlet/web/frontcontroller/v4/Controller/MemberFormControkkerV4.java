package hello.servlet.web.frontcontroller.v4.Controller;

import hello.servlet.web.ModelView;
import hello.servlet.web.frontcontroller.V3.ControllerV3;
import hello.servlet.web.frontcontroller.v4.ControllerV4;

import java.util.Map;

public class MemberFormControkkerV4 implements ControllerV4 {



    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        return "new-form";
    }


}
