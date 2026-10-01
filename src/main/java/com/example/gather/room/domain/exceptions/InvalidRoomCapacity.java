package com.example.gather.room.domain.exceptions;

public class InvalidRoomCapacity extends RuntimeException {
    public InvalidRoomCapacity() {
        super("Room capacity is invalid");
    }
}
