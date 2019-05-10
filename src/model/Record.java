package model;

import java.util.Date;


public class Record {
	private Date date;
	private int score;
	private boolean won;
	private String time;
	private Record next;

	public Record(Date date, int score, boolean won, String time, Record next) {
		this.date = date;
		this.score = score;
		this.won = won;
		this.time = time;
		this.next = next;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public boolean isWon() {
		return won;
	}
	public void setWon(boolean won) {
		this.won = won;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Record getNext() {
		return next;
	}
	public void setNext(Record next) {
		this.next = next;
	}
	
	
	
	
	
}


