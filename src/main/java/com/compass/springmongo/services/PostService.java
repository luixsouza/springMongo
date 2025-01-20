package com.compass.springmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compass.springmongo.domain.Post;
import com.compass.springmongo.repository.PostRepository;
import com.compass.springmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(String id) {
        Optional<Post> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
        }

    public List<Post> findByTitle(String text) {
        return repo.searchTitle(text);
    }

}
