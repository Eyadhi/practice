package input_output_stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Byte_Stream_Example {

	public static void main(String[] args) throws IOException {
		FileInputStream inStream = null;
		FileOutputStream outStream = null;
		// reads a byte at a time, if it reached end of the file,return -1
		try {
			inStream = new FileInputStream("D:\\java\\source.txt");
			outStream = new FileOutputStream("D:\\java\\dest.txt");
			int content;
			while ((content = inStream.read()) != -1) {
				outStream.write((byte) content);
			}
		} finally {
			if (inStream != null) {
				inStream.close();
			}
			if (outStream != null) {
				outStream.close();
			}
		}
	}

}
