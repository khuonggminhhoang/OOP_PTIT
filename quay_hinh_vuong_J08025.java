import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class State{
    private int[][] a;
    private int step;

    public State(State st){
        this.a = new int[2][3];
        this.a = st.a;
        this.step = st.step;
    }

    public State(int[][] a, int step) {
        this.a = new int[2][3];
        this.a = a;
        this.step = step;
    }

    public int[][] getA() {
        return a;
    }

    public void setA(int[][] a) {
        this.a = a;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public void leftRotate(int i, int j){
        int tmp = this.a[i][j];
        this.a[i][j] = this.a[i][j + 1];
        this.a[i][j + 1] = this.a[i + 1][j + 1];
        this.a[i + 1][j + 1] = this.a[i + 1][j];
        this.a[i + 1][j] = tmp;
    }

    public void rightRotate(int i, int j){
        int tmp = this.a[i][j];
        this.a[i][j] = this.a[i + 1][j];
        this.a[i + 1][j] = this.a[i + 1][j + 1];
        this.a[i + 1][j + 1] = this.a[i][j + 1];
        this.a[i][j + 1] = tmp;
    }

    static boolean compareArr(int[][] a, int[][] b){
        for(int i=0; i<2; ++i){
            for(int j=0; j < 2; ++j){
                if(a[i][j] != b[i][j]) return false;
            }
        }
        return true;
    }

    static void in(int[][] arr){
        for(int i = 0; i < 2; ++i){
                for(int j = 0; j < 3; ++j){
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
    }
}

public class quay_hinh_vuong_J08025 {
    public static int solve(int[][] a, int[][] target){
        State start = new State(a, 0);
        Queue <State> q = new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()){
            State first = q.poll();
            if(State.compareArr(first.getA(), target)){
                return first.getStep();
            }

            int[][] tmp = first.getA();

            int[][] arr1 = new int[2][3];
            for(int i=0; i<2; ++i){
                for(int j=0; j<3; ++j){
                    arr1[i][j] = tmp[i][j];
                }
            }

            int step = first.getStep();
            State o = new State(arr1, step);
            o.rightRotate(0, 0);
            o.setStep(step + 1);
            q.add(o);
            
            int[][] arr2 = new int[2][3];
            for(int i=0; i<2; ++i){
                for(int j=0; j<3; ++j){
                    arr2[i][j] = tmp[i][j];
                }
            }
            State e = new State(arr2, step);
            e.rightRotate(0, 1);
            e.setStep(step + 1);
            q.add(e);
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t-- > 0){
            int[][] arr = new int[2][3];
            for(int i = 0; i <2; ++i){
                for(int j=0; j<3; ++j){
                    arr[i][j] = scn.nextInt();
                }
            }

            int[][] target = new int[2][3];
            for(int i = 0; i <2; ++i){
                for(int j=0; j<3; ++j){
                    target[i][j] = scn.nextInt();
                }
            }
            System.out.println(solve(arr, target));
            scn.close();
        }
    }
}
