package com.bridgelabz.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class BookDto {
    @NotBlank(message = "Name is required")
    @Pattern(regexp = "^[A-Z]{1}[A-Za-z\\s]{2,}$", message = " Invalid Name")
    public String name;
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Invalid email format")
    public String email;

   // @Pattern(regexp = ^(?:(?:\+91)|(?:91)|(?:0))[7-9][0-9]{9}$", message = "Invalid Phone Number")
    public String phoneNumber;

    @Pattern(regexp = "^[A-Z]{1}[A-Za-z\\s]{2,}$", message = "Enter Valid City Name")
    public String city;

    @Pattern(regexp = "^[A-Z]{1}[A-Za-z\\s]{2,}$", message = "Enter Valid State Name")
    public String state;

    @NotBlank(message = "Address is required")
    @NotEmpty
    public String address;

    @Pattern(regexp = "^[1-9]{1}[0-9]{2}\\s{0,1}[0-9]{3}$",message="Enter Valid Pin Number  ")
    public String pin;
}
