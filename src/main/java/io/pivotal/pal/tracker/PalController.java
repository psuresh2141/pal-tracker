package io.pivotal.pal.tracker;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PalController {
   /* @RequestMapping("/{name}")
    public String sayHello(@PathVariable String name){
        String result = name+"::welcome to pal tracker application";
        return result;
    }*/
   @RequestMapping("/")
   public String sayHello(){
       return "hello";
   }

}
