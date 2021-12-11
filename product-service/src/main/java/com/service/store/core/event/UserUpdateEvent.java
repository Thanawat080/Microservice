package com.service.store.core.event;

import lombok.Data;

@Data
public class UserUpdateEvent {
    private String id;
    private String username;
}
