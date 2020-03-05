package models;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class UserModel {
    private int id;
    private String name;
    private String token;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
