/*
 * 게시글을 수정하기 위해 필요한 정보
 *  : 게시글 번호, 수정하는 사용자의 아이디, 수정할 제목과 내용데이터
 */
package article.service;

import java.util.Map;

public class ModifyRequest {

	private String userId;
	private int articleNumber;
	private String title;
	private String content;

	public ModifyRequest(String userId, int articleNumber, String title, String content) {
		this.userId = userId;
		this.articleNumber = articleNumber;
		this.title = title;
		this.content = content;
	}

	public String getUserId() {
		return userId;
	}

	public int getArticleNumber() {
		return articleNumber;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public void validate(Map<String, Boolean> errors) {
		if (title == null || title.trim().isEmpty()) {
			errors.put("title", Boolean.TRUE);
		}
	}

}
