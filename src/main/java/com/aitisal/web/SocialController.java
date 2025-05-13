package com.aitisal.web;

import com.aitisal.model.*;
import com.aitisal.repo.PostRepo;
import com.aitisal.service.FriendService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;

@Controller
public class SocialController {
    private final PostRepo postRepo;
    private final FriendService friendService;

    public SocialController(PostRepo postRepo, FriendService friendService) {
        this.postRepo = postRepo;
        this.friendService = friendService;
    }

    @GetMapping("/social/feed")
    public String feed(Model model, Principal principal) {
        User u = new User(); u.setUsername(principal.getName());
        model.addAttribute("posts",
                postRepo.findByAuthorInAndIsPublicTrue(
                        friendService.recommend(u)
                )
        );
        return "social/feed";
    }

    @GetMapping("/social/post/new")
    public String showPost(Model model) {
        model.addAttribute("post", new Post());
        return "social/create_post";
    }

    @PostMapping("/social/post/new")
    public String doPost(@ModelAttribute Post post, Principal principal) {
        post.setAuthor(new User());
        post.getAuthor().setUsername(principal.getName());
        postRepo.save(post);
        return "redirect:/social/feed";
    }
}