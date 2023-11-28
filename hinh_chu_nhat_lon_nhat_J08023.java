import java.util.Scanner;
import java.util.Stack;

public class hinh_chu_nhat_lon_nhat_J08023 {
    public static long maxArea(int[] a, int n) {
        long ans = 0;
        int[] left = new int[n];
        Stack<Integer> stkLeft = new Stack<>();
        for (int i = 0; i < n; ++i) {
            while (!stkLeft.isEmpty() && a[i] <= a[stkLeft.peek()]) {
                stkLeft.pop();
            }
            if (!stkLeft.isEmpty()) {
                left[i] = stkLeft.peek() + 1;
            } else {
                left[i] = 0;
            }
            stkLeft.push(i);
        }

        int[] right = new int[n];
        Stack<Integer> stkRight = new Stack<>();
        for (int i = n-1; i >=0; --i) {
            while (!stkRight.isEmpty() && a[i] <= a[stkRight.peek()]) {
                stkRight.pop();
            }
            if (!stkRight.isEmpty()) {
                right[i] = stkRight.peek() - 1;
            } else {
                right[i] = n - 1;
            }
            stkRight.push(i);
        }

        for (int i = 0; i < n; ++i) {
            ans = Math.max(ans, (long) a[i] * (right[i] - left[i] + 1));
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while (t-- > 0) {
            int n = scn.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; ++i)
                a[i] = scn.nextInt();
            System.out.println(maxArea(a, n));
        }
    }
}
