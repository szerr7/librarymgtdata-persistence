package edu.miu.cs.cs425.fairfieldlibraryapp.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
@Table(name = "publishers")
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer publisherId ;


    //@NotNull(message = "publisher cant be null") ;
    //@NotEmpty(message = "publisher cant be empty or null")

    @NotBlank(message = "publisher name can not  be blank or empty or null")
    @Column(name = "publisher_name",nullable = false)
    private String name ;


     private String contactNumber ;

    private String emailAddress ;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "primary_address_id",nullable = true)
    private Address primaryAddress ;



    //private List<Book> books ;-->if bidirectional ;



    public Address getPrimaryAddress() {
        return primaryAddress;
    }

    public void setPrimaryAddress(Address primaryAddress) {
        this.primaryAddress = primaryAddress;
    }

    public Publisher() {
        this(null,null,null,null,null) ;
    }

    public Publisher(Integer publisherId, String name, String contactNumber, String emailAddress,Address primaryAddress) {
        this.publisherId = publisherId;
        this.name = name;
        this.contactNumber = contactNumber;
        this.emailAddress = emailAddress;
        this.primaryAddress = primaryAddress ;
    }

    public Integer getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Integer publisherId) {
        this.publisherId = publisherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "publisherId=" + publisherId +
                ", name='" + name + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", primaryAdress='" + primaryAddress + '\'' +
                '}';
    }
}
