package com.example.gather.room.domain;

import com.example.gather.room.domain.exceptions.*;

import java.time.Instant;
import java.util.*;

public class Room {

    private final UUID id;
    private String name;
    private int capacity;
    private String description;
    private int minimumAge;
    private Instant updatedAt;
    private boolean isDeleted;
    private final Map<UUID, RoomParticipant> participants;

    private final Instant createdAt;

    private static final int  MINIMUM_CHARACTERS = 5;

    private Room(UUID id,
                String name,
                int capacity,
                String description,
                int minimumAge,
                boolean isDeleted,
                Instant createdAt,
                Instant updatedAt){

        this.id = Objects.requireNonNull(id);
        this.name = Objects.requireNonNull(name);
        this.capacity = capacity;
        this.description = description;
        this.minimumAge = minimumAge;
        this.participants = new HashMap<>(Objects.requireNonNull(participants));
        this.createdAt = Objects.requireNonNull(createdAt);
        this.updatedAt = Objects.requireNonNull(updatedAt);
    }

    public static Room create(String name, int capacity, String description, int minimumAge, Instant now){

        validateName(name);
        validateCapacity(capacity);
        validateMinimumAge(minimumAge);
        validateDescription(description);

        boolean isDeleted = false;

        return new Room(UUID.randomUUID(),
                name,
                capacity,
                description,
                minimumAge,
                isDeleted,
                now,
                now);
    }

    public static Room rehydrate(UUID id, String name, int capacity, String description, int minimumAge, boolean isDeleted, Instant createdAt, Instant updatedAt){

        return new Room(
                id,
                name,
                capacity,
                description,
                minimumAge,
                isDeleted,
                createdAt,
                updatedAt
        );

    }


    private void touch(Instant now){
        updatedAt = now;
    }

    private static void validateName(String name){
        if(name == null || name.isBlank()){
            throw new InvalidRoomNameException();
        }
    }

    private static void validateMinimumAge(int minimumAge){
        if(minimumAge < 15){
            throw new InvalidRoomMinimumAge();
        }
    }

    private static void validateCapacity(int capacity){
        if(capacity <= 0){
            throw new InvalidRoomCapacity();
        }
    }

    private static void validateDescription(String description){
        if(description == null ||
                description.isBlank() ||
                description.length() < MINIMUM_CHARACTERS){

            throw new InvalidRoomDescription();
        }
    }

    public void close(){
        if(isDeleted == false){
            isDeleted = true;
        }
    }

    public void open(){
        if(isDeleted == true){
            isDeleted = false;
        }
    }


    public void rename(String name, Instant now){
        validateName(name);

        this.name = name;
        touch(now);
    }


    public void changeCapacity(int newCapacity, Instant now){
        validateCapacity(newCapacity);

        int usersSignedUp = participants.size();

        if(newCapacity < usersSignedUp){
            throw new CapacityBelowCurrentOccupancyException(
                    newCapacity,
                    usersSignedUp
            );
        }

        this.capacity = newCapacity;
        touch(now);
    }

    public UUID id(){
        return id;
    }

    public String name(){
        return name;
    }

    public int capacity(){
        return capacity;
    }


}
