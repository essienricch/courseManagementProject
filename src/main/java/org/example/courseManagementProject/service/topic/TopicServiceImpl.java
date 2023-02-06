package org.example.courseManagementProject.service.topic;

import org.example.courseManagementProject.data.model.Course;
import org.example.courseManagementProject.data.model.Topic;
import org.example.courseManagementProject.data.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicServiceImpl  implements  TopicService{

    private TopicRepository topicRepository;

    @Autowired
    public TopicServiceImpl(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }


    @Override
    public Topic createTopic(Topic topic, Course name) {
        return null;
    }

    @Override
    public Topic findTopic(String topicName) {
        return null;
    }

    @Override
    public List<Topic> findAllTopic() {
        return null;
    }

    @Override
    public void deleteTopic(Topic topic) {

    }
}
