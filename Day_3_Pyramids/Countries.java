/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day_3;

import java.util.Objects;

/**
 *
 * @author Mohamed Elgindy
 */
public class Countries {
    public Countries(){}
    private int Country_code ;
    String capital ;

    public Countries(int Country_code, String capital) {
            super();
            this.Country_code = Country_code;
            this.capital = capital;
    }

    public int getCountryCode() {
        return Country_code;
    }

    public void setCountryCode(int Country_code) {
        this.Country_code = Country_code;
    }

    
    public String getCapital() {
        return capital;
    }
    public void setCapital(String capital) {
        this.capital = capital;
    }

    @Override
    public String toString() {
        return "Countries[" + "Country_code = " + Country_code + "\t"+", cpital = " + capital + ']';
    }
    
}
