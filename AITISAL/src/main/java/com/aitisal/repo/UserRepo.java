package main.java.com.aitisal.repo;

import com.aitisal.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UserRepo extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
