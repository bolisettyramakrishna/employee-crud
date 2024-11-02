package example_temp.springboot_temp.repo;

import example_temp.springboot_temp.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepo extends MongoRepository<Product,Integer> {

}
