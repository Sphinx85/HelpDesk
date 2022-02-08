package Entites;

import javax.persistence.*;

@Entity
@Table(name = "statementtype")
public class Statementtype {
    @Id
    @Column(name = "flag", nullable = false)
    private Integer id;

    @Column(name = "description")
    private String description;

    public Statementtype() {
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