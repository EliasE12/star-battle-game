package model;

import java.util.Date;


public class Record {

	public enum Result {VICTORIA, DERROTA};

	private Record next;

	private Date date;
	private int score;
	private boolean won;
	private String time;
	private Result result;


	public Record(Date date, int score, boolean won, String time, Result result) {
		this.date = date;
		this.score = score;
		this.won = won;
		this.time = time;
		this.result = result;

		next = null;
	}


	public Date getDate() {
		return date;
	}

	public int getScore() {
		return score;
	}

	public boolean isWon() {
		return won;
	}

	public String getTime() {
		return time;
	}

	public Record getNext() {
		return next;
	}

	public Result getResult(){
		return result;
	}
	
	
	
	
	
}


