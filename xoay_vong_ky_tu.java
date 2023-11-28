import java.util.Scanner;

public class xoay_vong_ky_tu {
    public static String rotateString(String s, int step){
        return s.substring(step) + s.substring(0, step);
    }

    public static int minRotate(String[] arr){
        int ans = Integer.MAX_VALUE;
        for(String target : arr){
            int total = 0;
            for(String s : arr){
                boolean flag = false;
                for(int step = 0; step < s.length(); ++step){
                    if(rotateString(s, step).equals(target)){
                        flag = true;
                        total += step;
                        break;
                    }
                }
                if(!flag) return -1;
            }
            ans = Math.min(ans, total);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.nextLine();
        String[] arr = new String[n];
        for(int i = 0; i<n; ++i){
            arr[i] = scn.nextLine();
        }
        System.out.println(minRotate(arr));
        scn.close();
    }
}
