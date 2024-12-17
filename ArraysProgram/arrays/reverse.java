package arrays;
import java.util.*;
public class reverse {
	public static int[] reversing(int nums[],int left,int right) {
		while(left<right) {
			for(int i=0;i<nums.length/2;i++) {
			    int temp=nums[left];
			    nums[left++]=nums[right];
			    nums[right--]=temp;
			    //left++;
			    //right--;
			}
		}
		return nums;
	}
	
	public static int findMinimumArraySum(int[] arr) {
	    int sum = 0;
	    int n = arr.length;
	    
	    // Calculate the average of all elements
	    double average = 0;
	    for (int num : arr) {
	        average += num;
	    }
	    average /= n;
	    
	    // Update elements less than average to 0
	    for (int i = 0; i < n; i++) {
	        if (arr[i] < average) {
	            arr[i] = 0;
	        }
	        sum += arr[i];
	    }
	    
	    return sum;
	}

	static int reverse_polish(String[] val) {
		Stack<String>s1=new Stack<>();
		int res=0;
		String operators="*+-/";
		for(String t:val) {
			if(!operators.contains(t)) {
				s1.push(t);
			}
			else {
				int a=Integer.valueOf(s1.pop());
				int b=Integer.valueOf(s1.pop());
			    switch(t) {
			    case "+":
			    	s1.push(String.valueOf(a+b));
			    	break;
			    case "-":
			    	s1.push(String.valueOf(b-a));
			    	break;
			    case "*":
			    	s1.push(String.valueOf(a*b));
			    	break;
			    case "/":
			    	s1.push(String.valueOf(b/a));
			    	break;
			    }
			}
		}
		res=Integer.valueOf(s1.pop());
		return res;
	}
	static int[] rotate(int nums[],int k) {
		k=k%nums.length;
		int a=nums.length-k;
		reversing(nums,0,a-1);
		reversing(nums,a,nums.length-1);
		reversing(nums,0,nums.length-1);
		return nums;
	}
	
	public static int tripletDivisible(int[] arr,int d) {
		int count=0;
		HashMap<Integer,Integer>h1=new HashMap<>();
		int n=arr.length;
		for(int i=0;i<n;i++) {
			for(int j=i+1;j<n;j++) {
				int x=(d-(arr[i]+arr[j])%d)%d;
				count+=h1.getOrDefault(x, 0);
			}
			h1.merge(arr[i]%d,1,Integer::sum);
		}
		return count;
	}
	 
	     public static int[] Balance(int[] a){
	         int n=a.length;
	         int[] r=new int[n];
	         int sum=0;
	         for(int i=0;i<n;i++){
	             sum+=a[i];
	             r[i]=Math.abs(sum-sumR(i+1,a));
	         }
	         return r;
	     }
	     public static int sumR(int j,int[] a){
	         int n=a.length;
	         int val=0;
	         for(int i=j;i<n;i++){
	             val+=a[i];
	         }
	         if(j==n){
	             return 0;
	         }
	         return val;
	     }
	     
	     
	     
	static void IsPossible(int[] arr) {
		int sum=0;
		for(int i=0;i<arr.length;i++) {
			sum+=arr[i];
		}
		Arrays.sort(arr);
		reversing(arr,0,arr.length-1);
		if(sum==0) {
			System.out.println("IMPOSSIBLE");
		}
		else{
			System.out.println("Possible");
			for(int i=0;i<arr.length;i++) {
				System.out.print(arr[i]+" ");
			}
		}
	}
	static int secsmallest(int nums[]) {
		int min=nums[0];
		int smin=nums[0];
		for(int i=1;i<nums.length;i++) {
			if(nums[i]<min) {
				smin=min;
				min=nums[i];
			}
			else if(nums[i]<smin && nums[i]!=min) {
				smin=nums[i];
			}
		}
		return smin;
	}
	public  int[] seclargest(int nums[]) {
		if(nums.length==0) {
			return new int[] {-1,-1};
		}
		int max=nums[0];
		int smax=nums[0];
		for(int i=1;i<nums.length;i++) {
			if(nums[i]>max) {
				smax=max;
				max=nums[i];
			}
			else if(nums[i]>smax && nums[i]!=max) {
				smax=nums[i];
			}
		}
		if(smax==nums[0]) {
		return new int[] {max,-1};
		}
		return new int[] {max,smax};
	}
	public static int thirdLargest(int[] arr){
		int first=Integer.MIN_VALUE;
		int second=Integer.MIN_VALUE;
		int third=Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++){
			if(first<arr[i]){
				third=second;
				second=first;
				first=arr[i];	
			}
			else if(second<arr[i] && arr[i]!=first){
				third=second;
                second=arr[i];
                
            }else if(third<arr[i] && arr[i]!=second){
                third=arr[i];
            }
		}
		return third;
	}
	public  static int thirdSmallest(int[] arr) {
		int first=Integer.MAX_VALUE;
		int second=Integer.MAX_VALUE;
		int third=Integer.MAX_VALUE;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]<first) {
				third=second;
				second=first;
				first=arr[i];
			}
			else if(arr[i]<second && arr[i]!=first) {
				third=second;
				second=arr[i];
			}
			else if(arr[i]<third && arr[i]!=second) {
				third=arr[i];
			}
		}
		return third;
	}
	public static void swapArray(int arr[]) {
		int i=0;
		while(i<arr.length-1){
			int swap=arr[i];
			arr[i]=arr[i+1];
			arr[i+1]=swap;
			i+=2;
		}
	}
	public static void sortDescArray(int[] arr) {
		for(int i=0;i<arr.length-1;i++) {
			for(int j=0;j<arr.length-1;j++) {
				if(arr[j]<arr[j+1]) {
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        /*int nums[]= {1,4,3,2,5};
        Arrays.sort(nums);
        Arrays.reverse(nums);
        //int result[]=reversing(nums);
        for(int i=0;i<nums.length;i++) {
        System.out.print(nums[i]+" ");
        } 
        String a="Babu";
        for(int j=a.length()-1;j>=0;j--) {
        	System.out.print(a.charAt(j));
        }
        int nums[]= {1,2,3,4,5,6,7};
        int result[]=rotate(nums,3);
        for(int i=0;i<nums.length;i++) {
        System.out.print(result[i]+" ");
        }
		int a=1600;
		if((a%4==0 && a%100!=0)|| a%400==0) {
			System.out.println("Leap year");
		}
		else {
			System.out.println("Not Leap year");
		}
       int arr[]= {1,4,2,9,5};
       System.out.println( findMinimumArraySum(arr));
       int arr1[]= {2,3,1,5,4};
       int N=arr1.length;
       int k=3;
       System.out.println(findMaxScore(N,k,arr1));
       String S = "60004";
       int minimumKeyPresses = findMinimumKeyPresses(S);
       System.out.println("Minimum number of key presses: " + minimumKeyPresses);
       int[] a={1,2,3,4,5};
       int[] res=Balance(a);
       System.out.println(Arrays.toString(res));
       String inputString = "aabbcc";
       int result = minStepsToMagicString(inputString);
       System.out.println("Minimum number of steps required: " + result);
       int initialMarbles = 10; // Initial number of marbles
       int[] operations = { 2, 5 }; // Operations: A and B
       int uniqueValues = findUniqueValues(initialMarbles, operations);
       System.out.println("Total number of unique values: " + uniqueValues);
		System.out.println(UniqueMarbles(10,2,5));
       int [] a= {2,9,3,4,5};
       System.out.println(ponds(a));
       System.out.println(BirthDay(2,3));
       //System.out.println( pyramidSum(4));
       int[] roll = {4,2,1,5,8,9};
       int k = 6;
       int result = findDebatePair(roll, k);
       if (result != -1) {
           System.out.println("Lowest roll number of the pair with sum divisible by k: " + result);
       }
       System.out.println(Security(122245));
       String str4="xxxyyz";
       System.out.println(UniqueString(str4));
       String[] val= {"4","13","5","/","+"};
       System.out.println(reverse_polish(val));*/
       int[] arr1= {3,6,4,7,8,9};
       /*int d=5;
       System.out.println(tripletDivisible(arr1,d));
       System.out.println(thirdLargest(arr1));
       System.out.println(thirdSmallest(arr1));*/
       //IsPossible(arr1);
       swapArray(arr1);
       for(int i=0;i<arr1.length;i++) {
       System.out.print(arr1[i]+" ");
       }
	}
   }
