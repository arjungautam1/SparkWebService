/**
 * @author : Arjun Gautam
 * e-mail : arjungautam5431@gmail.com
 * Date :2021-02-18
 * Time :10:30
 */
package service;

import exception.UserException;
import model.User;

import java.util.Collection;

public interface UserServices {
    public void addUser(User user);

    public Collection<User> getUsers();

    public User getUser(String id);

    public User editUser(User user) throws UserException;

    public void deleteUser(String id);

    public boolean userExist(String id);


}
