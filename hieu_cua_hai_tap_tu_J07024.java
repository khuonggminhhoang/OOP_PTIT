import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeSet;

class WordSet{
    private TreeSet<String> set;

    public WordSet(){
        this.set = new TreeSet<>();
    }

    public WordSet(String lnk) throws FileNotFoundException  {
        this.set = new TreeSet<>();
        Scanner scn = new Scanner(new File(lnk));
        while(scn.hasNext()){
            String tmp = scn.next().toLowerCase();
            this.set.add(tmp);
        }
    }

    public WordSet union(WordSet other){
        WordSet ans = new WordSet();
        for(String x : this.set){
            ans.set.add(x);
        }
        for(String x : other.set){
            ans.set.add(x);
        }
        return ans;
    }

    public WordSet intersection(WordSet other){
        WordSet ans = new WordSet();
        for(String x : this.set){
            if(other.set.contains(x)){
                ans.set.add(x);
            }
        }
        return ans;
    }

    public WordSet difference(WordSet other){
        WordSet ans = new WordSet();
        for(String x : this.set){
            if(!other.set.contains(x)){
                ans.set.add(x);
            }
        }
        return ans;
    }

    @Override
    public String toString(){
        String ans = "";
        for(String x : this.set){
            ans += x + " ";
        }
        return ans;
    }
}

public class hieu_cua_hai_tap_tu_J07024 {
    public static void main(String[] args) throws Exception {
        WordSet s1 = new WordSet("DATA1.in");
        WordSet s2 = new WordSet("DATA2.in");
        System.out.println(s1.difference(s2));
        System.out.println(s2.difference(s1));
    }
}
