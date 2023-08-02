package org.example.courseManagementProject.data.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AppUser {

     @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

     private String username;

    private String email;

    @JsonIgnore
    private String password;

    private String phoneNumber;
    private Gender gender;
    @OneToOne(cascade = CascadeType.ALL)
    private Address contactAddress;

    private boolean isVerified = false;
    @Enumerated(EnumType.STRING)
    private Set <Role> roles;
    private String profileImg;

    @CreationTimestamp
    private LocalDateTime createdAt;






}
