package file_io.writefile;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class NIOWriteExam {
	public static void main(String[] args) {

		boolean append = true;

		File file = new File("C:\\outputs2", "java_output2.txt");

		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}

		if (!append) {
			int index = 2;
			while (file.exists()) {
				file = new File(file.getParent(), "java_output (" + (index++) + ").txt");
			}
		}

		List<String> fileDesc = new ArrayList<>();

		fileDesc.add("파일을 씁니다 1.");
		fileDesc.add("파일을 씁니다 2.");
		fileDesc.add("파일을 씁니다 3.");

		try {

// 파일 이어쓰기 옵션
//			Set<StandardOpenOption> defaultOpenOptions = Set.of(StandardOpenOption.CREATE,
//					StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE);

			if (!append) {
				Files.write(file.toPath(), fileDesc, Charset.forName("UTF-8"));
			}
			else {
				Files.write(file.toPath(), fileDesc, Charset.forName("UTF-8"), StandardOpenOption.APPEND);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		System.out.println(file.getAbsolutePath());

	}
}
