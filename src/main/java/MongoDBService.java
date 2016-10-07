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
      // Entity persisted = Entity.getBuilder()
      //         .title(todo.getTitle())
      //         .description(todo.getDescription())
      //         .build();
      // Entity persisted = new Entity(entity.getID(), entity.getContent(), entity.favoriteNumber())
      Entity persisted = repo.save(entity);
      return persisted;
  }

  //   private EntityDTO convertToDTO(Entity model) {
  //      EntityDTO dto = new EntityDTO();
   //
  //      dto.setId(model.getId());
  //      dto.setTitle(model.getTitle());
  //      dto.setDescription(model.getDescription());
   //
  //      return dto;
  //  }

  @Override
  public List<Entity> findAll() {
      List<Entity> entityEntries = repo.findAll();
      return entityEntries;
  }

  @Override
  public Entity delete(String id){
    return null;
  }

  @Override
  public Entity findById(String id){
    return null;
  }

  @Override
  public Entity update(Entity todo){
    return null;
  }


}
