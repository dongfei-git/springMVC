package tech.dongfei.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tech.dongfei.mvc.bean.User;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ParamTestController {

    @RequestMapping("/testServletAPI")
    // 形参位置的request表示当前请求
    public String testServletAPI(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username:"+username+",password:"+password);
        return "test_param";
    }

//    @RequestMapping("testParam")
//    //通过控制器的形参获取参数
//    public String testParam(String username,String password){
//        System.out.println("username:"+username+",password:"+password);
//        return "test_param";
//    }

    @RequestMapping("/testParam")
    public String testParam(
            @RequestParam(value = "user_name", defaultValue = "admin") String username,
            @RequestParam(value = "pass_word ",required = false)String password,
            @RequestHeader(value = "Host")String host  // 获取请求头信息
    ){
        System.out.println("username:"+username+",password:"+password);
        System.out.println("HOST:"+host);
        return "test_param";
    }

    @RequestMapping("/testBean")
    // 通过实体类获取请求参数，保证请求参数的名字和实体类的属性名字一致
    public String testBean(User user){
        System.out.println(user);
        return "test_param";
    }


}
