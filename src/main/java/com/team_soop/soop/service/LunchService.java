package com.team_soop.soop.service;

import com.team_soop.soop.aop.annotation.ParamsPrintAspect;
import com.team_soop.soop.dto.*;
import com.team_soop.soop.entity.*;
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

    // 런치상세페이지 DB들고오기
    @Transactional(rollbackFor = Exception.class)
    public List<SearchLunchRespDto> searchLunchList () {
        List<LunchList> lunchLists = lunchMapper.searchLunchList();

        List<SearchLunchRespDto> searchLunchRespDtos = new ArrayList<>();

        for(LunchList LunchList : lunchLists) {
            searchLunchRespDtos.add(LunchList.toSearchLunchRespDto());
        }

        return searchLunchRespDtos;
    }

    // 런치 상세페이지 댓글 들고오기
    @Transactional(rollbackFor = Exception.class)
    public List<SearchLunchCommentRespDto> searchLunchComment1 (int detailLunchId) {
        List<LunchComment> lunchComments = lunchMapper.searchLunchComment(detailLunchId);

        List<SearchLunchCommentRespDto> searchLunchCommentRespDtos = new ArrayList<>();

        for(LunchComment lunchComment  : lunchComments) {
            searchLunchCommentRespDtos.add(lunchComment.toSearchLunchCommentRespDto());
        }

        return searchLunchCommentRespDtos;
    }

    // 런치 상세페이지 댓글 수정
    @Transactional(rollbackFor = Exception.class)
    public void updateComment(UpdateLunchCommentReqDto updateLunchCommentReqDto) {
        lunchMapper.modifyComment(updateLunchCommentReqDto.toLunchComment());
    }

    // 런치 상세페이지 댓글 삭제
    @Transactional(rollbackFor = Exception.class)
    public void deleteComment(int commentId){
        lunchMapper.deleteComment(commentId);
    }

    // 런치 좋아요, 추천 등록
    @Transactional(rollbackFor = Exception.class)
    public void saveLunchLike(int userId, int lunchId) {
        lunchMapper.saveLunchLike(LunchLike.builder().userId(userId).lunchId(lunchId).build());
    }

    // 런치 좋아요, 추천 상태 get
    @Transactional(rollbackFor = Exception.class)
    public LikeStatus getLikeStatus(int userId, int lunchId) {
        return lunchMapper.getLikeLunchStatus(userId, lunchId);
    }

    // 런치 좋아요,추천 취소
    @Transactional(rollbackFor = Exception.class)
    public void unLikeLunch(int userId, int lunchId) {
        lunchMapper.deleteLunchLike(LunchLike.builder().userId(userId).lunchId(lunchId).build());
    }


}
