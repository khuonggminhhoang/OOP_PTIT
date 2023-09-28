import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class doc_ghi_file {
    // public static void main(String[] args) throws IOException {
    //     try {
    //         FileReader reader = new FileReader(new File("inputfile.in"));
    //         FileWriter writer = new FileWriter(new File("outputfile.in"));
    //         int c = 0;
    //         while((c = reader.read()) != -1){
    //             System.out.println((char)c);
    //             writer.write((char)c);
    //         }
    //         writer.close();
            
            
            
    //     } catch (FileNotFoundException e) {
    //         // TODO Auto-generated catch block
    //         System.out.println(e);
    //     }
    // }
    public static void main(String[] args) {
        String textFileName = "inputfile.in"; // Tên tệp tin văn bản
        String binaryFileName = "outputfile.in"; // Tên tệp tin nhị phân
        
        try {
            // Mở tệp tin văn bản để đọc
            BufferedReader reader = new BufferedReader(new FileReader(textFileName));
            
            // Mở tệp tin nhị phân để ghi
            FileOutputStream outputStream = new FileOutputStream(binaryFileName);
            
            int data;
            while ((data = reader.read()) != -1) {
                // Đọc dữ liệu từ tệp tin văn bản và ghi vào tệp tin nhị phân
                outputStream.write(data);
            }
            
            // Đóng các luồng để giải phóng tài nguyên
            reader.close();
            outputStream.close();
            
            System.out.println("Chuyển đổi từ tệp tin văn bản sang tệp tin nhị phân thành công.");
        } catch (IOException e) {
            System.err.println("Xảy ra lỗi: " + e.getMessage());
        }
    }
}

