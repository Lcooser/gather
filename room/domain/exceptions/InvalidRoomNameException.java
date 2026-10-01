package com.example.gather.room.domain.exceptions;

public class InvalidRoomNameException extends RuntimeException {
    public InvalidRoomNameException() {
        super("Room name is not valid");
    }
}
