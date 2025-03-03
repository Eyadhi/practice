package image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageHandling {
	public static void main(String[] args) throws IOException {
		int width = 963;
		int height = 640;
		BufferedImage image = null;
		image = readFromFile(width, height, image);
		writeToFile(image);
	}

	private static BufferedImage readFromFile(int width, int height, BufferedImage image) {
		try {
			File sampleFile = new File("C:\\Users\\sabab\\OneDrive\\Pictures\\ganesh-ganesha-hindu-india.jpg");
			image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
			image = ImageIO.read(sampleFile);
			System.out.println("Reading complete." + image);
		} catch (IOException e) {
			System.out.println("Error:" + e);
		}
		return image;
	}

	private static void writeToFile(BufferedImage image) {
		try {
			File Output = new File("C:\\Users\\sabab\\OneDrive\\Pictures\\ganesh-ganesha-hindu-india1.jpg");
			ImageIO.write(image, "jpg", Output);
			System.out.println("Writing completed");
		} catch (IOException e) {
			System.out.println("Error:" + e);
		}
	}
}
