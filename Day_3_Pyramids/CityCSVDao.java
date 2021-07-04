/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day_3;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mohamed Elgindy
 */
//      private String code ="" , name ="" , continent="" ;
//      private double population  , country_code, surface_area;
public class CityCSVDao {

    public CityCSVDao() {}
    
    public Cities createCity(String [] col){
     int City_code = Integer.parseInt(col[0].trim()) ;
     int Cit_Country_code = Integer.parseInt(col[5].trim()); 
     String City_name = col[1] ,  content = col[2];
     double population ,surface_area;
     
     
     
     
     if(col[4]==null || col[4].isEmpty() || col[4]==""){
         population = 0;
     }else{
         population=Double.parseDouble(col[4]);
     }
     if(col[3]==null || col[3].isEmpty() || col[3]==""){
         surface_area = 0;
     }else{
         surface_area=Double.parseDouble(col[3]);
     }
     return new Cities(City_code, City_name, content, population, surface_area, Cit_Country_code);
     
    }
    public List<Cities> readCitiesFromCSV(String fileName) throws IOException{
        List<Cities> city = new ArrayList<>();
        File citFile = new File(fileName);
        
        List <String> lines = new ArrayList<>();
        try{
            lines = Files.readAllLines(citFile.toPath());
        }catch(Exception e){e.printStackTrace();}
        
        for(int i=1; i<lines.size(); i++){
            String line = lines.get(i);
            String [] col = line.split(",");
            
            Cities cit = createCity(col);
            city.add(cit);
        }
        return city;
    }
}
