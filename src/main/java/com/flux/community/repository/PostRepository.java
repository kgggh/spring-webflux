package com.flux.community.repository;

import com.flux.community.model.entity.Post;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface PostRepository extends ReactiveCrudRepository<Post, Long> {
    @Override
    Flux<Post> findAll();
}
