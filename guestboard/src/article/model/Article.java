/*
 * article, article_content테이블의 데이터를 자바코드에서 표현
 * article.java, articleContent.java, writer.java
 * article클래스 : 글번호, 작성자, 제목, 등록일/수정일, 조회수
 *  작성자 정보 보관 - writer타입의 필드 정의 
 */
package article.model;

import java.util.Date;

public class Article {

	private Integer number;
	private Writer writer;
	private String title;
	private Date regDate;
	private Date modifiedDate;
	private int readCount;

	public Article(Integer number, Writer writer, String title, 
			Date regDate, Date modifiedDate, int readCount) {
		this.number = number;
		this.writer = writer;
		this.title = title;
		this.regDate = regDate;
		this.modifiedDate = modifiedDate;
		this.readCount = readCount;
	}

	public Integer getNumber() {
		return number;
	}

	public Writer getWriter() {
		return writer;
	}

	public String getTitle() {
		return title;
	}

	public Date getRegDate() {
		return regDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public int getReadCount() {
		return readCount;
	}

}
