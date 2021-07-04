/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyramidassignment_1;


import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mohamed Elgindy
 */
public class PyramidCSVDAO {

    public PyramidCSVDAO() {
    }
    
     public Pyramid createPyramid(String [] col){ 
        String pharoh =col[0], modern_name=col[2] , site=col[4];
        double height ;
         if (col[7] == null || col[7].isEmpty() || col[7] == " " ){
            height = 0;
        }else{
            height = Double.parseDouble(col[7]);
        }
        
        Pyramid pramid = new Pyramid(pharoh =col[0], modern_name=col[2] , site=col[4], height);
        return pramid;
     }
    
     public List<Pyramid>readPyramidFromCSV(String fileName){
        
        List <Pyramid> pyramid = new ArrayList<Pyramid>();
      
//        access Data from CSV File 
        File pyrFile = new File(fileName);
        
//        read All Data Line from CSV File and Save it in List
        List<String> lines = new ArrayList<String>();
        try{
//          read All line in once time not loop line by line 
            lines = Files.readAllLines(pyrFile.toPath()); // lines object loop in file
        }catch(Exception e){e.printStackTrace();}
        
//        To skip header in csv file start from line 1 for( 1 -> sz)
        for(int lineIndex = 1; lineIndex<lines.size(); lineIndex++){
            String line = lines.get(lineIndex);
            String [] col = line.split(",");
            
            Pyramid prmd = createPyramid(col);
            pyramid.add(prmd);
            }
        return pyramid;
    }
}
