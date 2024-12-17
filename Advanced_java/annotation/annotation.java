package annotation;
import java.util.*;
/*class Parent{
	@Deprecated
	void showDateandtime(){
		System.out.println("7:00");
	}
	void showDate() {
		System.out.println("1-8-2024");
	}
	void showTime() {
		System.out.println("11:00");
	}
}
class Child extends Parent{
	@Override
	void showDateandtime(){
		System.out.println("8:00");
	}
}*/
@FunctionalInterface
//only one method is created in the interface
interface MyInterface{
	void x();
	
}
public class annotation {
	public static void main(String[] args) {
		//Child obj=new Child();
		//obj.showDateandtime();
		@SuppressWarnings("rawtypes")
		ArrayList list=new ArrayList();
		System.out.println(list);
	}

}
