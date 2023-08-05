package com.bridgelabz.demo.controller;

import com.bridgelabz.demo.dto.BookDto;
import com.bridgelabz.demo.dto.ResponseDTO;
import com.bridgelabz.demo.model.AddressBook;
import com.bridgelabz.demo.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/contact")

public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/add")
    public ResponseEntity<ResponseDTO> addContact(@Valid @RequestBody BookDto bookDto) {

        ResponseDTO responseDto = new ResponseDTO(" Contact Data added successfully", bookService.addContact(bookDto));
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @GetMapping("/getByToken")
    public ResponseEntity<ResponseDTO> getContactById(@RequestHeader String token) {
        AddressBook addressBook = bookService.getContactById(token);
        ResponseDTO responseDTO;
        HttpStatus status;
        if (addressBook != null) {

            responseDTO = new ResponseDTO("Contact Data found by Token ", addressBook);
            status = HttpStatus.OK;
        } else {

            responseDTO = new ResponseDTO("Contact Data not found by Token", null);
            status = HttpStatus.NOT_FOUND;
        }
        return new ResponseEntity<>(responseDTO, status);
    }

    @GetMapping("/getAll")
    public ResponseEntity<ResponseDTO> getAllContact() {

        List<AddressBook> addressBook = bookService.getAllContact();
        ResponseDTO responseDTO;
        HttpStatus status;
        if (!addressBook.isEmpty()) {
            responseDTO = new ResponseDTO("Contact Data Found", addressBook);
            status = HttpStatus.OK;
        } else {
            responseDTO = new ResponseDTO("Contact Data Not Found", null);
            status = HttpStatus.NOT_FOUND;
        }
        return new ResponseEntity<>(responseDTO, status);
    }
    @PutMapping("/updateByToken")
    public ResponseEntity<ResponseDTO> updateEmployee(@Valid @RequestHeader String token, @RequestBody BookDto bookDto) {

        AddressBook addressBook = bookService.updateContact(token,bookDto);
        ResponseDTO responseDTO = new ResponseDTO(" Contact Data updated successfully by Token", addressBook);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/deleteByToken")
    public ResponseEntity<ResponseDTO> deleteContact(@RequestHeader String token) {

        bookService.deleteContact(token);
        ResponseDTO responseDTO = new ResponseDTO("Contact Data deleted successfully by Token", null);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<ResponseDTO> deleteAllContact() {

        bookService.deleteAllContact();
        ResponseDTO responseDTO = new ResponseDTO("All  Contact Data deleted Successfully", null);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }




}