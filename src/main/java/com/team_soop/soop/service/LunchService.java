package com.team_soop.soop.service;

import com.team_soop.soop.dto.SaveLunchReqDto;
import com.team_soop.soop.entity.Lunch;
import com.team_soop.soop.repository.LunchMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LunchService {

    @Autowired
    private LunchMapper lunchMapper;

    @Transactional(rollbackFor =  Exception.class)
    public void saveLunch(SaveLunchReqDto saveLunchReqDto) {
        Lunch lunch = saveLunchReqDto.toLunch();

        // lunch page 글작성시 lunch_tb 에 insert into
        lunchMapper.saveLunch(lunch);

        // lunch page 글작성시 img 올릴시 lunch_img_url_tb 에 저장
        // list size() 가 0 이면 if문 실행 x
        if( saveLunchReqDto.getLunchImgUrls().size() != 0 ){
            lunchMapper.saveLunchImgUrl(lunch.getLunchId(), saveLunchReqDto.getLunchImgUrls());
        }

        // 카테고리 int 번호로 받아온걸 -> string 으로 변환
        if ( saveLunchReqDto.getLunchCategories().size() != 0 ){
            lunchMapper.saveLunchCategory(lunch.getLunchId(), saveLunchReqDto.getCategoryName());
        }

    }





}
