package springMongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
final class MongoDBService implements EntityService {

  // private final EntityRepository repository;
  public final EntityRepository repository;

  @Autowired
  MongoDBService(EntityRepository repository){
    this.repository = repository;
  }

  @Override
  // public Entity create(Entity entity) {
  public Entity create(Entity entity) {
      Entity persisted = repository.save(entity);
      return persisted;
  }

  @Override
  public Entity delete(String id){
    Entity deleted = findEntityById(id);
    repository.delete(deleted);
    return deleted;
  }

  @Override
  public List<Entity> findAll() {
      return repository.findAll();
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
    updated = repository.save(updated);
    return updated;
  }

  private Entity findEntityById(String id){
    Entity result = repository.findOne(id);
    return result;
  }

	/**
	* Returns value of repository
	* @return
	*/
	public EntityRepository getRepository() {
		return repository;
	}
}
