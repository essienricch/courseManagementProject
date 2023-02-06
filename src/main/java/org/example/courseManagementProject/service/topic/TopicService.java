package org.example.courseManagementProject.service.topic;

import org.example.courseManagementProject.data.model.Course;
import org.example.courseManagementProject.data.model.Topic;

import java.util.List;

public interface TopicService {

    Topic createTopic(Topic topic, Course name);

    Topic findTopic(String topicName);

   List <Topic> findAllTopic();
    void deleteTopic(Topic topic);
}
