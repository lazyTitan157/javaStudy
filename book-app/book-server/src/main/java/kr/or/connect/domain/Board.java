/**
 * 
 */
package kr.or.connect.domain;

/**
 * @author 2983r
 *
 */
public class Board {

	private Integer id;
	private String author;
	private String title;
	private String writeDate;
	private String contents;
	
	/**
	 * Default Constructor
	 */
	public Board() {
		//super();
	}

	/**
	 * @param author
	 * @param title
	 * @param pages
	 */
	public Board(String author, String title, String contents, String writeDate) {
		//super();
		this.author = author;
		this.title = title;
		this.contents = contents;
		this.writeDate = writeDate;
	}

	/**
	 * @param id
	 * @param author
	 * @param title
	 * @param pages
	 */
	public Board(Integer id, String author, String title, String contents, String writeDate) {
		this(title, author, contents, writeDate);
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
	 * @return the writeDate
	 */
	public String getWriteDate() {
		return writeDate;
	}

	/**
	 * @param writeDate the writeDate to set
	 */
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}

	/**
	 * @return the contents
	 */
	public String getContents() {
		return contents;
	}

	/**
	 * @param contents the contents to set
	 */
	public void setContents(String contents) {
		this.contents = contents;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Board [id=" + id + ", author=" + author + ", title=" + title + ", writeDate=" + writeDate
				+ ", contents=" + contents + "]";
	}
	
	
}
