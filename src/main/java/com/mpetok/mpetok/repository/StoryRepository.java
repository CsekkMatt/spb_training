package com.mpetok.mpetok.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mpetok.mpetok.domain.Story;

//Hid az adatbazis es a kod kozott
//ezert felel a repository
//azert Long->Mert a Story ID - longban van tarolva
@Repository
public interface StoryRepository extends CrudRepository<Story, Long> {

  // select *
  List<Story> findAll();

  // Story findFirStory();
  // seems like the CRUD repo is not compatible with the newest
  // queries

  // JPQL nyelvet hasznal alapbol, de lehet nativeQuery-vel SQL-t is
//  @Query(value = "select * from stories where title = ?1 limit 1", nativeQuery = true)
  
//  @Query(value = "select s from Story s where s.title = :title limit 1")
  
  @Query(value = "select * from stories where title = :title limit 1", nativeQuery = true)
  Story findByTitle(@Param("title") String title);

  List<Story> findAllByBloggerNameIgnoreCaseOrderByPostedDesc(String name);

}