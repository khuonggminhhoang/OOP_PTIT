import java.util.Scanner;
import java.util.TreeSet;

class WordSet{
    private TreeSet<String> set ;
    public WordSet(){
        this.set = new TreeSet<>();
    }
    public WordSet(String s){
        this.set = new TreeSet<>();
        String[] arr = s.toLowerCase().trim().split("\\s+");
        for(String x : arr){
            this.set.add(x);
        }
    }

    public WordSet union(WordSet second){
        WordSet ans = new WordSet();
        TreeSet<String> set = new TreeSet<>();
        for(String x : this.set){
            set.add(x);
        }
        for(String x : second.getSet()){
            set.add(x);
        }
        ans.setSet(set);
        return ans;
    }

    public WordSet intersection(WordSet second){
        WordSet ans = new WordSet();
        TreeSet<String> set = new TreeSet<>();
        for(String x : this.set){
            if(second.getSet().contains(x)){
                set.add(x);
            }
        }
        ans.setSet(set);
        return ans;
    }
    
    public void setSet(TreeSet<String> set) {
        this.set = set;
    }

    public TreeSet<String> getSet() {
        return this.set;
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

public class wordset_J04022 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        WordSet s1 = new WordSet(in.nextLine());
        WordSet s2 = new WordSet(in.nextLine());
        System.out.println(s1.union(s2));
        System.out.println(s1.intersection(s2));
    }
}
