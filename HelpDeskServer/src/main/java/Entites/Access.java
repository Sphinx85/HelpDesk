package Entites;

import javax.persistence.*;

@Entity
@Table(name = "access")
public class Access {
    @Id
    @Column(name = "flag", nullable = false)
    private int id;


    @Column(name = "description")
    private String description;

    public Access() {
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