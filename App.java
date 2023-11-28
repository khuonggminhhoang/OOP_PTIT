import java.util.*;


public class App {
    public static String[][] cp = new String[1000][];
    public static int n, n2;
    public static Boolean[] vst = new Boolean[1000];
    public static HashMap<String, String> mp = new HashMap<>();
    public static String[] answers = new String[1000];

    static Boolean check(String[] a) {
        int len = a.length;
        //tinh ve ben trai: tuc 12+5=3 thi phan nay tinh 12+5
        Deque <String> Q = new ArrayDeque<>();
        for (int i = 0; i < len - 2; ++i) {
            try {
                Integer.parseInt(a[i]);
                Q.addLast(a[i]);
            } catch (Exception e) {
                if (a[i].equals("*") || a[i].equals("/")) {
                    Integer x1 = Integer.parseInt(a[i + 1]);
                    Integer x2 = Integer.parseInt(Q.removeLast());
                    Integer res = 0;
                    if (a[i].equals("/")) {
                        if (x1 == 0) return false;
                        res = x2 / x1;
                    } else {
                        res = x2 * x1;
                    }
                    Q.addLast(String.valueOf(res));
                    i += 1;
                } else {
                    Q.addLast(a[i]);
                }
            }
        }
        int ans = Integer.parseInt(Q.removeFirst());
        while (!Q.isEmpty()) {
            String dau = Q.removeFirst();
            int x2 = Integer.parseInt(Q.removeFirst());
            if (dau.equals("+")) {
                ans += x2;
            } else {
                ans -= x2;
            }
        }
        if (ans != Integer.parseInt(a[len - 1])) {
            return false;
        }
        return true;
    }

    static Boolean is_nghiem(String a) {
        Character c = a.charAt(0);
        if (c >= 'a' && c <= 'z') return true;
        return false;
    }

    static Boolean TryFx(int id_cp, int id_str) {
        if (id_cp == n) {
            return true;
        }
        
        if (id_str == cp[id_cp].length) {
            // for (String x : cp[id_cp]) System.out.print(x + " ");
            // System.out.println();
            if (check(cp[id_cp])) return TryFx(id_cp + 1, 0);
            return false;
        }
        
        if (!is_nghiem(cp[id_cp][id_str])) {
            return TryFx(id_cp, id_str + 1);
        }
        String tmp = cp[id_cp][id_str];

        if (mp.containsKey(tmp)) {
            cp[id_cp][id_str] = mp.get(tmp);
            if (TryFx(id_cp, id_str + 1)) return true;
            cp[id_cp][id_str] = tmp;
            return false;
        }
        for (int i = 0; i < n2; ++i) {
            if (vst[i] == false) {
                vst[i] = true;
                cp[id_cp][id_str] = answers[i];
                mp.put(tmp, answers[i]);
                if (TryFx(id_cp, id_str + 1)) return true;
                cp[id_cp][id_str] = tmp;
                mp.remove(tmp);
                vst[i] = false;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //ktao
        for (int i = 0; i < 1000; ++i) vst[i] = false;

        //cau do
        System.out.print("Nhap so luong cau do: ");
        n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; ++i) {
            // System.out.print("Nhap cau do thu " + (i + 1) + ": ");
            String s = sc.nextLine().trim();
            cp[i] = s.split("(?<=\\d)(?=\\D)|(?<=\\D)(?=\\d)|(?<=\\D)(?=\\D)");
        }
        System.out.println("Nhap day dap an tren mot dong: ");

        answers = sc.nextLine().trim().split("\\s+");
        n2 = answers.length;
        if (TryFx(0,0)) {
            for (Map.Entry<String, String> en : mp.entrySet()) {
                System.out.println(en.getKey() + " = " + en.getValue());
            }
        } else {
            System.out.println("khong giai duoc cau nay!!");
        }

        sc.close();
    }
}