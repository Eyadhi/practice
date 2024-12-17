package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

enum Tech{
	java,python,c,cpp,html,css,js;
}

@interface Fullstack{
	//it is a marker annotation
}
@Retention(RetentionPolicy.RUNTIME)
@interface Fullstack1{
	//it is a single-valued annotation
	Tech[] technology();
}
@Fullstack()
class Demo{
	void x() {
		
	}
}

@Fullstack1(technology= {Tech.c,Tech.java})
class Demo1{
	void x() {
		
	}
	
}
@interface Fullstack2{
	//it is multi-valued annotation
	String technology();
	int marks() default 0;
}
@Fullstack2(technology="Java",marks=50)
class Demo2{
	void x() {
		
	}
}
public class MyClass {
	@MyCustomAnnotation(Value=10)
	public void sayHello() {
		System.out.println("Mycustom annotation");
	}

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		/*MyClass h=new MyClass();
		Method My=h.getClass().getMethod("sayHello");
		MyCustomAnnotation My1=My.getAnnotation(MyCustomAnnotation.class);
        System.out.println("value:"+My1.Value());*/
		Demo1 d=new Demo1();
		Fullstack1 a= d.getClass().getAnnotation(Fullstack1.class);
		System.out.println(a);
		
	}

}
