package org.example.courseManagementProject.data.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;



    private String expertise;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private AppUser user;

}
