package com.exercise;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

class VolumeUtilsTest {
	
	@Test
	void getNormal() {
		GestoreAudioDispositivoManager gestoreAudio = mock(GestoreAudioDispositivoManager.class);
		
		when(gestoreAudio.isMode()).thenReturn(false);
		when(gestoreAudio.getVolume()).thenReturn(100);
		
		VolumeUtils.setVolume(gestoreAudio);
		verify(gestoreAudio, times(1)).setMaxVolume();;
	}

}
