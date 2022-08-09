package kr.green.springtest.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.springtest.dao.BoardDAO;
import kr.green.springtest.vo.BoardVO;
import kr.green.springtest.vo.MemberVO;

@Service
public class BoardServiceImp implements BoardService{

	@Autowired
	BoardDAO boardDao;

	@Override
	public ArrayList<BoardVO> getBoardList() {
		return boardDao.selectBoardList();
	}

	@Override
	public BoardVO getBoard(Integer bd_num) {
		return boardDao.selectBoard(bd_num);
	}

	@Override
	public void updateViews(Integer bd_num) {
		boardDao.updateViews(bd_num);
		
	}

	@Override
	public void insertBoard(BoardVO board, MemberVO user) {
		if(board == null)
			return;
		if(user == null || user.getMe_id() == null)
			return;
		board.setBd_me_id(user.getMe_id());//게시글 작성자로 회원 아이디 저장
		boardDao.insertBoard(board); //dao에게 일을 시킴
		
	}
}
