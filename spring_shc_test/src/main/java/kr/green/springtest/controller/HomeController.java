package kr.green.springtest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.springtest.service.MemberService;
import kr.green.springtest.vo.MemberVO;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value= {"/"})
	public ModelAndView openTilesView(ModelAndView mv) throws Exception{
	    mv.setViewName("/main/home");
	    mv.addObject("setHeader", "타일즈");
	    System.out.println(memberService.getEmail("qwe"));
	    return mv;
	}
	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public ModelAndView signupGet(ModelAndView mv) {
		mv.setViewName("/main/signup");
		return mv;
	}
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public ModelAndView signupPOST(ModelAndView mv , MemberVO member) {
		System.out.println(member);
		if(memberService.signup(member)) {
			mv.setViewName("redirect:/");
		}else {
			mv.setViewName("redirect:/signup");
		}
		return mv;
	}
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView loginGet(ModelAndView mv) {
		mv.setViewName("/main/login");
		return mv;
	}
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ModelAndView loginPOST(ModelAndView mv, MemberVO member) {
			MemberVO dbMember = memberService.login(member);
			System.out.println("로그인중 : " + dbMember);
			mv.addObject("user", dbMember);
	    mv.setViewName("redirect:/");
	    return mv;   
	}
}

