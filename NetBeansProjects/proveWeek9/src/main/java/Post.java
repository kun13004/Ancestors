
import java.text.ParseException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Elgalad
 */
public class Post {
    private String post;
    private String username;
    private String date;
    
    public Post() {
        
    }

    //constructor
    public Post(String post, String username, String date) {
        this.post = post;
        this.username = username;
        this.date = date;
    }
    
    
    public String toFileString() {
        return post + "  " + username + "  " + date;
    }
    
    public void loadFromFileString(String str) throws ParseException {
        // TODO: Validation should be done here
        String[] parts = str.split("  ");
 
        post = parts[0];
        username = parts[1];
        date = parts[2];
    }
    
    public String getPost() {
        return post;
    }
    
    public void setPost(String post) {
        this.post = post;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
