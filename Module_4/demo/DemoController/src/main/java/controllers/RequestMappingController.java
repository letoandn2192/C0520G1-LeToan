package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("hello")
public class RequestMappingController {

//    @RequestMapping(value = {"","/index"}, method = RequestMethod.GET, consumes ="text/html", produces = "application/json")
//    public String getHelloPage(){
//        System.out.println("DELETE");
//        return "/hello";
//    }
    @GetMapping(value = {"","/index"})
    public String getHelloPage(@RequestParam("id") int id,
                               @RequestParam("name") String name){
        System.out.println(id);
        System.out.println(name);
        return "/hello";
    }

    //viet tat
//    @GetMapping(value = {"","/index"})
//    public String getHelloPage(@RequestParam int id, String name){
//        System.out.println(id);
//        System.out.println(name);
//        return "/hello";
//    }


    @GetMapping(value = {"","/index/{id}/{name}"})
    public String getHelloPage3(@PathVariable("id") int id, @PathVariable("name") String name){
        System.out.println(id);
        System.out.println(name);
        return "/hello";
    }
}
