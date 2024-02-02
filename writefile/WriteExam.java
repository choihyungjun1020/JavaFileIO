package file_io.writefile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import file_io.readfile.ReadAndPrintExam;

public class WriteExam {

	public static void writeFile(String parent, String fileName, boolean append) {
		File file = new File(parent, fileName);

		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}

		List<String> originalFileDescription = new ArrayList<>();
		if (!append) {
			int index = 2;
			while (file.exists()) {
				file = new File(file.getParent(), "java_output (" + (index++) + ").txt");
			}
		} else {
			// 이어서 쓸 것이라면
			// 기존의 파일 내용을 읽어와서 List<String> 으로 반환 받는다.
			originalFileDescription.addAll(ReadAndPrintExam.getAllLines(file));

			// 반환 받은 내용을 originalFileDescription 에 addAll() 한다.
		}

		// 파일을 이어서 쓸 수 있는 메소드는 없다.
		// java 1.8 -> 이어쓰기가 가능
		// java 1.8 미만 -> 기존의 파일 내용을 전부 읽어와서 새롭게 파일을 쓴다.

		FileWriter fw = null;
		BufferedWriter bw = null;

		try {
			fw = new FileWriter(file, Charset.forName("UTF-8"));
			bw = new BufferedWriter(fw);

			if (append) {
				for (String originalFileLine : originalFileDescription) {
					bw.write(originalFileLine);
				}
			}

			bw.write("파일을 씁니다1.\n");
			bw.write("파일을 씁니다2.\n");
			bw.write("파일을 씁니다3.\n");
			bw.flush();
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException ioe) {

				}
			}
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException ioe) {

				}
			}
		}
	}

	public static void main(String[] args) {
		writeFile("C:\\java\\outputs", "java_output.txt", false);
		writeFile("C:\\java\\outputs", "java_output.txt", true);
	}
}
