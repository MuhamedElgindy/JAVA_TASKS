package mans_1.joinary_task;

import joinery.DataFrame;
import java.io.IOException;

/**
 *
 * @author Mohamed Elgindy
 */
public class Joinary_Task {

    public Joinary_Task() {}
    
    public static void main(String[] args) throws IOException {
    System.out.println("Joinary_Task");
     
    try{
    DataFrame <Object> df = DataFrame.readCsv("E:\\CS\\AI_PRO ITI Scholership\\Semester 1\\Java\\Data\\titanic.csv");
        System.out.println(df.toString());
        
        System.in.read();
        System.out.println("Stander Diveation");
        System.out.println(df.stddev());
        
        System.in.read();
        System.out.println("Minimum");
        System.out.println(df.min());
        
        System.in.read();
        System.out.println("Maximam");
        System.out.println(df.stddev());
        
        System.in.read();
        System.out.println("Sum");
        System.out.println(df.sum());
        
        System.in.read();
        System.out.println("mean");
        System.out.println(df.mean());
        
        System.in.read();
        System.out.println("median");
        System.out.println(df.median());
        
        System.in.read();
        System.out.println("Size: "+df.size());
        
        System.in.read();
        System.out.println("head");
        System.out.println(df.head());
        
        System.in.read();
        System.out.println("first 5 col");
        System.out.println(df.head(5));
        
        System.in.read();
        System.out.println("Last 5 Col");
        System.out.println(df.tail(5));
    
    }catch(IOException e){e.printStackTrace();}
    
    }
}