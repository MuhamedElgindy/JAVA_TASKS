/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day_3;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mohamed Elgindy
 */
public class CountryCSVDao {
    public CountryCSVDao(){}
    
    public Countries CreateCountry (String [] col){
        String capital = col[0].trim(); 
        int Countrycode = Integer.parseInt(col[1].trim());
        
        Countries cont  = new Countries( Countrycode , capital);
        return cont;
    }
    // read from csv file 
    public List<Countries>readCountryFromCsv(String fileName){
        
        List<Countries> country = new ArrayList<Countries>();
        File countryFile = new File(fileName);
        
        
        List <String>lines = new ArrayList<String>();
        try{
            lines = Files.readAllLines(countryFile.toPath());
        }catch(Exception e){e.printStackTrace();}
        
        for(int i=1; i<lines.size(); i++){
            String line = lines.get(i);
            String [] col = line.split(",");
            
            Countries cont = CreateCountry(col);
            country.add(cont);
        }
        return country;
    }
}
