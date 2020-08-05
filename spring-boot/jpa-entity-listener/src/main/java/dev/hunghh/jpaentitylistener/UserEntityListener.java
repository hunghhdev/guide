package dev.hunghh.jpaentitylistener;

import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Slf4j
public class UserEntityListener {

    @PrePersist
    void onPrePersist(UserEntity user) {
        log.info("PrePersist: " + user);
    }

    @PostPersist
    void onPostPersist(UserEntity user) {
        log.info("PostPersist: " + user);
    }

    @PreUpdate
    void onPreUpdate(UserEntity user) {
        log.info("PreUpdate: " + user);
    }

    @PostUpdate
    void onPostUpdate(UserEntity user) {
        log.info("PostUpdate: " + user);
    }

    @PreRemove
    void onPreRemove(UserEntity user) {
        log.info("PreRemove: " + user);
    }

    @PostRemove
    void onPostRemove(UserEntity user) {
        log.info("PostRemove: " + user);
    }

}
