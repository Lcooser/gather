package com.example.gather.room.domain.exceptions;

public class InvalidRoomMinimumAge extends RuntimeException {
    public InvalidRoomMinimumAge() {
        super("Room minimum age is invalid");
    }
}
