package com.qsj.pojo;

import java.util.Date;

public class view {
	private int id;
	private String title;
	private String content;
	private String creat_by;
	private Date create_time;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreat_by() {
		return creat_by;
	}
	public void setCreat_by(String creat_by) {
		this.creat_by = creat_by;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	@Override
	public String toString() {
		return "view [id=" + id + ", title=" + title + ", content=" + content + ", creat_by=" + creat_by
				+ ", create_time=" + create_time + "]";
	}
	
}
