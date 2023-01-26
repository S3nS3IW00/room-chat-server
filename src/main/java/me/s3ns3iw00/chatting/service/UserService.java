package me.s3ns3iw00.chatting.service;


import me.s3ns3iw00.chatting.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAll();

    Optional<User> findBySessionId(String sessionId);

    boolean existsBySessionId(String sessionId);

    void save(User user);

    void saveAll(User... users);

    void remove(User user);

}
