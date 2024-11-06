package com.ezen.basic.domain;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

//         1  2  3  4  5  [next]
// [prev]  6  7  8  9  10
public class PageMaker {

	private int totalCount; // 테이블의 총데이터 개수
	private int startPage; // 각 블럭의 시작 페이지값
	private int endPage; // 각 블럭의 마지막 페이지값
	private boolean prev; // 이전 블럭 표시 여부
	private boolean next; // 다음 블럭 표시 여부

	private int displayPageNum = 10; // 블럭에 보여줄 페이지 번호 개수; 1 2 3 4 5...

	private Criteria cri; // page, perPageNum

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount; // 테이블의 총데이터 개수가 13개.

		calcData();
	}

	// 페이징 기능에 필요한 계산
	private void calcData() {

		// 사용자가 displayPageNum = 10인 상태에서
		/*
		 * 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29
		 * 30
		 */

		// (int) (Math.ceil(1 / 10.0) * 10); => (int) (1.0 * 10) => 10
		endPage = (int) (Math.ceil(cri.getPage() / (double) displayPageNum) * displayPageNum);

		// (10 - 10) + 1;
		startPage = (endPage - displayPageNum) + 1;

		// 테이블 총데이터 개수를 참조해, 출력할 실제 endPage값. totalCount = 13
		// int tempEndPage = (int) (Math.ceil(13 / 10.0)); => int tempEndPage = (int)
		// (Math.ceil(1.3));
		// => int tempEndPage = (int) 2.0; => int tempEndPage = 2;
		int tempEndPage = (int) (Math.ceil(totalCount / (double) cri.getPerPageNum()));

		if (endPage > tempEndPage) {
			endPage = tempEndPage;
		}

		prev = startPage == 1 ? false : true;

		next = endPage * cri.getPerPageNum() >= totalCount ? false : true;
	}

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public boolean isNext() {
		return next;
	}

	public int getDisplayPageNum() {
		return displayPageNum;
	}

	public Criteria getCri() {
		return cri;
	}

	public void setCri(Criteria cri) {
		this.cri = cri;
	}

	public String makeQuery(int page) {
		UriComponents uriComponents = UriComponentsBuilder.newInstance()
				.queryParam("perPageNum", cri.getPerPageNum())
				.build();

		return uriComponents.toUriString();
	}

	// 페이징, 검색 기능 사용 시 필요한 파라미터 생성
	// ?page=?page=2&perPageNum=10&searchType&keyword, 쿼리 스트링
	public String makeSearch(int page) {
		UriComponents uriComponents = UriComponentsBuilder.newInstance()
				.queryParam("page", page)
				.queryParam("perPageNum", cri.getPerPageNum())
				.queryParam("searchType", ((SearchCriteria) cri).getSearchType())
				.queryParam("keyword", ((SearchCriteria) cri).getKeyword())
				.build();

		return uriComponents.toUriString();
	}

	@Override
	public String toString() {
		return "PageMaker [totalCount=" + totalCount + ", startPage=" + startPage + ", endPage=" + endPage + ", prev=" + prev + ", next=" + next
				+ ", displayPageNum=" + displayPageNum + ", cri=" + cri + "]";
	}

}
