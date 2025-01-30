package com.springsecurity.securedoc.event;

import com.springsecurity.securedoc.entity.UserEntity;
import com.springsecurity.securedoc.enumeration.EventType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

//
 /// 1/25/24
//

@Getter
@Setter
@AllArgsConstructor
public class UserEvent {
    private UserEntity user;
    private EventType type;
    private Map<?, ?> data;
}