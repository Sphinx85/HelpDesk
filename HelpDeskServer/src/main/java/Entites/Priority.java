package Entites;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "priority")
public class Priority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "description", nullable = false)
    private String description;

    @OneToMany (mappedBy = "priority")
    private List<Statement> statementsPriority;

    public Priority() {
    }

    public Priority(String description) {
        this.description = description;
        statementsPriority = new ArrayList<>();
    }

    public List<Statement> getStatementsPriority() {
        return statementsPriority;
    }

    public void setStatementsPriority(List<Statement> statementsPriority) {
        this.statementsPriority = statementsPriority;
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