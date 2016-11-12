
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Elgalad
 */
public class savedUsers implements userDataHandler{
    @Override
    public User getUserInformation(String username) {
        List<User> user = new ArrayList();
        user.add(new User("samwise_the_brave", "IcancarryU"));
        user.add(new User("vader_66", "FatherOf2"));
        user.add(new User("star_lord_88", "Dancer02"));

        User userFound = null;
        for (int i = 0; i < user.size(); i++) {
            if (username.equals(user.get(i).getUsername())) {
            userFound = user.get(i);
            return userFound;
            }
        }
        return userFound;
    }
}
