package hello;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface EntityRepository extends MongoRepository<Entity, String> {

    // public Entity findByContent(String content);
    void delete(Entity deleted);
    List<Entity> findAll();
    Entity findOne(String id);
    Entity save(Entity saved);
}
