package edu.miu.cs.cs425.fairfieldlibraryapp.service.Imp;

import edu.miu.cs.cs425.fairfieldlibraryapp.model.Publisher;
import edu.miu.cs.cs425.fairfieldlibraryapp.repository.PublisherRepository;
import edu.miu.cs.cs425.fairfieldlibraryapp.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class PublisherServiceImpl implements PublisherService {


    @Autowired
    private PublisherRepository publisherRepository ;




    @Override
    public Publisher addNewPublisher(Publisher newpublisher) {
        return publisherRepository.save(newpublisher);
    }

    @Override
    public Iterable<Publisher> getAllPublishers() {
        return publisherRepository.findAll() ;
    }

    @Override
    public Optional<Publisher> getPublisherById(Integer publisherId) {
        return publisherRepository.findById(publisherId);
    }

    @Override
    public Publisher updatePublisherById(Integer publisherId, Publisher updatedPublisher) {

        var thePublisher = publisherRepository.findById(publisherId).orElse(null) ;
        Publisher newUpdatedPublisher = null ;

        if (thePublisher!=null){
            thePublisher.setName(updatedPublisher.getName());
            thePublisher.setContactNumber(updatedPublisher.getContactNumber());
            thePublisher.setEmailAddress(updatedPublisher.getEmailAddress());
            thePublisher.setPrimaryAddress(updatedPublisher.getPrimaryAddress());

            return publisherRepository.save(thePublisher);
        }

        return newUpdatedPublisher ;

    }

    @Override
    public String deletePublisherById(Integer publisherId) {
        var thePublisher = publisherRepository.findById(publisherId).orElse(null) ;
        if (thePublisher!=null){

            publisherRepository.deleteById(publisherId);

            return String.format("publisher with ID" + publisherId + "has been deleted");
        }

        return "The id with ID" + publisherId +"doesnt exist" ;

    }
}
