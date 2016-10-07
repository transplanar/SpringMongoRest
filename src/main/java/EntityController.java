package hello;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EntityController {
    private final EntityService service;

    @Autowired
    EntityController(EntityService service){
      this.service = service;
    }

    @RequestMapping("/greeting")
    // public Entity findAll() {
    public List<Entity> findAll() {
      service.create(new Entity("One", 1));
      service.create(new Entity("Two", 2));
      service.create(new Entity("Four", 4));

      // return "Done";
      // return repo;
      // public void run(String... args) throws Exception {
      //   repo.deleteAll();
      //   repo.save(new Entity("One", 1));
      //   repo.save(new Entity("Four", 4));
      // }
      return service.findAll();
    }
}
