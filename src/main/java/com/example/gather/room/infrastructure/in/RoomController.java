package com.example.gather.room.infrastructure.in;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/rooms")
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService){
        this.roomService = roomService;
    }

    @GetMapping
    public ResponseEntity<Page<RoomResponse>> getRooms(@RequestParam(defaultValue = "0") int page,
                                                       @RequestParam(defaultValue = "10") int size,
                                                       @RequestParam(defaultValue = "id") String sortBy,
                                                       @RequestParam(defaultValue = "asc") String direction){

        Page<RoomResponse> roomsPage = roomService.getAllRooms(pageable);
        return ResponseEntity.ok(roomsPage);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomResponse> getRoomById(@PathVariable("id") UUID id){
        RoomResponse room =  roomService.getRoomById(id);
        return ResponseEntity.ok(room);
    }

    @PostMapping
    public void createRoom(@RequestBody RoomRequest room){
        roomService.createRoom(room);
        ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public void updateRoom(@RequestParam UUID id,
                           @RequestBody RoomRequest room){
        roomService.updateRoom(room);
        ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{id}")
    public void deleteRoomById(@RequestParam UUID id){
        roomService.deleteRoom(id);
        ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
