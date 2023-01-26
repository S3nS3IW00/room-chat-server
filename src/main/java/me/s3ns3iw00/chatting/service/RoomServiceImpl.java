package me.s3ns3iw00.chatting.service;

import me.s3ns3iw00.chatting.model.Room;
import me.s3ns3iw00.chatting.model.User;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RoomServiceImpl implements RoomService {

    private final List<Room> rooms = new ArrayList<>();

    @Override
    public List<Room> findAll() {
        return rooms;
    }

    @Override
    public List<User> findAllUsers(Room room) {
        return room.getUsers();
    }

    @Override
    public Optional<Room> findById(Long id) {
        return rooms.stream().filter(room -> room.getId().equals(id)).findAny();
    }

    @Override
    public boolean existById(Long id) {
        return findById(id).isPresent();
    }

    @Override
    public void save(Room room) {
        rooms.add(room);
    }

    @Override
    public void saveAll(Room... rooms) {
        this.rooms.addAll(Arrays.asList(rooms));
    }

    @Override
    public void remove(Room room) {
        rooms.remove(room);
    }

    @Override
    public void addUser(Room room, User user) {
        room.getUsers().add(user);
    }

    @Override
    public void removeUser(Room room, User user) {
        room.getUsers().remove(user);
    }

    @Override
    public Optional<Room> findByUser(User user) {
        return rooms.stream().filter(room -> room.getUsers().contains(user)).findAny();
    }

    @Override
    public boolean existsByUser(User user) {
        return findByUser(user).isPresent();
    }
}
