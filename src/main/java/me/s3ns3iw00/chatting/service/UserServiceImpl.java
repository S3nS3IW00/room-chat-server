package me.s3ns3iw00.chatting.service;

import me.s3ns3iw00.chatting.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final List<User> users = new ArrayList<>();

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public Optional<User> findBySessionId(String sessionId) {
        return users.stream().filter(user -> user.getSessionId().equals(sessionId)).findAny();
    }

    @Override
    public boolean existsBySessionId(String sessionId) {
        return findBySessionId(sessionId).isPresent();
    }

    @Override
    public void save(User user) {
        users.add(user);
    }

    @Override
    public void saveAll(User... users) {
        this.users.addAll(Arrays.asList(users));
    }

    @Override
    public void remove(User user) {
        users.remove(user);
    }
}
