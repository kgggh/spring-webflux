package com.flux.community.controller;

import com.flux.community.model.entity.Post;
import com.flux.community.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostRepository postRepository;


    @PostMapping("/posts")
    public Mono<Post> addPost(@RequestBody Post post) {
        return postRepository.save(post);
    }

    @GetMapping("/posts")
    public Flux<Post> getPosts() {
        return postRepository.findAll();
    }

    @GetMapping("/posts/{id}")
    public Mono<Post> getPost(@PathVariable Long id) {
        return postRepository.findById(id);
    }

    @DeleteMapping("/posts/{id}")
    public Mono<Void> deletePost(@PathVariable Long id) {
        return postRepository.deleteById(id);
    }

    @PatchMapping("/posts/{id}")
    public  Mono<Post> updatePost(@PathVariable Long id,
                                  @RequestBody Post post) {
        return postRepository.findById(id)
                .map(p -> {
                    p.update(post.getTitle(), post.getContent());
                    return p;
                })
                .flatMap(p-> postRepository.save(p));
    }
}
