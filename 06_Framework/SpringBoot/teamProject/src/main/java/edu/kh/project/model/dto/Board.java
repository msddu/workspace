package edu.kh.project.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Board {
	
    private int boardNo;
    private String boardTitle;
    private String boardContent;
    private String writeDate;
    private String boardUpdateDate;
    private int boardCount;
    private String boardDelFl;
    private int memberNo;
    private int boardCode;
    
    // 목록 조회, 상세 조회 시 매핑되는 필드
    private int commentCount; // 댓글 수
    private int likeCount; // 좋아요 수
    private String memberNickname; // 작성자 닉네임
    private String thumbnail; // 썸네일 이미지 경로

    private String profileImg; // 게시글 작성자 프로필 이미지



}