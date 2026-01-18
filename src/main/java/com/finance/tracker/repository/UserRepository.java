package com.finance.tracker.repository;

import com.finance.tracker.model.User;
import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    private Map<String,User> users;
    private static final String DATA_DIRECTORY = "data";
    private static final String USERS_FILE = "users.json";

    public UserRepository() {
        this.users = new HashMap<>();
    }

    public boolean userExists(String username) {
        return users.containsKey(username);
    }

    public void addUser(User user) {
        users.put(user.getUsername(), user);
    }

    public User getUser(String username) {
            return users.get(username);
    }

    public Map<String,User> getAllUsers() {
        return users;
    }

    public int getUserCount() {
        return users.size();
    }
}


