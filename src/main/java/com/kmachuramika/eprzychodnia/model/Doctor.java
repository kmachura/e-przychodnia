package com.kmachuramika.eprzychodnia.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Doctor extends Person {

    private UUID id = UUID.randomUUID();
    private Type type = Type.DOCTOR;
    private Specialisation specialisation;

}
