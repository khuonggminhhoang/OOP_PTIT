import java.util.ArrayList;
import java.util.Scanner;

class ThanhPho{
    private String id, name;
    private int cost;
    
    public ThanhPho(String id, String name, int cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}

class CuocGoi{
    private String phone, start, finish;

    public CuocGoi(String phone, String start, String finish) {
        this.phone = phone;
        this.start = start;
        this.finish = finish;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getFinish() {
        return finish;
    }

    public void setFinish(String finish) {
        this.finish = finish;
    }

    public int getTime(){
        return (Integer.parseInt(this.finish.substring(0, 2))
        - Integer.parseInt(this.start.substring(0, 2))) * 60 
        + (Integer.parseInt(this.finish.substring(3))
        - Integer.parseInt(this.start.substring(3)));
    }

}

public class tinh_cuoc_dien_thoai_co_dinh_1_J05071 {
    public static void in(ArrayList<ThanhPho> arr, CuocGoi cuocGoi){
        if(cuocGoi.getPhone().charAt(0) != '0'){
            int time = (int) Math.ceil(1.0 * cuocGoi.getTime()/3);
            System.out.println(cuocGoi.getPhone() + " Noi mang " + time + " " + 800 * time);

        }
        else{
            for(ThanhPho x : arr){
                if(x.getId().equals(cuocGoi.getPhone().substring(1, 3))){
                    System.out.println(cuocGoi.getPhone() + " " + x.getName() + " " + cuocGoi.getTime() + " " + cuocGoi.getTime() * x.getCost());
                    return;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        ArrayList<ThanhPho> arrTp = new ArrayList<>();
        while(t-- >0){  
            scn.nextLine();
            arrTp.add(new ThanhPho(scn.nextLine(), scn.nextLine(), scn.nextInt()));
        }   
        scn.nextLine();
        t = scn.nextInt();
        scn.nextLine();
        while(t-- > 0){ 
            String s = scn.nextLine();
            String[] a = s.split("\\s+");
            CuocGoi cuocGoi = new CuocGoi(a[0], a[1], a[2]);
            in(arrTp, cuocGoi);
        }
    }
}