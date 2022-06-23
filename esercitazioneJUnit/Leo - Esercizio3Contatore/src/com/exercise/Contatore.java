package com.exercise;

public class Contatore {

	private int counter;

	public Contatore() {
		super();
		this.counter = 0;
	}
	
	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}
	
	public void increase() {
		this.counter++;
	}
	
	public void increaseByN(int n) {
		this.counter += n;
	}
	
	public void decrease() {
		this.counter--;
	}
	
	public void decreaseByN(int n) {
		this.counter -= n;
	}

	@Override
	public String toString() {
		return "Contatore [counter=" + counter + "]";
	}
	
}
