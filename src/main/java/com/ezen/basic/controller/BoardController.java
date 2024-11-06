package com.ezen.basic.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ezen.basic.domain.BoardVO;
import com.ezen.basic.domain.PageMaker;
import com.ezen.basic.domain.SearchCriteria;
import com.ezen.basic.service.BoardService;

@Controller // boardController 이름으로 bean 생성
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Autowired
	private BoardService boardService;

	@ResponseBody
	@GetMapping("/getTime")
	public String getTime() {
		return boardService.getTime();
	}

	@GetMapping("") // 기본 주소; localhost:8888
	public String main() {
		return "index";
	}

	@GetMapping("/register")
	public void registerGET() throws Exception {
		logger.info("registered");
	}

	// 글 저장. 사용자가 입력한 데이터를 BoardVO vo로 받겠다는 의미.
	@PostMapping("/register") // 스프링이 Board vo = new BoardVO() 자동 생성
	public String registerPOST(BoardVO vo) throws Exception {
		logger.info(vo.toString());
		boardService.create(vo);
		return "redirect:/list";
	}

	// 글 목록. 게시판 테이블의 내용을 불러오는 작업.
	/*
	@GetMapping("/list")
	public void listAll(Model model) throws Exception {
		List<BoardVO> list = boardService.listAll();
		model.addAttribute("list", list);
	}
	*/

	// 글 목록(페이징, 검색) 포함.
	// localhost:8888/list 첫 접속: SearchCriteria [searchType=null, keyword=null, getPage()=1, getPerPageNum()=10]
	// 페이지 번호 클릭 시 http://localhost:8888/list?page=?page=1&perPageNum=10&searchType&keyword
	@GetMapping("/list") // 작업 1
	// 파라미터를 JSP에서 쓰게 해주는 작업
	// 1. @ModelAttribute("param") Param param
	// 2. Model model / model.addAttribute("parma", param);
	public void listPage(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {
		logger.info(cri.toString());

		// 1) 목록에 사용할 데이터
		List<BoardVO> list = boardService.listSearch(cri);
		model.addAttribute("list", list);

		// 2) 페이징 기능; 1  2  3  4  5
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);

		pageMaker.setTotalCount(boardService.countPaging(cri)); // 테이블 데이터 총개수

		model.addAttribute("pageMaker", pageMaker);
	}

	// 글 조회(상세 내용) 보기. 게시물 번호에 해당하는 글을 DB에서 가져오기.
	@GetMapping(value = { "/readPage", "/modifyPage" })
	public void read(long bno, Model model) throws Exception {
		logger.info("게시물 번호: " + bno);
		BoardVO boardVO = boardService.read(bno);
		model.addAttribute("boardVO", boardVO);
	}

	// 글 수정하기.
	@PostMapping("/update")
	public String modifyPOST(BoardVO vo) throws Exception {
		logger.info("수정 데이터: " + vo);
		boardService.update(vo);
		return "redirect:/readPage?bno=" + vo.getBno();
	}

	// 글 삭제하기.
	@GetMapping("/delete")
	public String delete(long bno) throws Exception {
		logger.info("삭제 글 번호: " + bno);
		boardService.delete(bno);
		return "redirect:/list";
	}
}
