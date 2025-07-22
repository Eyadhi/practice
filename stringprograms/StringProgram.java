package stringprograms;

public class StringProgram {
    public static String result(String[] arr, String str) {
        String res = "";
        int len = str.length();
        int minMismatch = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            String current = arr[i];
            if (current.length() < len) {
                continue;
            }
            int mismatch = 0;
            for (int j = 0; j < len; j++) {
                if (str.charAt(j) != current.charAt(j)) {
                    mismatch++;
                    if (mismatch >= minMismatch)
                        break;
                }
            }
            if (mismatch < minMismatch) {
                minMismatch = mismatch;
                res = current;
            }
        }
        return res;
    }

    public static void main(String[] args) {

        String[] arr = { "bandbk", "bakaba", "aanaba", "apple" };
        String target = "banana";
        System.out.println(result(arr, target));
    }
}
