package hello.servlet.web.frontcontroller.v4.Controller;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.ModelView;
import hello.servlet.web.frontcontroller.V3.ControllerV3;
import hello.servlet.web.frontcontroller.v4.ControllerV4;

import java.util.Map;


public class MemberSaveControllerV4 implements ControllerV4 {

    private MemberRepository memberRepository= MemberRepository.getInstance();
    @Override
    public String process(Map<String, String> paraMap, Map<String, Object> model) {
        String username = paraMap.get("username");
        int age= Integer.parseInt(paraMap.get("age"));

        Member member = new Member(username,age);
        memberRepository.save(member);

        model.put("member",member);
        return "save-result";

    }
}
//오늘 공부끝