package springMongo;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

// import javax.validation.Valid;

import java.util.List;

@RestController
// @RequestMapping("/api/entity")
@RequestMapping("/api")
public class EntityController {
    private final EntityService service;
    // private static final Logger LOGGER = LoggerFactory.getLogger(EntityController.class);

    @Autowired
    EntityController(EntityService service){
      this.service = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    Entity create(@RequestBody Entity entry) {
        return service.create(entry);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    Entity delete(@PathVariable("id") String id) {
        return service.delete(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    List<Entity> findAll() {
        return service.findAll();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    Entity findById(@PathVariable("id") String id) {
        return service.findById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    Entity update(@RequestBody Entity entry) {
        return service.update(entry);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleEntityNotFound(NotFoundException ex) {
    }
}
