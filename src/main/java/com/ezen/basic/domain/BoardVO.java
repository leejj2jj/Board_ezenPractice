package com.ezen.basic.domain;

import java.util.Date;

// 사용자가 데이터를 입력했을 때
// 게시판 테이블의 데이터를 읽어 올 때
public class BoardVO {

	// 필드: 테이블의 칼럼명과 동일하게 생성해야 작업이 편해진다.
	private Long bno;
	private String title;
	private String content;
	private String writer;
	private Date regdate; // 패키지 java.util
	private Date updatedate; // 패키지 java.util
	private int viewcount;

	// getter, setter 메서드
	public Long getBno() {
		return bno;
	}

	public void setBno(Long bno) {
		this.bno = bno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public Date getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}

	public int getViewcount() {
		return viewcount;
	}

	public void setViewcount(int viewcount) {
		this.viewcount = viewcount;
	}

	// 힙 영역에 생성된 필드의 값을 확인하는 용도로 사용.
	@Override
	public String toString() {
		return "BoardVO [bno=" + bno + ", title=" + title + ", content=" + content + ", writer=" + writer + ", regdate=" + regdate + ", updatedate="
				+ updatedate + ", viewcount=" + viewcount + "]";
	}

}
