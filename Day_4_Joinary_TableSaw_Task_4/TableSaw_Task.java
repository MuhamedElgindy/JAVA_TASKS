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
public class TableSaw_Task {

    public TableSaw_Task() {
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
    
    public static void main(String[] args) throws IOException {
        System.out.println("TableSaw_Task");
        TableSaw_Task tda = new TableSaw_Task();
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
            System.out.println("Titanic Table Summary");
            System.out.println(tda.getDataSummary(tda.titanicData));
            
            
            System.out.println("VG_Sales Table Summary");
            System.out.println(tda.getDataSummary(tda.vgsalesData));
            
            
//           
            
        }catch (IOException e) {}
    }   
}