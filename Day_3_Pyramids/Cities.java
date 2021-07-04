
package day_3;
/**
 *
 * @author Mohamed Elgindy
 */
public class Cities {
    public Cities(){}
    
        int City_code;
	String City_name ;
	String continent ;
	double population ;
	double surfaceArea;
	int Cit_Country_code;

    
        
    public Cities(int City_code, String City_name, String continent, double population, double surfaceArea,int Cit_Country_code) {
            super();
            this.City_code = City_code;
            this.City_name = City_name;
            this.continent = continent;
            this.population = population;
            this.surfaceArea = surfaceArea;
            this.Cit_Country_code = Cit_Country_code;
    }


    public int getCityCode() {
        return City_code;
    }

    public void setCityCode(int City_code) {
        this.City_code = City_code;
    }

    public String getCityName() {
        return City_name;
    }

    public void setName(String City_name) {
        this.City_name = City_name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public double getPopulation() {
        return population;
    }

    public void setPopulation(double population) {
        this.population = population;
    }

    public double getSurfaceArea() {
        return surfaceArea;
    }

    public void setSurfaceArea(double surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public int getCity_Country_code() {
        return Cit_Country_code;
    }

    public void setCountry_code(int Cit_Country_code) {
        this.Cit_Country_code = Cit_Country_code;
    }
    
    @Override
    public String toString() {
        return "Cities[" + "City_code=" + City_code 
                + ", City_name=" + "\t" +City_name 
                + ", continent=" + "\t" +continent 
                + ", population=" + "\t" +population 
                + ", surfaceArea=" + "\t" +surfaceArea 
                + ", Cit_Country_code=" + "\t" +Cit_Country_code 
                + ']';
    }
}
