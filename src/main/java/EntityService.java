package springMongo;

import java.util.List;

interface EntityService {

    Entity create(Entity todo);

    Entity delete(String id);

    List<Entity> findAll();

    Entity findById(String id);

    Entity update(Entity todo);
}
