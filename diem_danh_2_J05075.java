import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class SinhVien{
    private String id, name, classs, note;
    private int nomalMark;

    public SinhVien(String id, String name, String classs) {
        this.id = id;
        this.name = name;
        this.classs = classs;
        this.nomalMark = 0;
        this.note = "";
    }

    public String getId(){
        return this.id;
    }

    public String getClasss(){
        return this.classs;
    }

    public void setNomalMark(int nomalMark){
        this.nomalMark = nomalMark;
    }

    public void setNote(String note){
        this.note = note;
    }

    @Override
    public String toString(){
        return this.id + " " + this.name + " " + this.classs + " " + this.nomalMark + " " + this.note;
    }
}


public class diem_danh_2_J05075 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.nextLine();
        ArrayList<SinhVien> arr = new ArrayList<>();
        for(int i=0; i<n; ++i){
            arr.add(new SinhVien(scn.nextLine(), scn.nextLine(), scn.nextLine()));
        } 

        while(n-- > 0){
            String id = scn.next();
            String tick = scn.nextLine();
            int mark = 10;
            for(char x : tick.toCharArray()){
                if(x == 'm'){
                    mark -= 1;
                }
                else if(x == 'v'){
                    mark -= 2;
                }
            }
            mark = (mark < 0 ? 0 : mark);
            String note = (mark ==0 ? "KDDK" : "");
            for(SinhVien x : arr){
                if(id.equals(x.getId())){
                    x.setNomalMark(mark);
                    x.setNote(note);
                    break;
                }
            }
        }
        
        String classs = scn.nextLine();
        for(SinhVien x : arr){
            if(classs.equals(x.getClasss())){
                System.out.println(x);
            }
        }
    }
}
