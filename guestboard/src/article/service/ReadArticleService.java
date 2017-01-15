/*
 * ReadArticleService 클래스
 * 데이터가 없음을 의미하는 익셉션 클래스 구현
 *  : ArticleNotFoundException() //article테이블에 데이터가 없다.
 *    ArticleContentNotFoundException() //article_content테이블에 데이터가 없다.
 */
package article.service;

import java.sql.Connection;
import java.sql.SQLException;

import article.dao.ArticleContentDao;
import article.dao.ArticleDao;
import article.model.Article;
import article.model.ArticleContent;
import jdbc.connection.ConnectionProvider;

public class ReadArticleService {

	private ArticleDao articleDao = new ArticleDao();
	private ArticleContentDao contentDao = new ArticleContentDao();
	
	public ArticleData getArticle(int articleNum, boolean increaseReadCount) {
		try (Connection conn = ConnectionProvider.getConnection()){
			//article테이블에서 article객체
			Article article = articleDao.selectById(conn, articleNum);
			//article 데이터가 존재하지 않는 경우 익셉션 발생
			if (article == null) {
				throw new ArticleNotFoundException();
			}
			//article-content테이블에서 article content객체
			ArticleContent content = contentDao.selectById(conn, articleNum);
			//article content 데이터 없으면 익셉션발생
			if (content == null) {
				throw new ArticleContentNotFoundException();
			}
			
			//읽으면(increaseReadCount) 조회수 1증가
			if (increaseReadCount) {
				articleDao.increaseReadCount(conn, articleNum);
			}
			//article과 article-content를 합친 articleData객체를 리턴
			return new ArticleData(article, content);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
