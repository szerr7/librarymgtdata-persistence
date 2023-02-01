package edu.miu.cs.cs425.fairfieldlibraryapp.repository;

import edu.miu.cs.cs425.fairfieldlibraryapp.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PublisherRepository extends CrudRepository<Publisher,Integer> {

    Optional<Publisher> getPublisherByName(String name) ; //Query method

    @Query(value = "select p from Publisher p where p.name = :name")
    Optional<Publisher> whatEverMethodNamefindPublisherUsingName(String name) ;



    @Query(value = "SELECT * FROM `cs425-swe-fairfieldlibrarydb` .publishers p  where p.name like '%name%' ",nativeQuery = true )
    Optional<Publisher> whatEverMethodNamefindPublisherUsingName2(String name) ;





}
