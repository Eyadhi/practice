package serialize;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerDeserDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student s1 = new Student("John", 25, "23 East,Clifornia");
		String filename = "D:\\java\\Text.txt";
		FileOutputStream fileOut = null;
		ObjectOutputStream objOut = null;
		// serialization
		try {
			fileOut = new FileOutputStream(filename);
			objOut = new ObjectOutputStream(fileOut);
			objOut.writeObject(s1);
			objOut.close();
			fileOut.close();
			System.out.println("Object has serialized :\n" + s1);
		} catch (IOException ex) {
			System.out.println("IOException is caught");
		}
		// Deserialization
		FileInputStream fileIn = null;
		ObjectInputStream objIn = null;
		try {
			fileIn = new FileInputStream(filename);
			objIn = new ObjectInputStream(fileIn);
			Student object = (Student) objIn.readObject();
			System.out.println("Object has been deserialized: \n" + object);
			objIn.close();
			fileIn.close();
		} catch (IOException ex) {
			System.out.println("IOException is caught");
		} catch (ClassNotFoundException ex) {
			System.out.println("ClassNotFoundException" + "is caught");
		}
	}
}