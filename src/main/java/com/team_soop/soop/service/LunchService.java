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

        lunchMapper.saveLunch(lunch);

        if( saveLunchReqDto.getLunchImgUrls().size() == 0){
            return;
        }
        lunchMapper.saveLunchImgUrl(lunch.getLunchId(), saveLunchReqDto.getLunchImgUrls());



    }





}
