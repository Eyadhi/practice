package queue;
class queueing{
	Node front1,rear1;
	int length;
	class Node{
		int data;
		Node next;
		Node (int data)
		{
			this.data=data;
			this.next=null;
		}
	}
	int length() {
		return length;
	}
	public boolean isEmpty() {
		return length==0;
	}
	public void Enqueue(int data) {
		Node temp=new Node(data);
		if(isEmpty()) {
			front1=temp;
		}
		else {
			rear1.next=temp;
		}
		rear1=temp;
		length++;
	}
	public int Dequeue() {
		if(isEmpty()) {
			System.out.println("It is not possible to remove");
		}
		int res=front1.data;
		front1=front1.next;
		if(front1==null) {
			rear1=null;
		}
		length--;
		return res;
	}
	void Display() {
		if(rear1==null){
			System.out.println("queue is empty");
		}
		else {
			Node current=front1;
			while(current!=null) {
				System.out.print(current.data+" ");
				current=current.next;
			}
		}
	}
	int front,rear;
	int capacity;
	static int[] q1;
	queueing(int size){
		capacity=size;
		q1=new int[capacity];
	}
	void enqueue(int value){
		if(rear==capacity){
			System.out.println("queue is full");
		}
		else {
			 q1[rear]=value;
			rear++;
		}
	}
	void dequeue() {
		if(rear==0){
			System.out.println("queue is empty");		
			}
		else {
			for(int i=0;i<rear-1;i++){
				q1[i]=q1[i+1];
			}
			rear--;
		}
	}
	void display() {
		if(rear==0){
			System.out.println("queue is empty");
		}
		else {
			for(int i=0;i<rear;i++){
				System.out.print(q1[i]+" ");
			}
		}
	}
}
public class line {
	public static void main(String[] args) {
		queueing q2=new queueing(5);
		q2.enqueue(2);
		q2.enqueue(4);
		q2.enqueue(3);
		//q2.dequeue();
		q2.display();
		
		q2.Enqueue(3);
		q2.Enqueue(4);
		q2.Enqueue(5);
		q2.Display();
		q2.Dequeue();
		q2.Display();
	}
}
