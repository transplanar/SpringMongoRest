package springMongo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

	private final EntityRepository repository;
	private final EntityService service;


	@Autowired
	public DatabaseLoader(MongoDBService service) {
		this.service = service;
		this.repository = service.repository;
	}

	@Override
	public void run(String... strings) throws Exception {
		this.repository.save(new Entity("sample content", 4000));
	}
}
