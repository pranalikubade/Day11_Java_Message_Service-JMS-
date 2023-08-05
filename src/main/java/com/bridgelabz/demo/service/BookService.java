package com.bridgelabz.demo.service;

import com.bridgelabz.demo.dto.BookDto;
import com.bridgelabz.demo.dto.ResponseDTO;
import com.bridgelabz.demo.exception.CustomException;
import com.bridgelabz.demo.model.AddressBook;
import com.bridgelabz.demo.repo.BookRepo;
import com.bridgelabz.demo.token.EmailService;
import com.bridgelabz.demo.token.Jwt_token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class BookService implements BookService_Interface {
    @Autowired
    private BookRepo bookRepo;
    @Autowired
    private Jwt_token jwt_token;
    @Autowired
    private EmailService emailService;

    @Override
    public ResponseDTO addContact(BookDto bookDto) {
        AddressBook addressBookData = new AddressBook(bookDto);
        bookRepo.save(addressBookData );
        String token = jwt_token.createToken(addressBookData.getId());
        emailService.sendEmail(bookDto.getEmail(), " Contact Data added successfully",
                "Hi " + bookDto.getName() + "\n Your data has been added Successfully \n\n" + addressBookData );
        return new ResponseDTO(token, addressBookData );

    }
    @Override
    public AddressBook updateContact(String token,BookDto bookDto) {
        AddressBook contactData = getContactById(token);
        if (contactData == null) {
            throw new IllegalArgumentException("Contact not found with token: " + token);
        }
        contactData.updateContact(bookDto);
        return bookRepo.save(contactData);
    }

    @Override
    public void deleteContact(String token) {
        AddressBook contactData = getContactById(token);
        if (contactData == null) {
            throw new IllegalArgumentException("Contact not found with token: " + token);
        }
        bookRepo.deleteById(Integer.valueOf(token));
    }

    @Override
    public void deleteAllContact() {
        bookRepo.deleteAll();
    }
    @Override
    public AddressBook getContactById(String token) {
        int id = jwt_token.decodeToken(token);
        return bookRepo.findById(id).orElseThrow(() -> new CustomException("Contact with token: " + id + "not present"));
    }

    @Override
    public List<AddressBook> getAllContact() {
        return bookRepo.findAll();
    }
}

