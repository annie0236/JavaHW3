package model;

import java.io.Serializable;


public class Porder implements Serializable{
	private int id;
	private String name;
	private int black;
	private int latte;
	private int mocha;
	public Porder() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Porder(String name, int black, int latte, int mocha) {
		super();
		this.name = name;
		this.black = black;
		this.latte = latte;
		this.mocha = mocha;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBlack() {
		return black;
	}
	public void setBlack(int black) {
		this.black = black;
	}
	public int getLatte() {
		return latte;
	}
	public void setLatte(int latte) {
		this.latte = latte;
	}
	public int getMocha() {
		return mocha;
	}
	public void setMocha(int mocha) {
		this.mocha = mocha;
	}
}
