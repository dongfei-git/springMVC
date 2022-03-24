package tech.dongfei.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/hello")
public class RequestMappingController {
    @RequestMapping(
            value = {"/postTest"},  // 404
            method = {RequestMethod.GET, RequestMethod.POST},  // 405
            params = {"username=admin","password!=123456"},  //params的条件必须同时满足, 400
            headers = {"Host=localhost:8080"}  // 404
    )
    public String success(){
        return "success";
    }

    @RequestMapping("/a?a/testAnt")  //?:匹配任意单个字符|*:任意多个字符|path1/**/path2:任意多层目录
    public String testAnt(){
        return "success";
    }

    @RequestMapping("/testPath/{id}/{username}")  // localhost:8080/springmvc/hello/testPath/121/admin
    public String testPath(@PathVariable("id")Integer id,@PathVariable("username")String username){
        System.out.println("id:"+id);  //id:121
        System.out.println("username:"+username);  //username:admin
        return "success";
    }

}
