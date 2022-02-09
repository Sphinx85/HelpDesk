package Entites;

import javax.persistence.*;

@Entity
@Table(name = "statements")
public class Statement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stateid", nullable = false)
    private Integer id;


    @Column(name = "description", nullable = false)
    private String description;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false, updatable = false, insertable = false)
    private Users users;

    @ManyToOne(optional = false)
    @JoinColumn(name = "type_id", nullable = false, updatable = false, insertable = false)
    private Statementtype type;

    @ManyToOne(optional = false)
    @JoinColumn(name = "priority_id", nullable = false, updatable = false, insertable = false)
    private Priority priority;

    public Statement() {
    }

    public Statement(String description) {
        this.description = description;
        this.users = new Users();
        this.type = new Statementtype();
        this.priority = new Priority();

        this.users.setId(7);
        this.type.setId(541);
        this.priority.setId(1);
    }

    public Statement(String description, int userId, int typeId, int priorityId){
        this.description = description;
        new Users().setId(userId);
        this.type.setId(typeId);
        this.priority.setId(priorityId);
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Statementtype getType() {
        return type;
    }

    public void setType(Statementtype type) {
        this.type = type;
    }

    public Users getUser() {
        return users;
    }

    public void setUser(Users users) {
        this.users = users;
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