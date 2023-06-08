package cyj.hello_spring.comtroller;

import cyj.hello_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private final MemberService memberService; // 다른 컨트롤러에서도 공통적으로 사용할 수 있도록  스프링 컨테이너에 선언

    @Autowired
    //생성자에 @Autowired가 있으면 스프링이 연관된 객체를 스프링 컨테이너에서 찾아서 넣어줌
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }


}
