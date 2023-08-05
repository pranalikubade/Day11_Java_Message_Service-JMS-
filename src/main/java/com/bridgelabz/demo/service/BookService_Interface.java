package com.bridgelabz.demo.service;

import com.bridgelabz.demo.dto.BookDto;
import com.bridgelabz.demo.dto.ResponseDTO;
import com.bridgelabz.demo.model.AddressBook;

import java.util.List;

public interface BookService_Interface {
    ResponseDTO addContact(BookDto bookDto );

    AddressBook updateContact(String token, BookDto bookDto );

    void deleteContact(String token );

    void deleteAllContact();

    AddressBook getContactById(String token);

    List<AddressBook> getAllContact();

}
