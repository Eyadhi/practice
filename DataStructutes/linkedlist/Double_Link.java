package linkedlist;

public class Double_Link {
	Node head=null;
	Node tail=null;
	class Node{
		int data;
		Node prev,next;
		Node(int x){
			data=x;
			next=null;
			prev=null;
		}
	}
	public void insertBeg(int data) {
		Node newNode=new Node(data);
		if(head==null) {
			head=newNode;
			tail=newNode;
		}
		else {
			head.prev=newNode;
			newNode.next=head;
			head=newNode;
		}
		System.out.println(newNode.data+" inserted");
	}
	public void insertEnd(int data) {
		Node newNode=new Node(data);
		if(tail==null) {
			head=newNode;
			tail=newNode;
		}
		else {
			tail.next=newNode;
			newNode.prev=tail;
			tail=newNode;
		}
	}
	public void insertAfter(int n,int data) {
		Node newNode=new Node(data);
		if(n==1) {
			insertBeg(data);
		}
	    else {
	    	Node current=head;
	    	int currpos=1;
	    	while(current!=null && currpos<n) {
	    		current=current.next;
	    		currpos++;
	    	}
	    	if(current==null) {
	    		insertEnd(data);
	    	}
	    	else {
	    		newNode.next=current;
	    		newNode.prev=current.prev;
	    		current.prev.next=newNode;
	    		current.prev=newNode;
	    	}
	    }
	}
	public void deleteBeg() {
		if(head==null) {
		System.out.println("List is empty");
		return ;
		}
		if(head==tail) {
			head=null;
			tail=null;
			return;
		}
		Node temp=head;
		head=head.next;
		head.prev=null;
		temp.next=null;
	}
	public void deleteLast() {
		if(tail==null) {
				return;
		}
		if(head==tail) {
			head=null;
			tail=null;
			return;
		}
		Node temp=tail;
		tail=tail.prev;
		tail.next=null;
		temp.prev=null;
	}
	public void deleteNth(int n) {
		if(head==null) {
			return;
		}
		if(n==1) {
			deleteBeg();	
		}
		Node current=head;
		int count=1;
		while(current!=null && count!=n) {
			current=current.next;
			count++;
		}
		if(current==null) {
			System.out.println("position wrong");
			return;
		}
		if(current==tail) {
			deleteLast();
			return;
		}
		current.prev.next=current.next;
		current.next.prev=current.prev;
		current.prev=null;
		current.next=null;
	}
	public void display()
	{
		Node node=head;
		System.out.println("\nIn forward");
		while(node!=null) {
			System.out.print(node.data+" ");
			node=node.next;
		}
		Node temp=tail;
		System.out.println("\nIn Backward");
		while(temp!=null) {
			System.out.print(temp.data+" ");
			temp=temp.prev;
		}
		System.out.print("\n");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Double_Link obj=new Double_Link();
		obj.insertBeg(26);
		obj.insertBeg(25);
		obj.insertBeg(24);
		obj.display();
		
		obj.insertEnd(27);
		obj.insertEnd(28);
		obj.insertEnd(29);
		obj.display();
		
		obj.insertAfter(3,30);
		obj.display();
		
		obj.deleteBeg();
		obj.display();
		
	    obj.deleteLast();
		obj.display();
		
		obj.deleteNth(4);
		obj.display();
	}	
}
