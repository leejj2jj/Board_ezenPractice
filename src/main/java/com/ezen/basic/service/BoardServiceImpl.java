package com.ezen.basic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.basic.domain.BoardVO;
import com.ezen.basic.domain.Criteria;
import com.ezen.basic.mapper.BoardMapper;

@Service // boardServiceImpl 이름으로 bean 생성
public class BoardServiceImpl implements BoardService {

	@Autowired // 의존성 주입
	private BoardMapper boardMapper;

	@Override
	public String getTime() {
		return boardMapper.getTime();
	}

	@Override
	public void create(BoardVO vo) throws Exception {
		boardMapper.create(vo);
	}

	/*
	@Override
	public List<BoardVO> listAll() throws Exception {
		return boardMapper.listAll();
	}
	*/

	@Override
	public BoardVO read(long bno) throws Exception {
		// 조회 수 증가
		boardMapper.addViewCount(bno);
		return boardMapper.read(bno);
	}

	@Override
	public void update(BoardVO vo) throws Exception {
		boardMapper.update(vo);
	}

	@Override
	public void delete(long bno) throws Exception {
		boardMapper.delete(bno);
	}

	// @Override // cri -> [searchType=null, keyword=null, getPage()=1, getPerPageNum()=10]
	// public List<BoardVO> listCriteria(Criteria cri) throws Exception {
	// 	return boardMapper.listCriteria(cri);
	// }

	@Override
	public int countPaging(Criteria cri) throws Exception {
		return boardMapper.countPaging(cri);
	}

	@Override
	public List<BoardVO> listSearch(Criteria cri) throws Exception {
		return boardMapper.listSearch(cri);
	}

}
