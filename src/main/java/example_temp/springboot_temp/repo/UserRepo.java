package example_temp.springboot_temp.repo;

import example_temp.springboot_temp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
}
