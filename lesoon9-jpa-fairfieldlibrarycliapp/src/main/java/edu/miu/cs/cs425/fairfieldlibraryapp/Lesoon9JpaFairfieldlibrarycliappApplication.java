package edu.miu.cs.cs425.fairfieldlibraryapp;

import edu.miu.cs.cs425.fairfieldlibraryapp.model.*;
import edu.miu.cs.cs425.fairfieldlibraryapp.repository.PublisherRepository;
import edu.miu.cs.cs425.fairfieldlibraryapp.service.AddressService;
import edu.miu.cs.cs425.fairfieldlibraryapp.service.BookService;
import edu.miu.cs.cs425.fairfieldlibraryapp.service.PublisherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class Lesoon9JpaFairfieldlibrarycliappApplication implements CommandLineRunner {

    @Autowired
    private PublisherService publisherService ;

    @Autowired
    private AddressService addressService ;

    @Autowired
    private BookService  bookService;

    public static void main(String[] args) {
        SpringApplication.run(Lesoon9JpaFairfieldlibrarycliappApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello world of spring boot version 3.0.2");

        System.out.println("starting FairfiledCLIAPP....");
/*
*
*
* Publisher mcgrawHill = new Publisher(null, "mcgraw-Hill publisher,Inc","493-343-3434","mcgrawHill.gmail.com",null);
        Publisher apress = new Publisher(null, " apress","123-092-1292"," apress.gmail.com",null);
        Publisher longman= new Publisher(null, "longman publisher,Inc","410-202-1234","sales@longman.gmail.com",null) ;

        var saveMcgrawHill = createNewPublisher(mcgrawHill) ;

        var saveApress = createNewPublisher(apress) ;

        var saveLongMan = createNewPublisher(longman) ;
        Publisher debas = new Publisher(null,"debesay weldu","291-123-1233","debas@eri.gamil.com",null) ;

        createNewPublisher(debas) ;


*
* */



        //createNewPublisher(new Publisher(null,null,"sa","sasasa")) ; name can not be null


     //new 4th publisher with address

//        var addison_wisely = new Publisher(null,"Addison-wisely","641 123 1234",
//                "addison@gamil.com",new Address(null,"101","Canon st",
//                "Des Moines","IA","52432", null)) ;
//
//        createNewPublisher(addison_wisely) ;
//
//
//
//
//        var publishers =  getAllPublisher() ;
//        publishers.forEach(System.out::println);


        //read publisher by id

        var publisherId = 1  ;
        var publisher = getPublisherById(publisherId) ;
        if (publisher!=null){
            System.out.println("The publisehr with id " + publisherId +  " is  --> " + publisher);
        }
        else {

            System.out.println("The publisher with id " + publisherId +  " doesn't exist");

        }

        //Add Address for macGrAW-hILL
        /*

         var mcgrawAddress = new Address(null,"1234" ,"West Collins avenue","Miami","FL","7645",null);

        //TODO save address
        var savedmacgrawAddress = addressService.addNewAddress(mcgrawAddress) ;

        var mcgrew = getPublisherById(publisherId) ;
        mcgrew.setPrimaryAddress(savedmacgrawAddress);
        publisherService.updatePublisherById(publisherId,mcgrew) ;


        * */


/**
        //TODO-->ADD NEW bOOK


         var poeaa = new Book(null ,"978-0001","patterns of EA", LocalDate.of(2020,02,12),
                10,new Money(25.00,"USD"),
                new Publisher(null,"Pearsons,Inc",null,null,null)) ;

        var savedbook = bookService.addNewBook(poeaa) ;

        System.out.println("Book saved : " + savedbook);
        */


     //TODO -->ADD BOOK AND AUTHOR

       // var annaSmith = new Author(null,"Anna","smith",null) ;
        //var boobJones = new Author(null,"Boob","Jones",null) ;














        //update

        var updatedLongman = updatePublisher(publisherId) ;

        //delete by id

       // publisherService.deletePublisherById(publisherId);




        System.out.println("FairfieldCLIAPP completed");
    }




    //CRUD operations

    //create new publisher
    private Publisher createNewPublisher(Publisher newPublisher){

        return publisherService.addNewPublisher(newPublisher) ;
    }

    //read -Get all publishers

    private Iterable<Publisher> getAllPublisher(){

        return publisherService.getAllPublishers() ;
    }

    //find publisher by ID
    private Publisher getPublisherById(Integer publisherId){

        return publisherService.getPublisherById(publisherId).orElse(null) ;
    }

    //update publisher by ID

    private Publisher updatePublisher(Integer publisherId){
        var publisher = publisherService.getPublisherById(publisherId) ;
        if (publisher.isPresent()){
            var longman= publisher.get() ;
            longman.setName("Longan Publisher ,Inc.");

            return publisherService.updatePublisherById(publisherId,longman) ;

        }

        else {
            return null ;
        }

    }

}
