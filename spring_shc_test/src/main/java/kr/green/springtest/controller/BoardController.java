package kr.green.springtest.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.springtest.vo.MemberVO;
import kr.green.springtest.service.BoardService;
import kr.green.springtest.vo.BoardVO;

@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping(value="/board/list", method=RequestMethod.GET)
	public ModelAndView boardListGet(ModelAndView mv) {
		ArrayList<BoardVO> list = boardService.getBoardList();
		mv.addObject("list",list);
    mv.setViewName("/board/list");
    return mv;
	}
	@RequestMapping(value="/board/select/{bd_num}", method=RequestMethod.GET) 
	public ModelAndView boardselectGet(ModelAndView mv, 
			@PathVariable("bd_num")Integer bd_num) {
		boardService.updateViews(bd_num);
		BoardVO board = boardService.getBoard(bd_num);
		mv.addObject("board", board);
		mv.setViewName("/board/select");
    return mv;
	}
	@RequestMapping(value="/board/insert", method=RequestMethod.GET)
	public ModelAndView boardInsertGet(ModelAndView mv) {
    mv.setViewName("/board/insert");
    return mv;
	}
	@RequestMapping(value="/board/insert", method=RequestMethod.POST)
	public ModelAndView boardInsertPost(ModelAndView mv, BoardVO board,
			HttpSession seesion) {
		 	//화면에서 전송한 데이터가 잘 오는지 확인
			//System.out.println(board); 
			//로그인한 회원 정보를 확인
			MemberVO user = (MemberVO)seesion.getAttribute("user");
			System.out.println(user);
			boardService.insertBoard(board,user);
	    mv.setViewName("redirect:/board/list");
	    return mv;
	}
	//게시글 수정기능
	@RequestMapping(value="/board/update/{bd_num}", method=RequestMethod.GET)
	public ModelAndView boardUpdateGet(ModelAndView mv,
			@PathVariable("bd_num")Integer bd_num){
		BoardVO board = boardService.getBoard(bd_num);
		mv.addObject("board",board);
    mv.setViewName("/board/update");
    return mv;
	}
	//게시글 수정기능
	@RequestMapping(value="/board/update/{bd_num}", method=RequestMethod.POST)
	public ModelAndView boardUpdatePost(ModelAndView mv,
			@PathVariable("bd_num")Integer bd_num, BoardVO board, HttpSession session) {
		MemberVO user = (MemberVO) session.getAttribute("user");
		boardService.updateBoard(board, user);
    mv.setViewName("redirect:/board/select/"+bd_num);
    return mv;
	}
	//게시글 삭제기능
	@RequestMapping(value="/board/delete/{bd_num}", method=RequestMethod.GET)
	public ModelAndView boardDeleteGet(ModelAndView mv,@PathVariable("bd_num")Integer bd_num,
			HttpSession session,BoardVO board){
		mv.setViewName("redirect:/board/list");
		//System.out.println(bd_num); //게시글번호 콘솔에서 확인작업
		MemberVO user = (MemberVO) session.getAttribute("user"); //회원정보 가져옴
		//System.out.println(user); //로그인한 회원정보 콘솔에 확인
		boardService.deleteBoard(bd_num, user);
    return mv;
	}
}
