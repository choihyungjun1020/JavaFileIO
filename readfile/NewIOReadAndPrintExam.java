package file_io.readfile;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class NewIOReadAndPrintExam {

	public static void main(String[] args) {

		File file = new File("C:\\Java Exam", "Java Exam.txt");

		if (file.exists() && file.isFile()) {
			List<String> fileLine = new ArrayList<>();

			try {
//				Path filePath = Paths.get("C:\\Java Exam", "Java Exam.txt");
//				Charset utf8 = Charset.forName("UTF-8");
//				fileLine.addAll(Files.readAllLines(filePath, utf8));
				
				// use File Class's toPath() method
				fileLine.addAll(Files.readAllLines(file.toPath(), Charset.forName("UTF-8")));
			} catch (IOException ioe) {
				System.out.println(ioe.getMessage());
			}

			for (String line : fileLine) {
				System.out.println(line);
			}

		}

	}

}
