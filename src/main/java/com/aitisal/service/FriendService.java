package com.aitisal.service;

import com.aitisal.model.*;
import com.aitisal.repo.*;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class FriendService {
    private final UserRepo userRepo;
    private final FriendshipRepo friendshipRepo;

    public FriendService(UserRepo userRepo, FriendshipRepo friendshipRepo) {
        this.userRepo = userRepo;
        this.friendshipRepo = friendshipRepo;
    }

    public List<User> recommend(User u) {
        // amis directs
        List<User> direct = new ArrayList<>();
        friendshipRepo.findByFrom(u).forEach(f -> direct.add(f.getTo()));
        // amis de mes amis
        Set<User> rec = new HashSet<>();
        for (User d : direct) {
            friendshipRepo.findByFrom(d).stream()
                    .map(Friendship::getTo)
                    .filter(x -> !direct.contains(x) && !x.equals(u))
                    .forEach(rec::add);
        }
        return new ArrayList<>(rec);
    }
}