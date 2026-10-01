package com.example.gather.room.application.service;

import com.example.gather.room.application.port.in.CreateRoomUseCase;
import com.example.gather.room.application.port.out.RoomRepository;
import com.example.gather.room.domain.Room;
import jakarta.transaction.Transactional;

import java.time.Clock;
import java.time.Instant;
import java.util.UUID;

public class CreateRoomService implements CreateRoomUseCase {

    private final Clock clock;
    private final RoomRepository repository;

    public CreateRoomService(Clock clock,
                             RoomRepository repository){
        this.clock = clock;
        this.repository = repository;
    }


    @Override
    @Transactional
    public UUID execute(Command command){
        Instant now = clock.instant();

        Room newRoom = Room.create(
                command.name(),
                command.capacity(),
                command.description(),
                command.minimumAge(),
                now
        );

        return repository.create(newRoom);
    }


}
