import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import java.util.List;

interface Interface{
    public void sayHello();
}

abstract class Test{
    private String s;

    public Test(){}

    public void sayGoodbye(){
        System.out.println("good bye");
    }
}

public class App {
    public static void main(String[] args) {

        // Anonymous class
        Interface a = new Interface() {
            @Override
            public void sayHello() {
                System.out.println("hello!!!!");
            }
            
        };

        Test t = new Test() {
            @Override
            public void sayGoodbye(){
                System.out.println("bye bye!!!");
            }
        };
        t.sayGoodbye();
        a.sayHello();
        int[] a = {1,2,3,4,5};
        ArrayList<Integer> arr = new ArrayList<>();

        
    }
}
