package stack;
import java.util.Iterator;
import java.util.Stack;
public class chair {
	//create stack using LinkedList
	Node top;
	int length;
	class Node{
		int data;
		Node next;
		Node (int data){
			this.data=data;
		}
	}
	chair(){
		this.top=null;
		length=0;
	}
	public int length() {
		return length;
	}
	public boolean isEmpty() {
		return length==0;
	}
	public void push(int x) {
		Node temp=new Node(x);
		temp.next=top;
		top=temp;
		length++;
	}
	public int peek() {
		if(!isEmpty()) {
			return top.data;
		}
		else {
			System.out.println("Stack is Empty");
			return -1;
		}
	}
	public int pop() {
		if(isEmpty()) {
			System.out.println("Stack is empty");
			return -1;
		}
		int result=top.data;
		top=top.next;
		length--;
		return result;
	}
	public void display() {
		if(top==null) {
			System.out.println("Stack is empty");
		}
		else {
			Node temp=top;
			while(temp!=null) {
				System.out.print(temp.data+" ");
				temp=temp.next;
			}	
		}
	}
	
	//create stack using Arrays
	int arr[]=new int[10];
	int top1=-1;
	void Push(int x) {
		top1++;
		arr[top1]=x;
		if(top1+1==arr.length) {
			System.out.println("Stack is full");
		}
	}
	void Pop() {
		if(top1<0) {
			System.out.println("Stack is empty");
		}
		System.out.println("popped element "+arr[top1]);
		top1--;
	}
	public int Peek() {
		if(top1>0) {
		return (arr[top1]);
		}
		else {
			System.out.println("Stack is Empty");
			return -1;
		}
	}
	void Display() {
		for(int i=top1;i>=0;i--) {
			System.out.print(arr[i]+" ");		
		}	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack <Integer> s1=new Stack<>();
		s1.push(25);
		s1.push(3);
		System.out.println(s1);
		System.out.print(s1);
		s1.push(19);
		Iterator<Integer> it=s1.iterator();
		while(it.hasNext())
		{
			Object s2=it.next();
		System.out.println(s2);	
		}
		s1.sort(null);
		System.out.println(s1);
		
		chair c1=new chair();
		c1.Push(10);
		c1.Push(15);
		c1.Push(20);
		c1.Display();
		c1.Pop();
		c1.Display();
		System.out.printf("\nTop Element is %d\n",c1.Peek());		
		c1.Push(25);
		c1.Push(20);
		c1.Display();
		
	}

}
