package com.automation.SeleniumScreenRecorderATU;

import java.io.File;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;

public class AUTestRecorderClass extends ATUTestRecorder {

	public AUTestRecorderClass(String recordingRootDirectiry, String recordingName, Boolean isAudioRecordingEnabled)
			throws ATUTestRecorderException {
		super(recordingRootDirectiry, recordingName, isAudioRecordingEnabled);
	}
	

	public static void deleteOldFile(String path) {
		File directory = new File(path);
		File[] files = directory.listFiles();
		for (File file : files) {
				file.delete();
			{

			}
		}
	}

}
