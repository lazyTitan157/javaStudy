/*
 * article, article_content테이블의 데이터를 자바코드에서 표현
 * article.java, articleContent.java, writer.java
 * articleContent 클래스 : 글번호, 내용 저장
 *  글번호는 DB의 article_no로 article 클래스와 연결 
 */
package article.model;

public class ArticleContent {

	private Integer number;
	private String content;

	public ArticleContent(Integer number, String content) {
		this.number = number;
		this.content = content;
	}

	public Integer getNumber() {
		return number;
	}

	public String getContent() {
		return content;
	}

}
