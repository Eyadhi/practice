package searching;

public class BinarySearch {
	public static int Searching(int a[],int data) {
		int l=0,r=a.length-1;
		int mid;
		while(l<r) {
			mid=(l+r)/2;
		if(data==a[mid]) {
			return mid;
		}
		else if(data<a[mid]) {
			r=mid-1;
		}
		else {
			l=mid+1;
		}
		}
		return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]=new int[]{1,2,3,4,5,6,7};
		int data=6;
		int index=Searching(a,data);
		System.out.println(index);

	}

}
