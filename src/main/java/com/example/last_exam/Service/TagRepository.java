package com.example.last_exam.Service;

import org.springframework.data.repository.CrudRepository;

import com.example.last_exam.Class.Tag;

public interface TagRepository extends CrudRepository<Tag, Integer> {
    Tag findById(int id);
}
