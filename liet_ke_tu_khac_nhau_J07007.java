import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;

class WordSet {
    private TreeSet<String> set;

    public WordSet(String file) {
        Scanner scn;
        try {
            scn = new Scanner(new File(file));
            this.set = new TreeSet<>();
            while(scn.hasNext()){
                String tmp = scn.next();
                tmp = tmp.toLowerCase();
                this.set.add(tmp);
        }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       
    }

    @Override
    public String toString(){
        String ans = "";
        for(String x : this.set){
            ans += x + '\n';
        }
        return ans;
    }
}

public class liet_ke_tu_khac_nhau_J07007 {
    public static void main(String[] args) throws IOException {
        WordSet ws = new WordSet("VANBAN.in");
        System.out.println(ws);
    }
}
