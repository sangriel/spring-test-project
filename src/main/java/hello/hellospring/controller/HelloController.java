package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data","hello");

        //컨틀롤러에서 문자값 리턴시 viewresolver가 화면을 찾아서 처리한다.
        //hello.html
        return "hello";
    }



    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name",required = false) String name, Model model) {
        model.addAttribute("name",name);
        return "hello-template";
    }


    @GetMapping("hello-string")
    @ResponseBody //http body에 응답을 직접 넣어주겠다는 의미
    public String helloString(@RequestParam("name") String name){
        //view 랑 템플릿 엔진을 거치지 않고 그냥 string으로 그대로 내려줌
        return "hello " + name;
    }


    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        //이렇게 하면 결과로 json format으로 떨어짐
        //@ResponsBody가 붙어 있으면 view를 찾지 않고 HttpMessageConverter(Json Converter, String Converter)를 통해서 반환됨
        return hello;
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
