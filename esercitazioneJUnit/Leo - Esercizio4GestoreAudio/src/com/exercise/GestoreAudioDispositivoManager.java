package com.exercise;

public class GestoreAudioDispositivoManager {

	private int volume;
	private boolean mode;
	
	public GestoreAudioDispositivoManager(boolean mode) {
		super();
		this.mode = mode;
		this.volume = 50;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	public boolean isMode() {
		return mode;
	}
	public void setMode(boolean mode) {
		this.mode = mode;
	}
	
	public void setMaxVolume() {
		this.volume = 100;
	}
	
	
	
}
