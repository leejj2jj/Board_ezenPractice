package com.ezen.basic.domain;

// 페이징 기능, 검색 기능을 위한 클래스
public class SearchCriteria extends Criteria {

	// 디폴트 생성자 자동 생성.

	private String searchType; // 검색법 종류
	private String keyword; // 검색어

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	// 부모 클래스인 Criteria의 private 필드 정보를 읽어 오기 위한 getter.
	@Override
	public String toString() {
		return "SearchCriteria [searchType=" + searchType + ", keyword=" + keyword + ", getPage()=" + getPage() + ", getPerPageNum()="
				+ getPerPageNum() + "]";
	}

}
