package greedy_algorithm;

//Java program for activity selection problem when input activities may not be sorted. 
import java.io.*; 
import java.util.*; 

//A job has a start time, finish time and profit. 
class Activity { 
	int start, finish; 
	// Constructor 
	public Activity(int start, int finish) { 
		this.start = start; 
		this.finish = finish; 
	} 
} 
//Driver class 
public class Activity_Selection { 

	// Returns count of the maximum set of activities that can be done by a single person, one at a time. 
	static void printMaxActivities(Activity arr[], int n) { 
		// Sort jobs according to finish time 
		System.out.println( "Following activities are selected :"); 
		// The first activity always gets selected 
		int i = 0; 
		System.out.print("(" + arr[i].start + ", "+ arr[i].finish + ")"); 
		// Consider rest of the activities 
		for (int j = 1; j < n; j++) { 
			// If this activity has start time greater than or equal to the finish time of previously selected activity, then select it 
			if (arr[j].start >= arr[i].finish) { 
				System.out.print(", (" + arr[j].start + ", "+ arr[j].finish + ")"); 
				i = j; 
			} 
		} 
	} 

	// Driver code 
	public static void main(String[] args) { 
		int n = 6; 
		Scanner sc=new Scanner(System.in);
		int[] start= {5,1,3,0,5,8};
		int[] finish= {9,2,4,6,7,9};
		Activity arr[] = new Activity[n]; 
		for(int i=0;i<n;i++) {
			arr[i]=new Activity(start[i],finish[i]);
		}
		Arrays.sort(arr,Comparator.comparingInt(a->a.finish));
		// Function call 
		printMaxActivities(arr, n); 
	} 
} 
