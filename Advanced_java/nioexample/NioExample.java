package nioexample;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioExample {
	public static void main(String[] args) throws IOException {
		FileInputStream fin = new FileInputStream("D:\\java\\source.txt");
		FileChannel readChannel = fin.getChannel();
		ByteBuffer readBuffer = ByteBuffer.allocate(1024);
		int result = readChannel.read(readBuffer);
		System.out.println("file read successfully " + result);

		FileOutputStream fout = new FileOutputStream("D:\\java\\desc1.txt");
		FileChannel writeChannel = fout.getChannel();
		ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
		String message = "this is a test String";
		writeBuffer.put(message.getBytes());
		writeBuffer.flip();
		writeChannel.write(writeBuffer);
		System.out.println("file written successfully");
	}

}
