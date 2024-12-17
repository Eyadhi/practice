package linkedlist;

public class clist {
	Node head,tail;
	class Node{
		int data;
		Node next;
		Node(int data){
			this.data=data;
		}
	}
	public void insertBeg(int data) {
		Node newNode=new Node(data);
		if(head==null) {
			head=newNode;
			tail=newNode;
			newNode.next=head;
		}
		else {
		     newNode.next=head;
		     tail.next=newNode;
		     head=newNode;
		}
	}
	public void insertEnd(int data) {
		 Node newnode=new Node(data);
         if(tail==null){
      	   head=newnode;
      	   tail=newnode;
      	   tail.next=newnode;
         }
         else {
      	   tail.next=newnode;
      	   newnode.next=head; 
      	   tail=newnode;
         }
          
	}
	public void insertAfter(int n,int data) {
		Node newNode=new Node(data);
		int size=calcSize(head);
		if(n<1 || n>size) {
			System.out.println("cant insert\n");
		}
		else {
			Node temp=head;
			while(--n>1)
				temp=temp.next;
			newNode.next=temp.next;
			temp.next=newNode;
		}
	}
	public int calcSize(Node node) {
		int size=0;
		while(node!=tail) {
			node=node.next;
			size++;
		}
		return size;
	}
	public void deleteBeg() {
		Node temp= head;
		if(tail!=head) {
			head=temp.next;
			tail.next=temp.next;	
		}
		else {
			head=tail=null;	
		}
	}
	public void deleteEnd() {
		Node temp=head;
		if(tail==head) {
			head=null;
			tail=null;
		}
		while(temp.next!=tail) {
			temp=temp.next;
		}
		tail=temp;
		tail.next=head;;	
	}
	public void deleteAfter(int n) {
		Node temp=head;
		int size=calcSize(head);
		if(n<1 || n>size) {
			System.out.print("Not possible");	
		}
		else {
			if(n==1) {
				deleteBeg();
			}
			Node previous=null;
			while(--n>0) {
				previous=temp;
				temp=temp.next;	
			}
			previous.next=temp.next;
		}
	}
	void display() {
		Node n1=head;
		if(tail==null && head==null) {
			System.out.println("empty");
		}
		else {
			do {
				System.out.print(n1.data+" ");
				n1=n1.next;
			}while(n1!=head);
			System.out.println();
		}
	}			
public static void main(String[] args){
	clist l1=new clist();
	l1.insertBeg(2);
	l1.insertBeg(3);
	l1.insertBeg(5);
	l1.display();
	
	l1.insertEnd(6);
	l1.insertEnd(7);
	l1.insertEnd(8);
	l1.display();
	
	l1.insertAfter(4,9);
	l1.insertAfter(3,1);
	l1.display();
	
	l1.deleteBeg();
	l1.display();
	
	l1.deleteEnd();
	l1.display();
	
	l1.deleteAfter(3);
	l1.display();
}
}
