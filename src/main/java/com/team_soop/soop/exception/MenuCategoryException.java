package com.team_soop.soop.exception;

import lombok.Getter;

import java.util.Map;


public class MenuCategoryException extends RuntimeException{

    @Getter
    Map<String, String> errorMap;

    public MenuCategoryException(Map<String, String> errorMap) {
        super("메뉴카테고리 오류");
        this.errorMap = errorMap;
        System.out.println(errorMap);
    }

}
