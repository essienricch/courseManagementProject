package org.example.courseManagementProject.data.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseId;

    @NonNull
    private String courseName;

    @NonNull
    private Integer numberOfStudent;

    @OneToMany(mappedBy = "course",cascade = CascadeType.ALL, orphanRemoval = true)
    private List <Topic> topics = new ArrayList<>();


    public Course(int courseId, String courseName, int numberOfStudent) {
    }
}
