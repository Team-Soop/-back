package com.team_soop.soop.exception;

public class SaveException extends RuntimeException {
    public SaveException() {
        super("데이터 저장 오류.");
    }
}
