package com.example.last_exam.Service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.last_exam.Class.Post;

public interface PostRepository extends CrudRepository<Post, Integer> {
    List<Post> findByTagsId(int id);
}
