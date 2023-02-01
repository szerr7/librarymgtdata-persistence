package edu.miu.cs.cs425.fairfieldlibraryapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer addressId ;
    private String houseNo ;
    private String street ;
    private String city;
    private String state ;
    private String zipCode;

    @OneToOne(mappedBy = "primaryAddress")
    private Publisher publisher ;


    @Override
    public String toString() {
        return "Address{" +
                ", houseNo='" + houseNo + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}
