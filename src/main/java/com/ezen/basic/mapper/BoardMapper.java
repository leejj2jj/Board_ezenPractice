package com.ezen.basic.mapper;

import java.util.List;

import com.ezen.basic.domain.BoardVO;
import com.ezen.basic.domain.Criteria;

// com.ezen.basic 패키지의 Study04Application.java 파일에서 Mapper 인터페이스 패키지 정보를 설정해야 한다.
// 그리고 스프링이 살행되면, Mapper 인터페이스를 구현한 Proxy 클래스 객체가 생성되어 주입 작업(DI)에 사용된다.
// boardMapper.xml 파일을 생성해야 한다. 그리고 <mapper namespace="com.ezen.basic.mapper.BoardMapper"> 설정.
public interface BoardMapper {

	String getTime();

	void create(BoardVO vo) throws Exception;

	// List<BoardVO> listAll() throws Exception;
	// cri -> [searchType=null, keyword=null, getPage()=1, getPerPageNum()=10]
	// List<BoardVO> listCriteria(Criteria cri) throws Exception;
	List<BoardVO> listSearch(Criteria cri) throws Exception;

	// 테이블 데이터 총개수
	int countPaging(Criteria cri) throws Exception;

	BoardVO read(long bno) throws Exception;

	void update(BoardVO vo) throws Exception;

	void addViewCount(long bno) throws Exception;

	void delete(long bno) throws Exception;

}
