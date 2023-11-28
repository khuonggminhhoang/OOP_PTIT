import java.util.ArrayList;
import java.util.Scanner;

public class toan_lop_ba_J01023 {
    public static void Try(int i, String s, String tmp, ArrayList<String> arrNum){
        if(i == s.length()){
            arrNum.add(tmp);
            return;
        }
        if(s.charAt(i) == '?'){
            if(i == 0){
                for(char j = '1'; j <= '9'; ++j ) Try(i + 1, s, tmp + j, arrNum);
            }
            else{
                for(char j = '0'; j <= '9'; ++j ) Try(i + 1, s, tmp + j, arrNum);
            }
        }
        else Try(i + 1, s, tmp + s.charAt(i), arrNum);
    }

    public static boolean isComplete(String n1, String n2, String n3, String operator){
        int num1 = Integer.parseInt(n1);
        int num2 = Integer.parseInt(n2);
        int num3 = Integer.parseInt(n3);
        if(operator.equals("+")) return num1 + num2 == num3;
        if(operator.equals("-")) return num1 - num2 == num3;
        if(operator.equals("*")) return num1 * num2 == num3;
        if(operator.equals("/")) return num1 / num2 == num3;
        return false;
    }

    public static String solve(ArrayList<String> arrNum1, ArrayList<String> arrNum2, ArrayList<String> arrNum3, ArrayList<String> arrOperator){
        for(String n1 : arrNum1){
            for(String n2 : arrNum2){
                for(String n3 : arrNum3){
                    for(String operator : arrOperator){
                        if(isComplete(n1, n2, n3, operator)){
                            return n1 + " " + operator + " " + n2 + " = " + n3;
                        }
                    }
                }
            }
        }
        return "WRONG PROBLEM!";
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = Integer.parseInt(scn.nextLine());
        while(t-- > 0){
            String[] s = scn.nextLine().split("\\s+");
            String n1 = s[0];
            String operator = s[1];
            String n2 = s[2];
            String n3 = s[4];
            ArrayList<String> arrNum1 = new ArrayList<>();
            ArrayList<String> arrNum2 = new ArrayList<>();
            ArrayList<String> arrNum3 = new ArrayList<>();
            Try(0, n1, "", arrNum1);
            Try(0, n2, "", arrNum2);
            Try(0, n3, "", arrNum3);
            ArrayList<String> arrOperator = new ArrayList<>();
            if(operator.equals("?")){
                arrOperator.add("+");
                arrOperator.add("-");
                arrOperator.add("*");
                arrOperator.add("/");
            }
            else{
                arrOperator.add(operator);
            }
            System.out.println(solve(arrNum1, arrNum2, arrNum3, arrOperator));
        }
    }
}
