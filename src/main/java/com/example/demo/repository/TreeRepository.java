package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Tree;

public interface TreeRepository extends CrudRepository<Tree, Long> {

}
