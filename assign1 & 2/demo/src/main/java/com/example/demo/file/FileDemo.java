package com.example.demo.file;

import java.io.IOException;

public class FileDemo {

	public static void main(String[] args) {

		final FileOperations fileOps = new FileOperations();
		
		new Thread() {
			public void run() {
				fileOps.readFileNameAndCreateFile();
			}
		}.start();

		new Thread() {
			public void run() {
				try {
					if(fileOps.writFileData()) {
						new Thread() {
							public void run() {
								try {
									fileOps.readFileData();
								} catch (IOException | InterruptedException e) {
									e.printStackTrace();
								}
							}
						}.start();
					}
					//dataWriteCompleted = fileOps.writFileData();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}.start();
	}

}
