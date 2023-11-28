import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class HoaDon {
    private String id, name;
    private long older, lastest;

    public static int cnt = 0;

    public HoaDon(String name, long older, long lastest) {
        this.id = "KH" + String.format("%02d", ++cnt);
        this.name = name;
        this.older = older;
        this.lastest = lastest;
    }

    public long amount() {
        return this.lastest - this.older;
    }

    public long unitPrice() {
        long tmp = amount();
        if (tmp <= 50)
            return 100;
        else if (tmp <= 100)
            return 150;
        else
            return 200;
    }

    // phụ phí
    public double surcharge() {
        long tmp = amount();
        if (tmp <= 50)
            return 0.02;
        else if (tmp <= 100)
            return 0.03;
        else
            return 0.05;
    }

    public long total() {
        double ans = 0;
        long tmp = amount();
        ans += (tmp <= 50) ? tmp * 100 : 50 * 100;
        tmp -= 50;
        if (tmp > 0) {
            ans += (tmp <= 50) ? tmp * 150 : 50 * 150;
            tmp -= 50;
        }
        ans += (tmp > 0) ? tmp * 200 : 0;
        return Math.round(ans * (1 + surcharge()));
    }

    @Override
    public String toString() {
        return this.id + " " + this.name + " " + this.total();
    }
}

public class hoa_don_tien_nuoc_J05017 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        ArrayList<HoaDon> arr = new ArrayList<>();
        while (t-- > 0) {
            scn.nextLine();
            arr.add(new HoaDon(scn.nextLine(), scn.nextLong(), scn.nextLong()));
        }

        Collections.sort(arr, new java.util.Comparator<HoaDon>() {
            @Override
            public int compare(HoaDon o1, HoaDon o2) {
                return (int) (o2.total() - o1.total());
            }
        });
        for (HoaDon x : arr) {
            System.out.println(x);
        }
        scn.close();
    }
}
