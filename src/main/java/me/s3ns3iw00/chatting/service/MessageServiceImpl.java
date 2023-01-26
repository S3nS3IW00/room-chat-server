package me.s3ns3iw00.chatting.service;

import me.s3ns3iw00.chatting.model.Message;
import me.s3ns3iw00.chatting.model.User;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MessageServiceImpl implements MessageService {

    private final List<Message> messages = new ArrayList<>();

    @Override
    public List<Message> findAll() {
        return messages;
    }

    @Override
    public Optional<Message> findById(Long id) {
        return messages.stream().filter(message -> message.getId().equals(id)).findAny();
    }

    @Override
    public Optional<Message> findByRoomId(Long roomId) {
        return messages.stream().filter(message -> message.getRoomId().equals(roomId)).findAny();
    }

    @Override
    public Optional<Message> findBySender(User sender) {
        return messages.stream().filter(message -> message.getSender().equals(sender)).findAny();
    }

    @Override
    public Optional<Message> findByDate(Date date) {
        return messages.stream().filter(message -> message.getDate().equals(date)).findAny();
    }

    @Override
    public boolean existsById(Long id) {
        return findById(id).isPresent();
    }

    @Override
    public boolean existsByRoomId(Long roomId) {
        return findByRoomId(roomId).isPresent();
    }

    @Override
    public boolean existsBySender(User sender) {
        return findBySender(sender).isPresent();
    }

    @Override
    public boolean existsByDate(Date date) {
        return findByDate(date).isPresent();
    }

    @Override
    public void save(Message message) {
        messages.add(message);
    }

    @Override
    public void saveAll(Message... messages) {
        this.messages.addAll(Arrays.asList(messages));
    }

    @Override
    public void remove(Message message) {
        messages.remove(message);
    }
}
