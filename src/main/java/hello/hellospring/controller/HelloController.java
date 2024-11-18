package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    // @ResponseBody 문자 반환
    @GetMapping("hello-string")
    @ResponseBody // 뷰 리졸버(viewResolver)를 사용하지 않고 HTTP의 BODY에 문자 내용 직접 반환
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name;
    }

    // @ResponseBody 객체 반환
    @GetMapping("hello-api")
    @ResponseBody
    public Hello hello(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
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
