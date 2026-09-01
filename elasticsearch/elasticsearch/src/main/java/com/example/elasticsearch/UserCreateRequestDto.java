package com.example.elasticsearch;

public class UserCreateRequestDto {
    private String id;
    private String name;
    private Long age;
    private boolean isActive;

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public Long getAge() {
        return age;
    }
    public boolean getIsActive() {
        return isActive;
    }
}
