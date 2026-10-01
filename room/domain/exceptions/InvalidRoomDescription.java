package com.example.gather.room.domain.exceptions;

public class InvalidRoomDescription extends RuntimeException {
    public InvalidRoomDescription() {
        super("Room description is invalid");
    }
}
