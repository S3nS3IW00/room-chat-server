package me.s3ns3iw00.chatting.controller;

import me.s3ns3iw00.chatting.model.Message;
import me.s3ns3iw00.chatting.model.Room;
import me.s3ns3iw00.chatting.model.User;
import me.s3ns3iw00.chatting.service.MessageServiceImpl;
import me.s3ns3iw00.chatting.service.RoomServiceImpl;
import me.s3ns3iw00.chatting.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

@Controller
public class ChatSocketController {

    private final AtomicLong messageIdentifier = new AtomicLong(0);

    @Autowired
    private MessageServiceImpl messageService;

    @Autowired
    private RoomServiceImpl roomService;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private SimpMessagingTemplate template;

    @MessageMapping("/room.join")
    public void joinRoom(@Payload Long id, SimpMessageHeaderAccessor accessor) {
        Room room = roomService.findById(id).get();
        roomService.addUser(room, userService.findBySessionId(accessor.getSessionId()).get());

        room.getUsers().forEach(user -> template.convertAndSendToUser(user.getPrincipal().getName(), "/join", accessor.getUser().getName()));
    }

    @MessageMapping("/room.send")
    public void sendMessage(@Payload String content, SimpMessageHeaderAccessor accessor) {
        User sender = userService.findBySessionId(accessor.getSessionId()).get();
        Room room = roomService.findByUser(sender).get();
        Message message = Message.builder()
                .id(messageIdentifier.incrementAndGet())
                .roomId(room.getId())
                .sender(sender)
                .date(new Date())
                .content(content)
                .build();

        room.getUsers().forEach(user -> template.convertAndSendToUser(user.getPrincipal().getName(), "/message", message));
    }

}
