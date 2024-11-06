package com.ezen.basic.service;

import java.util.List;

import com.ezen.basic.domain.BoardVO;
import com.ezen.basic.domain.Criteria;

public interface BoardService {

	String getTime();

	void create(BoardVO vo) throws Exception;

	// List<BoardVO> listAll() throws Exception;
	// List<BoardVO> listCriteria(Criteria cri) throws Exception;
	List<BoardVO> listSearch(Criteria cri) throws Exception;

	int countPaging(Criteria cri) throws Exception;

	BoardVO read(long bno) throws Exception;

	void update(BoardVO vo) throws Exception;

	void delete(long bno) throws Exception;

}
