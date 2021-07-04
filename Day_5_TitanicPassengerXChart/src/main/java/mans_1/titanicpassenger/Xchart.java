/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mans_1.titanicpassenger;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.style.Styler;

/**
 *
 * @author Mohamed Elgindy
 */
public class Xchart {
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Hello World!" );
        
        Xchart xchart = new Xchart ();
        List<TitanicPassenger> allPassenger = xchart.getPassengersFromJsonFile();
        xchart.graphPassengerAges(allPassenger);
        try {
            System.in.read();
        } catch (IOException ex) {
            Logger.getLogger(Xchart.class.getName()).log(Level.SEVERE, null, ex);
        }
        xchart.graphPassengerClass(allPassenger);
    }
// Read Json File and return list contaning Titanic

public List<TitanicPassenger> getPassengersFromJsonFile() throws IOException {
    List<TitanicPassenger> allPassenger = new ArrayList<>();
    ObjectMapper objectMapper = new ObjectMapper ();
    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
    String path = "E:\\CS\\AI_PRO ITI Scholership\\Semester 1\\Java\\Day 5\\Session6Xchart\\titanic_csv.json";
    try(InputStream input= new FileInputStream(path)){
//        read json file 
        allPassenger = objectMapper.readValue(input, new TypeReference<List<TitanicPassenger>>(){}); // very usefull
    }catch(FileNotFoundException e){e.printStackTrace();}
        catch (IOException e) {
            e.printStackTrace ();
        }
     return allPassenger;
    }

public void graphPassengerAges(List<TitanicPassenger>passengerList){
    List<Float> pAges = passengerList.stream ().map(TitanicPassenger::getAge).limit(8).collect(Collectors.toList());
    List<String> pNames = passengerList.stream().map(TitanicPassenger::getName).limit(8).collect(Collectors.toList());

    Float ages[] = new Float[pAges.size()];
    String names[] = new String[pNames.size()];

    ages = pAges.toArray(ages);
    names = pNames.toArray(names);
     
//     create chart
    CategoryChart chart = new CategoryChartBuilder().width(1024).height(768).title("Age Histogram").xAxisTitle("Name").xAxisTitle("Age").build();
    chart.getStyler().setLegendPosition (Styler.LegendPosition.InsideNW);
     
//     Customize Chart
    chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNW);
    chart.getStyler().setHasAnnotations(true);
    chart.getStyler().setStacked(true);
    
    chart.addSeries("Passengers Ages", pNames, pAges);
//    To Show it
    new SwingWrapper(chart).displayChart();
    }

public void graphPassengerClass(List<TitanicPassenger>passengerList){
     //filter to get an array of passenger ages
    Map<String,Long>result = passengerList.stream()
            .collect(Collectors.groupingBy(TitanicPassenger::getPclass,Collectors.counting()));
    int size = result.size();
    System.out.println("Size of Map : " +size+"ln");
    
    PieChart chart = new PieChartBuilder().width(800).height(600)
            .title(getClass().getSimpleName()).build();
//    Customize Chart
    Color[]sliceColors = new Color[]{new Color(180,68,50),new Color(130,105,120),new Color(80,143,160)};
    chart.getStyler().setSeriesColors(sliceColors);
//    Series
    chart.addSeries("First Class",result.get("1"));
    chart.addSeries("Second Class",result.get("2"));
    chart.addSeries("Third Class",result.get("3"));
//    Show it
    new SwingWrapper(chart).displayChart();
    }

}