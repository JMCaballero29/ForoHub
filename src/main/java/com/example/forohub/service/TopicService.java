package com.example.forohub.service;

import com.example.forohub.model.Topic;
import com.example.forohub.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    public Topic createTopic(Topic topic) {
        if (topicRepository.existsByTitleAndMessage(topic.getTitle(), topic.getMessage())) {
            throw new RuntimeException("Duplicate topic");
        }
        return topicRepository.save(topic);
    }

    public List<Topic> listTopics() {
        return topicRepository.findAll();
    }

    public Optional<Topic> getTopic(Long id) {
        return topicRepository.findById(id);
    }

    public Topic updateTopic(Long id, Topic updatedTopic) {
        Optional<Topic> optionalTopic = topicRepository.findById(id);
        if (optionalTopic.isPresent()) {
            Topic topic = optionalTopic.get();
            topic.setTitle(updatedTopic.getTitle());
            topic.setMessage(updatedTopic.getMessage());
            topic.setStatus(updatedTopic.getStatus());
            topic.setAuthor(updatedTopic.getAuthor());
            topic.setCourse(updatedTopic.getCourse());
            return topicRepository.save(topic);
        } else {
            throw new RuntimeException("Topic not found");
        }
    }

    public void deleteTopic(Long id) {
        if (topicRepository.existsById(id)) {
            topicRepository.deleteById(id);
        } else {
            throw new RuntimeException("Topic not found");
        }
    }
}
