package com.aitisal.repo;

import com.aitisal.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FriendshipRepo extends JpaRepository<Friendship,Long> {
    List<Friendship> findByFrom(User from);
}