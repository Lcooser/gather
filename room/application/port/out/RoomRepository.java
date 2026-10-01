package com.example.gather.room.application.port.out;

import com.example.gather.room.application.common.PageQuery;
import com.example.gather.room.application.common.PageResult;
import com.example.gather.room.domain.Room;

import java.util.Optional;
import java.util.UUID;


public interface RoomRepository {
    UUID create(Room room);
    PageResult<Room> findAll(PageQuery query);
    Optional<Room> findById(UUID id);
}
