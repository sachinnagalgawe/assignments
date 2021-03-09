package com.example.demo.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileOperations {

	private static final Logger logger = LoggerFactory.getLogger(FileOperations.class);

	String path = "./files/";
	Scanner scanner = new Scanner(System.in);
	String fileName = null;
	boolean fileCreated = false;
	boolean writeInitiated = false;

	public synchronized void readFileNameAndCreateFile() {
		logger.info("Enter file name: ");
		fileName = scanner.nextLine();

		File myFile = new File(path + fileName);
		try {
			Files.createDirectories(Paths.get(path));
			if (myFile.createNewFile()) {
				// logger.info("File Created");
				fileCreated = true;
			} else {
				Thread.currentThread().interrupt();
				logger.info("Failed to Create file");
			}
			notify();
		} catch (IOException e) {
			logger.error("Error occurred while creating file: ", e);
		}
	}

	public synchronized boolean writFileData() throws IOException {
		if (fileCreated) {
			logger.info("Enter data to insert :");
			String fileData = scanner.nextLine();
			if (fileData != null) {
				BufferedWriter writer = new BufferedWriter(new FileWriter(path + fileName));
				writer.write(fileData);
				writer.close();
				return true;
			}
		} else {
			try {
				wait();
			} catch (Exception e) {
				logger.error("Error occurred while reading file data: ", e);
			}
		}
		return false;
	}

	public synchronized void readFileData() throws IOException, InterruptedException {
		logger.info("Reading the file data.");
		File myFile = new File(path + fileName);
		FileReader fileReader = new FileReader(myFile);
		BufferedReader br = new BufferedReader(fileReader);
		String line;
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}
	}
}
