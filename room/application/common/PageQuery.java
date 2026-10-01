package com.example.gather.room.application.common;


public record PageQuery(
        int page,
        int size
        )
{
    public PageQuery{
        if(page < 0){
            throw new IllegalArgumentException("Page must be >= 0");
        }

        if(size <= 0 || size > 200){
            throw new IllegalArgumentException("Size must be between 1 and 200");
        }
    }
}
