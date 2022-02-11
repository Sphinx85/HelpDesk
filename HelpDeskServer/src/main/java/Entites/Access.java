package Entites;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "access")
public class Access {
    @Id
    @Column(name = "flag", nullable = false)
    private int id;

    @Column(name = "description")
    private String description;

    @OneToMany (mappedBy = "access")
    private List<Users> usersAccess;

    public Access() {
    }

    public Access(String description) {
        this.description = description;
        usersAccess = new ArrayList<>();
    }

    public List<Users> getUsersAccess() {
        return usersAccess;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsersAccess(List<Users> usersAccess) {
        this.usersAccess = usersAccess;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}