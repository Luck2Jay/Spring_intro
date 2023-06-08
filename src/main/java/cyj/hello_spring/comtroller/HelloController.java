package cyj.hello_spring.comtroller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class  HelloController {
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","Yupoong!!"); //mvc의 m
        return "hello";
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
