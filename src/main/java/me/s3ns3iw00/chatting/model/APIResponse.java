package me.s3ns3iw00.chatting.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class APIResponse {

    private final int code;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Object data;

    public APIResponse(HttpStatus status, String message, Object data) {
        this.code = status.value();
        this.message = message;
        this.data = data;
    }

    public static APIResponse ok(Object data) {
        return new APIResponse(HttpStatus.OK, null, data);
    }

    public static APIResponse error(HttpStatus status, String message) {
        return new APIResponse(status, message, null);
    }

    public static APIResponse badRequest(String message) {
        return APIResponse.error(HttpStatus.BAD_REQUEST, message);
    }

}
