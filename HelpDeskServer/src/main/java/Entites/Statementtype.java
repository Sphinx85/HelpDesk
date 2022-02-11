package Entites;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "statementtype")
public class Statementtype {
    @Id
    @Column(name = "flag", nullable = false)
    private Integer id;

    @Column(name = "description")
    private String description;

    @OneToMany (mappedBy = "type")
    private List<Statement> statementsTypes;

    public Statementtype() {
    }

    public Statementtype(Integer id, String description) {
        this.id = id;
        this.description = description;
        statementsTypes = new ArrayList<>();
    }

    public List<Statement> getStatementsTypes() {
        return statementsTypes;
    }

    public void setStatementsTypes(List<Statement> statementsTypes) {
        this.statementsTypes = statementsTypes;
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