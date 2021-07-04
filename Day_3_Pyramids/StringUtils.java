/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day_3;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

/**
 *
 * @author Mohamed Elgindy
 */
public class StringUtils {
    public String betterString(String str1 , String str2 , BiPredicate<String , String>pd){
        if(pd.test(str1, str2)){
            return str1;
        }else{return str2;}}
    
    public boolean checkAlphapet(String s, Predicate<String>p){
        return p.test(s);
    }
}
