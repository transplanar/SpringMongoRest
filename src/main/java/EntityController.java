package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EntityController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public String test() {
      return "Done";
    }
    // public Entity greeting(@RequestParam(value="name", defaultValue="World") String name) {
    //     return new Entity(counter.incrementAndGet(),
    //                         String.format(template, name));
    // }
}
