package me.s3ns3iw00.chatting.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.security.Principal;

@AllArgsConstructor
@Getter
@Builder
public class StompPrincipal implements Principal {

    private final String name;

    @Override
    public String getName() {
        return name;
    }
}
