package com.solvd.carinapractice.regres.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
}
