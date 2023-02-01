package edu.miu.cs.cs425.fairfieldlibraryapp.service;

import edu.miu.cs.cs425.fairfieldlibraryapp.model.Publisher;

import java.util.Optional;

public interface PublisherService {

    Publisher addNewPublisher(Publisher newpublisher);

    Iterable<Publisher> getAllPublishers() ;

    Optional<Publisher> getPublisherById(Integer publisherId) ;

    Publisher updatePublisherById(Integer publisherId ,Publisher updatedPublisher) ;

    String deletePublisherById(Integer publisherId) ;

    //void deletepublisherWithID(Integer publisherID) throws Exception ;




}
