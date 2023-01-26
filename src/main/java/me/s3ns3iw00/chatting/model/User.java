package me.s3ns3iw00.chatting.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.security.Principal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class User {

    private String sessionId;
    private Principal principal;

}
