package arrays;
import java.util.*;

public class next_greater {
	public int[] nextGreater(int[] arr) {
		int[] result=new int[arr.length];
		Stack<Integer>s1=new Stack<>();
		for(int i=arr.length-1;i>=0;i--) {
			if(!s1.isEmpty()) {
				while(!s1.isEmpty() && s1.peek()<=arr[i]) {
					s1.pop();
				}
			}
			if(s1.isEmpty()) {
				result[i]=-1;
			}
			else {
				result[i]=s1.peek();
			}
			s1.push(arr[i]);
		}
		return result;
	}
	public static int missing_number(int nums[]) {
		int n=nums.length+1;
		int sum=n*(n+1)/2;
		for(int i=0;i<n-1;i++) {
			sum-=nums[i];
		}
		return sum;
		
	}
	static int gcd(int a,int b) {
		if(b==0) {
			return a;
		}
		return gcd(b,a%b);
	}
	static int FindGcd(int nums[],int n) {
		int result=nums[0];
		for(int i=1;i<n;i++) {
			result=gcd(result,nums[i]);
		}
		return result;
	}
		public static int[] sortArray(int [] arr) {
			int i=0;
			int j=0;
			int k=arr.length-1;
			while(i<=k) {
				if(arr[i]==0) {
					swap(arr,i,j);
					i++;
					j++;
				}
				else if(arr[i]==1) {
					i++;
				}
				else {
					swap(arr,i,k);
					k--;
				}
			}
			return arr;
		}
		static int[] sortSquarred(int arr[]) {
			int n=arr.length;
			int res[]=new int[n];
			int i=0,j=n-1;
			for(int k=n-1;k>=0;k--) {
				if(Math.abs(arr[i])>Math.abs(arr[j])) {
					res[k]=arr[i]*arr[i];
					i++;
				}
				else {
					res[k]=arr[j]*arr[j];
					j--;
				}
			}
			return res;
		}
		
		static void swap(int arr[],int i,int j) {
			int temp=arr[i];
			arr[i]=arr[j];
			arr[j]=temp;
		}
		
		public static void frequencyCount(int arr[], int N, int P)
	    {
	        int res[]=new int[N+1];
	        Map<Integer,Integer>h1=new TreeMap<>();
	        for(int i=0;i<N;i++){
	            if(h1.containsKey(arr[i])){
	                h1.put(arr[i],h1.get(arr[i])+1);
	            }
	            else{
	                h1.put(arr[i],1);
	            }
	        }
	        System.out.println(h1);
	        for(int i=1;i<=N;i++) {
	        	res[i]=h1.containsKey(i)?h1.get(i):0;
	        }
	        for(int i=1;i<=N;i++) {
	        	System.out.print(res[i]+" ");
	        }
	    }
		 
	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		/*int arr[]= {4,7,3,4,8,1};
		next_greater n1=new next_greater();
		int[] arr1=n1.nextGreater(arr);
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr1[i]+" ");
		}
		System.out.println();
		int arr2[]= {1,0,2,0,2,1,0,1,2,1,0};
		int res[]=sortArray(arr2);
		for(int i=0;i<arr2.length;i++) {
		System.out.print(res[i]+" ");
		}
		System.out.println();
		int arr3[]= {-4,-1,0,2,4,10};
		int res1[]=sortSquarred(arr3);
		for(int i=0;i<arr3.length;i++) {
			System.out.print(res1[i]+" ");
		}
		System.out.println();
		int nums[]= {1,2,4,5,6};
        System.out.println(missing_number(nums));
        int nums1[]= {2,4,6,8,10};
        int res2=FindGcd(nums1,nums1.length);
        System.out.print(res2);
		System.out.println(secsmallest(nums2));
        */
		ArrayList<Integer>l1=new ArrayList<>();
		l1.add(0);
		l1.add(2);
		l1.add(1);
		l1.add(2);
		l1.add(0);
		sort012(l1);
		System.out.println(l1);
		
	}	
}
