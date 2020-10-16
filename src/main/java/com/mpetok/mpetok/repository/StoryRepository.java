package com.mpetok.mpetok.repository;

import java.util.List;

import com.mpetok.mpetok.domain.Story;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//Hid az adatbazis es a kod kozott
//ezert felel a repository
//azert Long->Mert a Story ID - longban van tarolva
@Repository
public interface StoryRepository extends CrudRepository<Story,Long>{
    
    //select *
    List<Story> findAll();

    // Story findFirStory();
    //seems like the CRUD repo is not compatible with the newest 
    //queries

    Story findByTitle(String title);

}