package hello.hellospring.controller;


import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {


    private final MemberService memberService;

    @Autowired //스프링 컨테이너에서 자동적으로 memberservice를 가져오는 어노테이션 @Service라는 붙어 있는 클라스여야 가능함
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
