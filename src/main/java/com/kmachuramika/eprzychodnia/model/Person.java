package com.kmachuramika.eprzychodnia.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class Person {

    private String firstName;
    private String middleName;
    private String lastName;
    private String pesel;
    private String documentNumber;

}
