package org.example.courseManagementProject.data.model;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonUnwrapped
    private AppUser appUser;

    private String firstName;

    private String lastName;
    @OneToMany(fetch = FetchType.EAGER)
    private Set <Course> courses;
    @CreationTimestamp
    private LocalDateTime enrollmentDate;
}
