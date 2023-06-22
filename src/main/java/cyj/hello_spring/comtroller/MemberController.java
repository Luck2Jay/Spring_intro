package cyj.hello_spring.comtroller;

import cyj.hello_spring.domain.Member;
import cyj.hello_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    private final MemberService memberService; // 다른 컨트롤러에서도 공통적으로 사용할 수 있도록  스프링 컨테이너에 선언

    @Autowired
    //생성자에 @Autowired가 있으면 스프링이 연관된 객체를 스프링 컨테이너에서 찾아서 넣어줌
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMembersForm";
    }

    @GetMapping("/members")
    public String List(Model model){
       List<Member> members = memberService.findMembers();
       model.addAttribute("members",members);
        return "members/memberList";
    }

    @PostMapping("members/new")
    public String create(MemberForm form){

        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        //System.out.println("name is " + member.getName());

        return "redirect:/"; // 회원가입 끝나서 홈으로 보내버림
    }



}
