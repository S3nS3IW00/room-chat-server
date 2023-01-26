package me.s3ns3iw00.chatting.service;

import me.s3ns3iw00.chatting.model.Room;
import me.s3ns3iw00.chatting.model.User;

import java.util.List;
import java.util.Optional;

public interface RoomService {

    List<Room> findAll();

    List<User> findAllUsers(Room room);

    Optional<Room> findById(Long id);

    boolean existById(Long id);

    void save(Room room);

    void saveAll(Room... rooms);

    void remove(Room room);

    void addUser(Room room, User user);

    void removeUser(Room room, User user);

    Optional<Room> findByUser(User user);

    boolean existsByUser(User user);

}
