package com.rest.api.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
public class Users {

    public Users(){

    }

    @Id
    @GeneratedValue( strategy = GenerationType.TABLE)
    @JsonIgnore
    private Long id;

    private String name;

    private String lastname;

}
