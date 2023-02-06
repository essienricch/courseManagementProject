package org.example.courseManagementProject.data.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User_Entity {

     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Getter
    private int userId;

     @NonNull
    private String userName;

    @NonNull
    private String emailAddress;

    @NonNull
    private String password;


    @ManyToMany
    private List <Course> course = new ArrayList<>();

    @ManyToMany
    private List <Role> roles = new ArrayList<>();




}
