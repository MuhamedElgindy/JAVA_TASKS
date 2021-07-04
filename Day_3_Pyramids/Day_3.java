/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day_3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.*;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toList;


/**
 *
 * @author Mohamed Elgindy
 */
public class Day_3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException{
        // TODO code application logic here
        
//        Lab Excercise 1

//        Country File
        CountryCSVDao ContryDao = new CountryCSVDao();
        List<Countries>cont_lst = ContryDao.readCountryFromCsv("D:\\New folder\\countries.csv");

//        Cities File
        CityCSVDao cityDao = new CityCSVDao();
        List<Cities> cit_lst = cityDao.readCitiesFromCSV("D:\\New folder\\cities.csv");
        
        

        List<Cities> new_city;
        Map<Countries , List<Cities>> Contmap = new HashMap<>();
        for(Countries cnt : cont_lst){
            new_city = new ArrayList();
            for(Cities cit: cit_lst){
                if(cnt.getCountryCode()==cit.getCity_Country_code()){
                    new_city.add(cit);
                }
            }
                Contmap.put(cnt, new_city);
            }
            Contmap.forEach((k,v)->System.out.println("Country "+k+" "+"City "+v));
                 
         // sorted Population for each Countries
         System.out.println("\nPobulation Sorted for each Country\n");
        Contmap.forEach((k, v) ->{ List<Double> sort=v.stream().map(Cities::getPopulation).sorted().collect(Collectors.toList());
			for(double s : sort) {
				System.out.println(s);}});
        
//        Excercise 2

        String str_1 = "Welcom";
        String str_2 = "Hello";
        StringUtils su = new StringUtils();
        System.out.println(su.betterString(str_1, str_2,(str1,str2)->str1.length() > str2.length()));
        System.out.println(su.checkAlphapet(str_1, (s)->
            {
            for(int i=0; i<s.length(); i++){
                if(!Character.isLetter(s.charAt(i))){
                    return false;
                }
            }
            return true;
        }));
        System.out.println(su.checkAlphapet(str_2, (s)->{
            for(int i=0; i<s.length(); i++){
                if(!Character.isLetter(s.charAt(i))){
                    return false;
                }
            }
            return true;
        }));
        
//        Lab Excercise 3
        
//        1
        Map<Integer, List<Cities>> highPop1 = cit_lst.stream()
                .collect(Collectors.groupingBy(Cities::getCityCode));
        
        List<Optional<Double>> hightPopulationCounty = 
                highPop1.values().stream().map(x-> x.stream()
                        .map(Cities::getPopulation)
                .max(Double::compare)
        ).collect(Collectors.toList());
        
        
////        2
        Map<String,List<Cities>>highPop2 = cit_lst.stream()
                .collect(Collectors.groupingBy(Cities::getContinent));
        
        List<Optional<Double>> highestPopulationPerContinent = 
                highPop2.values().stream()
                        .map(x -> x.stream()
                                .map(Cities::getPopulation)
                        .max(Double::compare)
        ).collect(Collectors.toList());
        
////        3
       Map<String, List<Countries>> highPop3 = cont_lst
                .stream()
               .collect(Collectors.groupingBy(Countries::getCapital));

//        List<Optional<Double>> heighPopCapital = 
//                highPop3.values()
//                        .stream()
//                        .map(Cities::getPopulation)
//                        .max()
//                        .getAsDouble();
        
//        4
        
        double median=0.0 , avarage=0.0 ,lowerQuartile=0.0 , upperQuartile=0.0;
        
//      Sorted List of City
        List<Double> sorted_lst = 
                cit_lst.stream()
                .map(Cities::getPopulation)
                .sorted()
                .collect(Collectors.toList());

//        Double sum_of_sorted_list;
//        sum_of_sorted_list = sorted_lst.stream()
//               .reduce(0.0, Double::sum);
//        System.out.println(sum_of_sorted_list);
        
//        Cont number in list to check it even or odd
        Double cnt_of_lst = cit_lst.stream().mapToDouble(cnt->1D).sum();
        System.out.println("Cnt_of_list : "+cnt_of_lst);
        
    if (sorted_lst.size() % 2 == 0) {
                median = ((double)sorted_lst.get((sorted_lst.size()/2)).population + (double)sorted_lst.get((sorted_lst.size())/2 + 1).population)/2;
                lowerQuartile = ((double)sorted_lst.get(sorted_lst.size()/4).population + (double)sorted_lst.get((sorted_lst.size()/4)+ 1).population)/2;
                upperQuartile = ((double)sorted_lst.get((sorted_lst.size()*.75)).population + (double)sorted_lst.get(sorted_lst.size()*.75+1).population)/2;
            }
            else {
                median = (double) sorted_lst.get(sorted_lst.size()/2).population;
                lowerQuartile = (double) sorted_lst.get(sorted_lst.size()/4).population;
                upperQuartile = (double) sorted_lst.get((sorted_lst.size()*.75)).population;
            }

            avarage =sorted_lst.stream().mapToDouble(Cities::getPopulation).average().getAsDouble();

    }
}
