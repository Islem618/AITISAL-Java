package com.aitisal.repo;

import com.aitisal.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PostRepo extends JpaRepository<Post,Long> {
    List<Post> findByAuthorInAndIsPublicTrue(List<User> authors);
}