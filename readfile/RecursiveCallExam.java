package file_io.readfile;

import java.io.File;

public class RecursiveCallExam {

	public static File findFile(String fileName, File from) {
		if (from == null) {
			from = new File("C:\\");
		}

		if (from.exists() && from.isDirectory()) {
			File[] itemInDir = from.listFiles();
			
			if (itemInDir != null) {

				for (File item : itemInDir) {

					if (item.isDirectory()) {
						File result = findFile(fileName, item);
						if (result != null) {
							System.out.println(result.getAbsolutePath());
							return result;
						}
					} else if (item.getName().equals(fileName)) {
						System.out.println(item.getAbsolutePath());
						return item;
					}

				}

			}
		} else if (from.getName().equals(fileName)) {
			System.out.println(from.getAbsolutePath());
			return from;
		}

		return null;
	}

	/**
	 * dir 아래에 있는 모든 파일을 호출한다. (하위 폴더 포함)
	 * 
	 * @param dir
	 */
	public static void printAllItems(File dir) {
		if (dir.exists() && dir.isDirectory()) {
			File[] itemInDir = dir.listFiles();
			for (File item : itemInDir) {
				if (item.isDirectory()) {
					printAllItems(item);
				} else {
					System.out.println(item.getAbsolutePath());
				}
			}
		} else if (dir.isFile()) {
			System.out.println(dir.getAbsolutePath());
		}
	}

	public static void infinityCall(int value) {
		if (value > 0) {
			System.out.println("call " + value);
			infinityCall(--value);
			System.out.println("break loop " + (value + 1));
		}
	}

	public static String join(String startstr, String joinstr) {
		if (startstr.length() >= 3) {
			return startstr;
		}

		startstr += joinstr;
		return join(startstr, joinstr);
	}

	public static void main(String[] args) {
		findFile("goods.csv", null);
	}
}
