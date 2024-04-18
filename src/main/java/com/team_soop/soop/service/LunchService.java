package com.team_soop.soop.service;

import com.team_soop.soop.dto.SaveLunchCommentReqDto;
import com.team_soop.soop.dto.SaveLunchReqDto;
import com.team_soop.soop.dto.SearchLunchRespDto;
import com.team_soop.soop.entity.Lunch;
import com.team_soop.soop.entity.LunchComment;
import com.team_soop.soop.entity.LunchList;
import com.team_soop.soop.repository.LunchMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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

    // 런치상세페이지 댓글 입력
    @Transactional(rollbackFor =  Exception.class)
    public void saveLunchComment(SaveLunchCommentReqDto saveLunchCommentReqDto) {
        LunchComment lunchComment = saveLunchCommentReqDto.toLunchComment();


        lunchMapper.saveLunchComment(lunchComment);
    }

    // 런치페이지, 런치상세페이지 DB들고오기
    @Transactional(rollbackFor = Exception.class)
    public List<SearchLunchRespDto> searchLunchList () {
        List<LunchList> lunchLists = lunchMapper.searchLunchList();

//        for(LunchList lunchList : lunchLists) {
//            List<LunchComment> lunchComments = lunchList.getLunchComment();
//            for(LunchComment lunchComment : lunchComments) {
//                 lunchMapper.searchLunchComment(lunchComment.getLunchCommentUserId());
//            }
//        }


        List<SearchLunchRespDto> searchLunchRespDtos = new ArrayList<>();

        for(LunchList LunchList : lunchLists) {
            searchLunchRespDtos.add(LunchList.toSearchLunchRespDto());
        }

        return searchLunchRespDtos;
    }

    // 런치 상세페이지 댓글 들고오기
//    @Transactional(rollbackFor = Exception.class)
//    public List<LunchComment> searchLunchComment (int detailLunchId) {
//        List<LunchComment> lunchComments = lunchMapper.searchLunchComment(detailLunchId);
//
//    }






}
