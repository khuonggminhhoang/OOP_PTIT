import java.util.LinkedHashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Scanner;

class DaThuc {
    private LinkedHashMap<Integer, Integer> map;
    private int max;

    public DaThuc() {
        map = new LinkedHashMap<>();
    }

    public DaThuc(String s) {
        this.map = new LinkedHashMap<>();
        String[] arr = s.trim().split("\\ \\+\\ ");
        this.max = Integer.MIN_VALUE;
        for (String x : arr) {
            String[] a = x.split("\\*x\\^");
            this.map.put(Integer.parseInt(a[1]), Integer.parseInt(a[0]));
            max = Math.max(max, Integer.parseInt(a[1]));
        }
    }

    public DaThuc cong(DaThuc o) {
        DaThuc ans = new DaThuc();
        int tmp = Math.max(this.max, o.max) + 1;
        while (tmp-- > 0) {
            if (this.map.containsKey(tmp) && o.map.containsKey(tmp)) {
                ans.map.put(tmp, this.map.get(tmp) + o.map.get(tmp));
            } else if (this.map.containsKey(tmp) && !o.map.containsKey(tmp)) {
                ans.map.put(tmp, this.map.get(tmp));
            } else {
                ans.map.put(tmp, o.map.get(tmp));
            }
        }
        return ans;
    }

    @Override
    public String toString() {
        String ans = "";
        for (int x : this.map.keySet()) {
            if (this.map.get(x) != null) {
                ans += map.get(x) + "*x^" + x + " + ";
            }
        }
        return ans.substring(0, ans.length() - 3);
    }
}

public class tong_da_thuc_J05063 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            DaThuc p = new DaThuc(sc.nextLine());
            DaThuc q = new DaThuc(sc.nextLine());
            DaThuc r = p.cong(q);
            System.out.println(r);
        }
    }
}
