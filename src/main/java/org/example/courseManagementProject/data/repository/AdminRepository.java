package org.example.courseManagementProject.data.repository;

import org.example.courseManagementProject.data.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository <Admin, Integer> {

}
