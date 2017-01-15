/*
 * writerequest클래스 : 신규 게시글 등록에 필요한 데이터 제공(전달)
 */
package article.service;

import java.util.Map;

import article.model.Writer;

public class WriteRequest {

	private Writer writer;
	private String title;
	private String content;

	public WriteRequest(Writer writer, String title, String content) {
		this.writer = writer;
		this.title = title;
		this.content = content;
	}

	public Writer getWriter() {
		return writer;
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
