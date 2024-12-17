package parenthesis;
import java.util.*;
public class Balanced {
  static void generator(char arr[], int pos, int open, int close, int N, List < String > list) {
    if (pos == (2 * N)) {
      String s = "";
      for (int i= 0; i < 2 * N; i++)
        s += String.valueOf(arr[i]);
      list.add(s);
    }
    if (open > close) {
      arr[pos] = ')';
      generator(arr, pos + 1, open, close + 1, N, list);
    }
    if (open < N) {
      arr[pos] = '(';
      generator(arr, pos + 1, open + 1, close, N, list);
    }
  }
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter Number:");
    int n = sc.nextInt();
    List < String > list = new ArrayList < > ();
    char arr[] = new char[2 * n];
    generator(arr, 0, 0, 0, n, list);
    for (String pair: list) {
      System.out.println(pair);
    }
  }
}