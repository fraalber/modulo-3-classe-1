package com.exercise;

public class VolumeUtils {

	public static void setVolume(GestoreAudioDispositivoManager gestoreAudio) {
		if(gestoreAudio.isMode()) {
			gestoreAudio.setVolume(10);
		}else {
			gestoreAudio.setMaxVolume();
		}
	}
}
