package org.example.courseManagementProject.data.repository;

import org.example.courseManagementProject.data.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TopicRepository extends JpaRepository <Topic, Integer> {

    Topic findTopicByTopicName(String topicName);
}
