package com.code.arsen.dto;

import com.code.arsen.entity.Address;
import com.code.arsen.entity.Gender;
import lombok.Data;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

@Data
public class StudentDto {

    private String firstName;
    private String lastName;
    private String email;
    private Gender gender;

    private String country;
    private String city;
    private String postCode;

    private List<String> favouriteSubject;
    private BigDecimal totalSpentBook;
    private ZonedDateTime created;
}
