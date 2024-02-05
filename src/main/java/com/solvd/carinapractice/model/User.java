package com.solvd.carinapractice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    @JsonProperty("id")
    private long id;
    private String firstName;
    private String lastName;
    private String email;
}
