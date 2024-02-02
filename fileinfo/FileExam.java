package file_io.fileinfo;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileExam {
	public static void main(String[] args) {
		File file = new File("C:\\Java Exam", "Java Exam.txt");
		if (file.exists() && file.isFile()) {
			List<String> fileLine = new ArrayList<>();
			try {
				// 파일을 처음부터 끝까지 모두 읽어와 List에 할당합니다.
				Path filePath = Paths.get("C:\\Java Exam", "Java Exam.txt");
				Charset utf8 = Charset.forName("UTF-8");
				fileLine.addAll(Files.readAllLines(filePath, utf8));
			} catch (IOException ioe) {
				// 파일을 읽다가 예외가 발생했을 때, 예외 내용만 출력합니다.

				System.out.println(ioe.getMessage());
			}
			// 읽어온 파일을 모두 출력합니다.
			for (String line : fileLine) {
				System.out.println(line);
			}
		}
	}
}
