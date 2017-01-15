/*
 * article, article_content테이블의 데이터를 자바코드에서 표현
 * article.java, articleContent.java, writer.java
 * writer클래스 : 게시글 작성자 정보를 담는 클래스
 *  작성자의 아이디와 이름값 저장 
 */
package article.model;

public class Writer {

	private String id;
	private String name;

	public Writer(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}
