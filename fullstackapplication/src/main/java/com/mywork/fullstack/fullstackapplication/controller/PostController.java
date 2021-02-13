package com.mywork.fullstack.fullstackapplication.controller;

import com.mywork.fullstack.fullstackapplication.model.Post;
import com.mywork.fullstack.fullstackapplication.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins="http://localhost:8081")
@RestController
@RequestMapping("/api/posts")
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping({"id"})
    public ResponseEntity<Post>post(@PathVariable String id){
        Optional<Post> post=postService.findById(id);
        return post.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Post> list(@RequestParam(required=false) String title){
        if(StringUtils.isEmpty())
    }
}
