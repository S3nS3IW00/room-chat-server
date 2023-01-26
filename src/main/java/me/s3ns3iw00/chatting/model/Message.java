package me.s3ns3iw00.chatting.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Message {

    private Long id;
    private Long roomId;
    private User sender;
    private Date date;
    private String content;

}