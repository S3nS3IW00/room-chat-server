package me.s3ns3iw00.chatting.event;

import me.s3ns3iw00.chatting.model.User;
import me.s3ns3iw00.chatting.service.RoomServiceImpl;
import me.s3ns3iw00.chatting.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
public class ChatSocketEventListener {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private RoomServiceImpl roomService;

    @Autowired
    private SimpMessagingTemplate template;

    @EventListener
    public void handleSocketConnect(SessionConnectEvent event) {
        SimpMessageHeaderAccessor headers = SimpMessageHeaderAccessor.wrap(event.getMessage());

        userService.save(User.builder().sessionId(headers.getSessionId()).principal(headers.getUser()).build());
        System.out.printf("User connected: %s (%s)\n", headers.getUser().getName(), headers.getSessionId());
    }

    @EventListener
    public void handleSocketDisconnect(SessionDisconnectEvent event) {
        userService.findBySessionId(event.getSessionId()).ifPresent(user -> {
            roomService.findByUser(user).ifPresent(room -> {
                roomService.removeUser(room, user);
                room.getUsers().forEach(roomUser -> template.convertAndSendToUser(roomUser.getPrincipal().getName(), "/leave", user.getPrincipal().getName()));
            });
            userService.remove(user);
        });
        System.out.printf("User disconnected: %s (%s)\n", event.getUser().getName(), event.getSessionId());
    }

}
