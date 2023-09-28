import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class so_khac_nhau_trong_file_2_J07005 {

    public static void main(String args[]) {
        try {
            DataInputStream in = new DataInputStream(new FileInputStream("DATA.IN"));
            int a[] = new int[1000];
            for (int i = 0; i < 100000; i++) {
                int x = in.readInt();
                a[x]++;
            }
            for (int i = 0; i < 1000; i++) {
                if (a[i] > 0) {
                    System.out.println(i + " " + a[i]);
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}