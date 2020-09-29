/**
 * 
 */
package kr.or.connect.domain;

/**
 * @author 2983r
 *
 */
public class Book {

	private Integer id;
	private String author;
	private String title;
	private Integer pages;
	
	
	
	/**
	 * Default Constructor
	 */
	public Book() {
		//super();
	}

	/**
	 * @param author
	 * @param title
	 * @param pages
	 */
	public Book(String author, String title, Integer pages) {
		//super();
		this.author = author;
		this.title = title;
		this.pages = pages;
	}

	/**
	 * @param id
	 * @param author
	 * @param title
	 * @param pages
	 */
	public Book(Integer id, String author, String title, Integer pages) {
		this(title, author, pages);
		this.id = id;
	}
	
	//단축키 Alt + Shift + s, r
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the pages
	 */
	public Integer getPages() {
		return pages;
	}
	/**
	 * @param pages the pages to set
	 */
	public void setPages(Integer pages) {
		this.pages = pages;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * 단축키 Alt + Shift + s, s
	 */
	@Override
	public String toString() {
		return "Book [id=" + id + ", author=" + author + ", title=" + title + ", pages=" + pages + "]";
	}
	
	
}
