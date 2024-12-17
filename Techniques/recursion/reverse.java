package recursion;
public class reverse {
	static int n;
    static void moveZeroes(int nums[]) {
       int n=nums.length;
       int j=0;
       for(int i=1;i<n;i++) {
    	   if(nums[i]!=0 && nums[j]==0) {
    		   nums=swap(nums,i,j);
    	   }
    	   if(nums[j]!=0) {
    		   j+=1;
    	   } 
       }       
    }
    static int[] swap(int[] nums,int i,int j) {
    	int temp =nums[i];
		   nums[i]=nums[j];
		   nums[j]=temp;
		   return nums;
    }
    static void printArray(int nums[]) {
    	for(int i=0;i<nums.length;i++) {
    		System.out.print(nums[i]+" ");
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[]= {0,0,0,2,3};
		moveZeroes(nums);
		printArray(nums);
		int a=1,b=1;
		if(a<1)System.out.print(true);
		else {
			System.out.print(false);
		}
	}

}
