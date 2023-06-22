package cyj.hello_spring.comtroller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class  HelloController {

    //웹프라우저에서 localhost:8080/hello를 입력하면 get방식으로 mapping & 스프링부트 내장 톰캣 서버 띄움
    @GetMapping("hello") // hello로 되어 있는 Controller를 찾아 메서드가 실행됨
    public String hello(Model model){
        model.addAttribute("data","Yupoong!!"); //mvc의 m &  메서드는 model에 addAttribute로 key가 data인 Yupoong!!을
        return "hello"; // value에 담고 "hello"리턴
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){ //외부에서 파라미터 받기 위해 requestParam
        model.addAttribute("name",name); // key, name
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody //http의 헤더와 바디 중 바디에 이 데이터를 직접 넣겠다는 의미
    public String helloMvc(@RequestParam("name") String name){ //외부에서 파라미터 받기 위해 requestParam
         return "hello" + name; //hello 변수로 바뀌어서 보임
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


}
