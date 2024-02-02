package file_io.readfile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class ReadAndPrintExam {

	public static List<String> getAllLines(File file) {
		if (file.exists() && file.isFile()) {
			FileReader reader = null;
			BufferedReader bufferedReader = null;
			try {
				reader = new FileReader(file, Charset.forName("UTF-8"));
				bufferedReader = new BufferedReader(reader);
				List<String> lineList = new ArrayList<>();
				String line = null;

				while ((line = bufferedReader.readLine()) != null) {
					lineList.add(line + "\n");
				}

				return lineList;
			} catch (IOException ioe) {
				System.out.println(ioe.getMessage());
			} finally {

				if (bufferedReader != null) {
					try {
						bufferedReader.close();
					} catch (IOException ioe) {
					}
				}

				if (reader != null) {
					try {
						reader.close();
					} catch (IOException e) {
					}
				}

			}

		}

		return new ArrayList<>();
	}

	public static void main(String[] args) {
		File file = new File("C:\\Java Exam", "Java Exam.txt");
		if (file.exists() && file.isFile()) {
			FileReader reader = null;
			BufferedReader bufferedReader = null;
			try {
				reader = new FileReader(file, Charset.forName("UTF-8"));
				bufferedReader = new BufferedReader(reader);
				String line = null;

				while ((line = bufferedReader.readLine()) != null) {
					System.out.println(line);
				}
			} catch (IOException ioe) {
				System.out.println(ioe.getMessage());
			} finally {

				if (bufferedReader != null) {
					try {
						bufferedReader.close();
					} catch (IOException ioe) {
					}
				}

				if (reader != null) {
					try {
						reader.close();
					} catch (IOException e) {
					}
				}

			}

		}

	}
}
