/*
 * MessageListView 클래스는 
 * 요청한 페이지 번호, 요청한 페이지의 메시지 목록, 전체 메시지 개수,
 * 페이지 개수, 페이지 당 보여줄 메시지 개수 등의 정보를 담은 클래스
 * 
 * GetMessageListService는 
 * 요청한 페이지 번호에 해당하는 메시지 목록을 제공하는 getMessageList()메서드를 제공한다.
 */

package guestbook.service;

import java.util.List;

import guestbook.model.Message;

public class MessageListView {

	private List<Message> messageList;
	private int messageTotalCount;
	private int currentPageNumber;
	private int messageCountPerPage;
	private int firstRow;
	private int endRow;
	private int pageTotalCount;

	public MessageListView(List<Message> messageList, int messageTotalCount, int currentPageNumber,
			int messageCountPerPage, int firstRow, int endRow) {
		super();
		this.messageList = messageList;
		this.messageTotalCount = messageTotalCount;
		this.currentPageNumber = currentPageNumber;
		this.messageCountPerPage = messageCountPerPage;
		this.firstRow = firstRow;
		this.endRow = endRow;
		calculatePageTotalCount();
	}

	private void calculatePageTotalCount(){
		if(messageTotalCount == 0){
			pageTotalCount = 0;
		} else {
			pageTotalCount = messageTotalCount / messageCountPerPage;
			if(messageTotalCount % messageCountPerPage > 0) {
				pageTotalCount++;
			}
		}
	}
	
	public int getMessageTotalCount() {
		return messageTotalCount;
	}
	public int getCurrentPageNumber() {
		return currentPageNumber;
	}
	public List<Message> getMessageList() {
		return messageList;
	}
	public int getPageTotalCount() {
		return pageTotalCount;
	}
	public int getMessageCountPerPage() {
		return messageCountPerPage;
	}
	public int getFirstRow() {
		return firstRow;
	}
	public int getEndRow() {
		return endRow;
	}

	public boolean isEmpty(){
		return messageTotalCount == 0;
	}

}
