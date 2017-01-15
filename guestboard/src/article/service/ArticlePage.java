/*
 * 게시글 데이터와 페이징 관련 정보
 */
package article.service;

import java.util.List;

import article.model.Article;

public class ArticlePage {

	private int total;
	private int currentPage;
	private List<Article> content;
	private int totalPages;
	private int startPage;
	private int endPage;

	public ArticlePage(int total, int currentPage, int size, List<Article> content) {
		this.total = total;
		this.currentPage = currentPage;
		this.content = content;
		//게시글 수가 0개인 경우, 모두 0으로 세팅
		if (total == 0) {
			totalPages = 0;
			startPage = 0;
			endPage = 0;
		} else {
			// 전체 게시글 수를 한페이지에 보여줄 게시글수로 나눠서 전체 페이지 개수 계산
			totalPages = total / size;
			if (total % size > 0) {
				totalPages++;
			}
			//화면 하단에 보여줄 페이지 이동링크의 시작번호(1부터 5까지)
			int modVal = currentPage % 5;
			startPage = currentPage / 5 * 5 + 1;
			if (modVal == 0) startPage -= 5;
			
			//화면 하단에 보여줄 페이지 이동링크의 끝 번호 (1부터 5까지)
			endPage = startPage + 4;
			if (endPage > totalPages) endPage = totalPages;
		}
	}

	public int getTotal() {
		return total;
	}

	public boolean hasNoArticles() {
		return total == 0;
	}

	public boolean hasArticles() {
		return total > 0;
	}
	
	public int getCurrentPage() {
		return currentPage;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public List<Article> getContent() {
		return content;
	}

	public int getStartPage() {
		return startPage;
	}
	
	public int getEndPage() {
		return endPage;
	}
}
