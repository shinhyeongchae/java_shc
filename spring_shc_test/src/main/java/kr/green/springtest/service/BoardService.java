package kr.green.springtest.service;

import java.util.ArrayList;

import kr.green.springtest.vo.BoardVO;
import kr.green.springtest.vo.MemberVO;

public interface BoardService {

	ArrayList<BoardVO> getBoardList();

	BoardVO getBoard(Integer bd_num);

	void updateViews(Integer bd_num);

	void insertBoard(BoardVO board, MemberVO user);



}
