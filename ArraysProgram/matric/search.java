package matric;

public class search {
	public static void Search(int matrix[][],int n,int x) {
		int i=0;
		int j=n-1;
		while(i<n && j>=0) {
			if(matrix[i][j]==x) {
				System.out.print("x found at "+i+","+j);
				return ;
			}
			if(matrix[i][j]>x) {
				j--;
			}
			else {
				i++;
			}
		}
		System.out.println("Not found");
	}
	
	public static void Spiral(int matrix[][],int r,int c) {
		int i,k=0,l=0;
		while(k<r && l<c) {
			for(i=l;i<c;i++) {
				System.out.print(matrix[k][i]+" ");
			}
			k++;
			for(i=k;i<r;i++) {
				System.out.print(matrix[i][c-1]+" ");
			}
			c--;
			if(k<r) {
				for(i=c-1;i>=l;i--) {
					System.out.print(matrix[r-1][i]+" ");
				}
				r--;
			}
			if(l<c) {
				for(i=r-1;i>=k;i--) {
					System.out.print(matrix[i][l]+" ");
				}
				l++;
			}
		}
	}
	static int[][] lowerMatrix(int[][] arr) {
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
					arr[i][j]=0;
			}
		}
		return arr;
	}
	public static void SpiralMatrix(int[][] arr) {
		int n=arr.length;
		int m=arr[0].length;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				while(i==0 && j<=m) {
					System.out.println(arr[i][j]);
					j++;
				}
			}
		}
	}
	static int[][] upperMatrix(int[][] arr) {
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<i;j++) {
				arr[i][j]=0;
			}
		}
		return arr;
	}
	static int[][] diagonalMatrix(int[][] arr) {
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length;j++) {
				if(i!=j) {
				arr[i][j]=0;
				}
			}
		}
		return arr;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int matrix[][]= {{10,20,30,40},
				{15,25,35,45},
				{17,27,37,47},
				{32,33,39,51}};
		//Search(matrix,4,50);
		Spiral(matrix,matrix.length,matrix[0].length);
		/*int[][] res=lowerMatrix(matrix);
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix.length;j++) {
				System.out.print(res[i][j]+" ");
			}
			System.out.println("\n");
		}
		int[][] res1=upperMatrix(matrix);
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix.length;j++) {
				System.out.print(res1[i][j]+" ");
			}
			System.out.println("\n");
		}
		int[][] res2=diagonalMatrix(matrix);
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix.length;j++) {
				System.out.print(res2[i][j]+" ");
			}
			System.out.println("\n");
		}*/
	}
}
