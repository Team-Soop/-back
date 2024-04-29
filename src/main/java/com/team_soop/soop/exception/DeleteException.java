package com.team_soop.soop.exception;

import lombok.Getter;

import java.util.Map;

public class DeleteException extends RuntimeException{


    public DeleteException() {
        super("삭제 오류");
    }
}
