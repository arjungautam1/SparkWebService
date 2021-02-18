/**
 * @author : Arjun Gautam
 * e-mail : arjungautam5431@gmail.com
 * Date :2021-02-18
 * Time :10:31
 */
package service;

import exception.UserException;
import model.User;

import java.util.Collection;
import java.util.HashMap;

public class UserServiceImpl implements UserServices {

    private HashMap<String, User> userHashMap;

    public UserServiceImpl() {
        userHashMap = new HashMap<>();
    }

    @Override
    public void addUser(User user) {
        userHashMap.put(user.getId(), user);
    }

    @Override
    public Collection<User> getUsers() {
        return userHashMap.values();
    }

    @Override
    public User getUser(String id) {
        return userHashMap.get(id);
    }

    @Override
    public User editUser(User forEdit) throws UserException {
        try {

            if (forEdit.getId() == null)
                throw new UserException("ID cannot be blank ");

            User toEdit = userHashMap.get(forEdit.getEmail());

            if (toEdit == null) throw new UserException("User not Found");

            if (forEdit.getEmail() != null)
                toEdit.setEmail(forEdit.getEmail());

            if (forEdit.getName() != null)
                toEdit.setName(forEdit.getName());

            if (forEdit.getId() != null)
                toEdit.setId(forEdit.getId());

            return toEdit;


        } catch (Exception e) {
            throw new UserException(e.getMessage());
        }
    }

    @Override
    public void deleteUser(String id) {
        userHashMap.remove(id);
    }

    @Override
    public boolean userExist(String id) {
        return userHashMap.containsKey(id);
    }
}
