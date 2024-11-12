package me.ayushdhar.ProductService.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sample")
public class SampleController {

    @GetMapping("/helloworld")
    public String sayHello(){return "Hello World!";}

    @GetMapping("/hello/{string}")
    public String hiFella(@PathVariable String string) {
        return "Hi " + string + "!";
    }

    @GetMapping("/hello/{name}/{times}")
    public String getHellos(@PathVariable("name") String name,
                            @PathVariable("times") int time) {
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < time; i++) {
            str.append("Hello ").append(name).append("</br>");
        }
        return str.toString();
    }
}
