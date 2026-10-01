package com.example.gather.room.application.port.in;


import java.util.UUID;

public interface CreateRoomUseCase {

    Result execute(Command command);

    record Command(String name,
                   int capacity,
                   String description,
                   int minimumAge){}

    record Result(
            UUID roomId
    ){}
}

