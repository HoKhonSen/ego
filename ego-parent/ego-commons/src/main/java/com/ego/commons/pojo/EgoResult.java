package com.ego.commons.pojo;

public class EgoResult {
	private int status;
	private Object data;

	public int getStatus() {
		return status;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
}
