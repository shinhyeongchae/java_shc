package kr.green.spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.spring.service.BoardService;
import kr.green.spring.vo.BoardVO;
import kr.green.spring.vo.MemberVO;

@Controller
public class BoardController {
	@Autowired
	BoardService boardService;
	//url 등록
	@RequestMapping(value="/board/list", method=RequestMethod.GET)
	public ModelAndView boardListGet(ModelAndView mv) {
	    mv.setViewName("/board/list");
	    return mv;
	}
	
	@RequestMapping(value="/board/insert", method=RequestMethod.GET)
	public ModelAndView boardInsert(ModelAndView mv) {
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
			//System.out.println(user);
			boardService.insertBoard(board,user);
	    mv.setViewName("redirect:/board/list");
	    return mv;
	}
}
