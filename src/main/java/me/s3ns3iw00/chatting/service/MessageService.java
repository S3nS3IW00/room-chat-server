package me.s3ns3iw00.chatting.service;

import me.s3ns3iw00.chatting.model.Message;
import me.s3ns3iw00.chatting.model.User;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MessageService {

    List<Message> findAll();

    Optional<Message> findById(Long id);

    Optional<Message> findByRoomId(Long roomId);

    Optional<Message> findBySender(User sender);

    Optional<Message> findByDate(Date date);

    boolean existsById(Long id);

    boolean existsByRoomId(Long roomId);

    boolean existsBySender(User sender);

    boolean existsByDate(Date date);

    void save(Message message);

    void saveAll(Message... messages);

    void remove(Message message);

}
