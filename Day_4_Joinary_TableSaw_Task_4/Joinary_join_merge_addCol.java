package mans_1.joinary_task;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import joinery.DataFrame;

public class Joinary_join_merge_addCol {
  public static void main(String[] args) throws IOException {
      System.out.println("Hello Joinary");
      
      System.out.println("Hello DataFrame : 1");
      DataFrame<Object>df = DataFrame.readCsv("E:\\CS\\AI_PRO ITI Scholership\\Semester 1\\Java\\Data\\titanic.csv");
      List<Object> newCol = df.add(args).col("home.dest");
      try{
            
            DataFrame <Object> df_1 = DataFrame.readCsv("E:\\CS\\AI_PRO ITI Scholership\\Semester 1\\Java\\Data\\titanic.csv")
              .retain("name" , "age" , "fare")
                .head();

            System.out.println(df_1.head().toString());

            System.in.read();

            System.out.println("Hello DataFrame : 2");
              DataFrame <Object> df_2 = DataFrame.readCsv("E:\\CS\\AI_PRO ITI Scholership\\Semester 1\\Java\\Data\\vgsales.csv")
                    .retain("Name" , "NA_Sales" , "EU_Sales")
                      .head();
            System.out.println(df_2.head().toString());

            System.in.read();

            System.out.println("Join DataFrame 1&2 ");
            System.out.println(df_1.join(df_2));

            }catch(IOException e){e.printStackTrace();}

            System.in.read();
            System.out.println("#######################################################");
            try{
                  DataFrame <Object> df_m1 = DataFrame.readCsv("E:\\CS\\AI_PRO ITI Scholership\\Semester 1\\Java\\titanic.csv")
                        .retain("age","name")
                        .head();

                    DataFrame <Object> df_m2 = DataFrame.readCsv("E:\\CS\\AI_PRO ITI Scholership\\Semester 1\\Java\\titanic.csv")
                        .retain("name" , "fare")
                        .tail();


                    
                    System.out.println("merge DataFrame 1&2");
                    System.out.println(df_m1.merge(df_m2));
                    
                    System.in.read();
//                    Add new Coolumn
                    System.out.println(df_m1.add(newCol));
                            

              }catch(IOException e){e.printStackTrace();}      
    }
}

  
