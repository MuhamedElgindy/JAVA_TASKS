/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyramidassignment_1;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) throws FileNotFoundException {
        PyramidCSVDAO pDAO = new PyramidCSVDAO();
        List<Pyramid> pyramids = pDAO.readPyramidFromCSV("E:\\CS\\AI_PRO ITI Scholership\\Semester 1\\Java\\Assignment_1\\Java and UML_Amr Elshafey\\pyramids.csv");
        
        int i=0;
        for (Pyramid p:pyramids){
            System.out.println("# "+(i++)+" - "+p);
            System.out.println("");
        }
        }   
           
           
    }