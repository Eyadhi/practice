package input_output_stream;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class character_Stream_Demo {
	public static void main(String[] args) throws IOException {
		FileReader reader = null;
		FileWriter writer = null;
		try {
			reader = new FileReader("D:\\java\\source.txt");
			writer = new FileWriter("D:\\java\\dest.txt");
			int content;
			while ((content = reader.read()) != -1) {
				writer.append((char) content);
			}
		} finally {
			if (reader != null) {
				reader.close();
			}
			if (writer != null) {
				writer.close();
			}
		}
	}
}
