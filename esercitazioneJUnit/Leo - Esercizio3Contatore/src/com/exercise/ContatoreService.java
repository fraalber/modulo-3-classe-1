package com.exercise;

public class ContatoreService {
	
	private Contatore counter;
	
	public ContatoreService(Contatore counter) {
		super();
		this.counter = counter;
	}

	public int multiplyByN(int n) {
		return this.counter.getCounter()*n;
	}
	
}
