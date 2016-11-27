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
    
    public String first;
    public String last;
    public String birth;
    
    Person () {
        first = null;
        last = null;
        birth = null;
    }
    
    public void setFirst(String first) {
        this.first = first;
    }
    
    public void setLast(String last) {
        this.last = last;
    }
    
    public void setBirth(String birth) {
        this.birth = birth;
    }
    
    public String getFirst() {
        return first;
    }
    
    public String getLast() {
        return last;
    }
    
    public String getBirth() {
        return birth;
    }
}
