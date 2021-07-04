package pyramidassignment_1;
import static javax.swing.Spring.height;

/**
 *
 * @author Mohamed Elgindy
 */
public class Pyramid {
    private String pharoh ="", modern_name="" , site="";
    private double height =0;
    
    public Pyramid(){}
    
    public Pyramid(String pharoh , String modern_name , String site , double height){
        super();
        try{
            this.pharoh = pharoh;
        }catch(Exception e){e.printStackTrace();}
            
        try{
            this.modern_name = modern_name;
        }catch(Exception e){e.printStackTrace();}
        
        try{
            this.site = site;
        }catch(Exception e){e.printStackTrace();}
        
        try{
            this.height = height;
        }catch(Exception e){e.printStackTrace();}
    }

    
    public void setPharoh(String pharoh) {
        this.pharoh = pharoh;
    }

    public String getModern_name() {
        return modern_name;
    }

    public void setModern_name(String modern_name) {
        this.modern_name = modern_name;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    
    @Override
    public String toString(){
       return "Pyramid(" +
                "pharoh ='" + pharoh + '\'' + ", modern_name='" + modern_name + 
               '\'' + ", site='" + site + '\'' + ", height='" + height + '\'' +')';
    }
}
