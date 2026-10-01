package com.example.gather.room.domain.exceptions;

public class CapacityBelowCurrentOccupancyException
        extends RuntimeException {

    public CapacityBelowCurrentOccupancyException(
            int desiredCapacity,
            int usersSignedUp) {

        super(
                "The new capacity cannot be lower than the current number " +
                        "of signed-up users. Current users: " + usersSignedUp +
                        ", desired capacity: " + desiredCapacity
        );
    }
}
