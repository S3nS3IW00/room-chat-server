package me.s3ns3iw00.chatting.controller;

import me.s3ns3iw00.chatting.model.APIResponse;
import me.s3ns3iw00.chatting.model.Room;
import me.s3ns3iw00.chatting.service.RoomServiceImpl;
import me.s3ns3iw00.chatting.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/v1/room")
public class RoomController {

    private final AtomicLong roomIdentifier = new AtomicLong(0);

    @Autowired
    private RoomServiceImpl roomService;


    @GetMapping
    public APIResponse getAllRoom() {
        return APIResponse.ok(roomService.findAll());
    }

    @GetMapping(path = "/{id}")
    public APIResponse existsRoom(@PathVariable("id") Long id) {
        if (!roomService.existById(id)) {
            return APIResponse.badRequest("No room with the given id");
        }
        return APIResponse.ok(null);
    }

    @PutMapping()
    public APIResponse createRoom() {
        long id = roomIdentifier.incrementAndGet();
        roomService.save(Room.builder().id(id).build());
        System.out.println("Room has been created with id: " + id);
        return APIResponse.ok(new HashMap<>(Map.of("roomId", id)));
    }

}
