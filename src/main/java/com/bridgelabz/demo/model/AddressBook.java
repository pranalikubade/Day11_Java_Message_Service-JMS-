package com.bridgelabz.demo.model;

import com.bridgelabz.demo.dto.BookDto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Table(name = "Java_Message_Service")
@Data
public class AddressBook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    private String state;
    private String city;
    private String pin;
    public AddressBook(BookDto bookDto) {
        this.updateContact(bookDto);
    }
    public void updateContact(BookDto bookDto) {
        this.name = bookDto.getName();
        this.email = bookDto.getEmail();
        this.phoneNumber = bookDto.getPhoneNumber();
        this.address = bookDto.getAddress();
        this.state = bookDto.getState();
        this.city = bookDto.getCity();
        this.pin = bookDto.getPin();

    }


}
