/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mans_1.joinary_task;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import tech.tablesaw.api.*;

/**
 *
 * @author Mohamed Elgindy
 */
public class TableSaw_join_merge_addCol {

    public TableSaw_join_merge_addCol() {
    }
    
    Table titanicData;
    Table vgsalesData;
    String dataPath_1 = "E:\\CS\\AI_PRO ITI Scholership\\Semester 1\\Java\\Data\\titanic.csv";
    String dataPath_2 = "E:\\CS\\AI_PRO ITI Scholership\\Semester 1\\Java\\Data\\vgsales.csv";
    
    public Table loadDataFromCSV(String path) throws IOException{
        Table titanicData = Table.read().csv(path);
        return titanicData;
    }
    
    public String getDataInfoStructure(Table data){
        Table dataStructure = data.structure();
        return dataStructure.toString();
    }
    
    public String getDataSummary(Table data){
        Table summary = data.summary();
        return summary.toString();
    }
    
    public Table addColumn(Table data){
        int rowCount = data.rowCount();
        Integer[]val = new Integer[rowCount];
        for(int i=0; i<rowCount; i++){
            val[i]=i;
        }
        IntColumn col = IntColumn.create("NewColumn",val);
        return data.addColumns(col);
    }
   
    
    
    public static void main(String[] args) throws IOException {
        System.out.println("TableSaw_Task");
        TableSaw_join_merge_addCol tda = new TableSaw_join_merge_addCol();
        try{
            tda.titanicData =tda.loadDataFromCSV(tda.dataPath_1);
            String structure_1 = tda.getDataInfoStructure(tda.titanicData);
            System.out.println("Table Structure_Titanic");
            System.out.println(structure_1);
//            
            System.in.read();
            
            tda.vgsalesData =tda.loadDataFromCSV(tda.dataPath_2);
            String structure_2 = tda.getDataInfoStructure(tda.vgsalesData);
            System.out.println("Table Structure VG_Sales");
            System.out.println(structure_2);
            
            System.in.read();
//            
            System.out.println("Table Summary");
            System.out.println(tda.getDataSummary(tda.titanicData));
            
            
//            
            Table T_1 = tda.titanicData.select("name" , "age" , "fare");
            Table T_2 = tda.vgsalesData.select("Name" , "NA_Sales" , "EU_Sales");
            
                        
            
            System.out.println("\n\t\t\t\t\t___Full Outer Join___");
            System.out.println(T_1.joinOn("name").fullOuter(T_2).summary());
            
            System.in.read();
            
            
            Table T_3 = tda.titanicData.select( "age" , "fare");
            Table T_4 = tda.vgsalesData.select("NA_Sales" , "EU_Sales");
            System.out.println("\n\t\t\t\t\t___merging data___");
            System.out.println(T_3.first(5).concat(T_4.first(5)));
            
        }catch (IOException e) {}
    }   
}

