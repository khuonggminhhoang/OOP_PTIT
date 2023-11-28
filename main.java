public class main {
    public static void main(String[] args) {
        Check c = new Check();
        try{
            c.isCode("B21DCCN461");
            c.isPhone("037747621");
        } 
        catch(ValidateException e){
            System.out.println(e);
        }
    }
}
