package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
public class Application {
    // @Autowired
    // public EntityRepository repo;
    // private final EntityRepository repo;
    // private EntityRepository repo;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // public void run(String... args) throws Exception {
    //   repo.deleteAll();
    //   repo.save(new Entity("One", 1));
    //   repo.save(new Entity("Four", 4));
    // }
}
