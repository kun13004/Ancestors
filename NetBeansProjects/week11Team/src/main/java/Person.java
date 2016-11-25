/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Elgalad
 */
public class Person {
    
    private String first;
    private String last;
    private String birth;
    
    Person () {
        first = null;
        last = null;
        birth = null;
    }
    
    public void setFirstName(String first) {
        this.first = first;
    }
    
    public void setLastName(String last) {
        this.last = last;
    }
    
    public void setBirthDate(String birth) {
        this.birth = birth;
    }
    
}
