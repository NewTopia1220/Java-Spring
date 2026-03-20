package hello.servlet.web.frontcontroller.V3;

import hello.servlet.web.ModelView;

import java.util.Map;

public class MemberFormControkkerV3 implements ControllerV3 {


    @Override
    public ModelView process(Map<String, String> paraMap) {
        return new ModelView("new-form");
    }
}
