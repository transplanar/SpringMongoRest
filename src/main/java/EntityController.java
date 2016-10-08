package hello;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.concurrent.atomic.AtomicLong;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// REVIEW Needed???
import javax.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/entity")
public class EntityController {
    private final EntityService service;
    private static final Logger LOGGER = LoggerFactory.getLogger(EntityController.class);

    @Autowired
    EntityController(EntityService service){
      this.service = service;
    }

    // TODO change to use format of tutorial for logging
    //  https://github.com/pkainulainen/java-advent-2014/blob/master/src/main/java/com/javaadvent/bootrest/todo/TodoController.java
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    // Entity create(@RequestBody @Valid Entity entry) {
    Entity create(@RequestBody Entity entry) {
    // Entity create(@Valid Entity entry) {
        LOGGER.info("Creating entity using {}", entry);
        return service.create(entry);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    Entity delete(@PathVariable("id") String id) {
        LOGGER.info("Deleting entity with id {}", id);
        return service.delete(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    List<Entity> findAll() {
        LOGGER.info("Retrieving all entities in database");
        return service.findAll();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    Entity findById(@PathVariable("id") String id) {
        LOGGER.info("Finding entity with id {}", id);
        LOGGER.info("Found " + service.findById(id));
        return service.findById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    // Entity update(@RequestBody @Valid Entity entry) {
    Entity update(@RequestBody Entity entry) {
    // Entity update(@Valid Entity todoEntry) {
        LOGGER.info("Updating entity using {}", entry);
        return service.update(entry);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleEntityNotFound(NotFoundException ex) {
    }
}
