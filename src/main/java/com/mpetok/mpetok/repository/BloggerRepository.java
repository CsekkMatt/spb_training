package com.mpetok.mpetok.repository;

import java.util.List;

import com.mpetok.mpetok.domain.Blogger;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//Hid az adatbazis es a kod kozott
//ezert felel a repository
//azert Long->Mert a Story ID - longban van tarolva
@Repository
public interface BloggerRepository extends CrudRepository<Blogger,Long>{
    
    List<Blogger> findAll();


}