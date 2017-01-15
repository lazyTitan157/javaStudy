/*
 * ArticleData class
 * 설명 : 
 *  ReadArticleService클래스에 구현될 
 *  getArticle()메서드의 리턴타입
 *  Article객체와 ArticleContent객체를 한 객체에 합쳐서 담기 위한 용도
 */
package article.service;

import article.model.Article;
import article.model.ArticleContent;

public class ArticleData {

	private Article article;
	private ArticleContent content;

	public ArticleData(Article article, ArticleContent content) {
		this.article = article;
		this.content = content;
	}

	public Article getArticle() {
		return article;
	}

	public String getContent() {
		return content.getContent();
	}

}
