package rest.entities;

import java.util.Date;

public class User  {
    private Integer id;
    private String name;
    private String username;
    private String password;
    private Date created_at;
    private Date modified_at;
    private Date deleted_at;

    private String tablename = "user";

    public User() {
    }

    public User(int id) {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreatedAt() {
        return created_at;
    }

    public void setCreatedAt(Date created_at) {
        this.created_at = created_at;
    }

    public Date getModifiedAt() {
        return modified_at;
    }

    public void setModifiedAt(Date modified_at) {
        this.modified_at = modified_at;
    }

    public Date getDeletedAt() {
        return deleted_at;
    }

    public void setDeletedAt(Date deleted_at) {
        this.deleted_at = deleted_at;
    }

    public String toString(){
        return "Name: " + this.name + " Username " + this.username;
    }
}
