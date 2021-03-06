package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
final class MongoDBService implements EntityService {

  private final EntityRepository repo;

  @Autowired
  MongoDBService(EntityRepository repo){
    this.repo = repo;
  }

  @Override
  // public Entity create(Entity entity) {
  public Entity create(Entity entity) {
      Entity persisted = repo.save(entity);
      return persisted;
  }

  @Override
  public Entity delete(String id){
    Entity deleted = findEntityById(id);
    repo.delete(deleted);
    return deleted;
  }

  @Override
  public List<Entity> findAll() {
      return repo.findAll();
  }


  @Override
  public Entity findById(String id){
    return findEntityById(id);
  }

  @Override
  public Entity update(Entity entity){
    Entity updated = findEntityById(entity.getId());
    updated.setContent(entity.getContent());
    updated.setFavoriteNumber(entity.getFavoriteNumber());
    updated = repo.save(updated);
    return updated;
  }

  private Entity findEntityById(String id){
    Entity result = repo.findOne(id);
    return result;
  }


}
