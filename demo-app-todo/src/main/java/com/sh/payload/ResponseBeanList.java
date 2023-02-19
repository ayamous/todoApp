package com.sh.payload;

public class ResponseBeanList<T, Y> {

	private String status;
	private String message;
	private Integer totalElements;
	private Y length;
	private T content;

	public ResponseBeanList(String status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getContent() {
		return content;
	}

	public void setContent(T content) {
		this.content = content;
	}

	public Y getLength() {
		return length;
	}

	public void setLength(Y length) {
		this.length = length;
	}

	public Integer getTotalElements() {
		return totalElements;
	}

	public void setTotalElements(Integer totalElements) {
		this.totalElements = totalElements;
	}

}
