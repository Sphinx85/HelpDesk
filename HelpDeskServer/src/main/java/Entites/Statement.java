package Entites;

import Services.UserService;

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

    @Column(name = "user_id", nullable = false, unique = true)
    private int user_id;

    @Column(name = "type_id", nullable = false, unique = true)
    private int type_id;

    @Column(name = "priority_id", nullable = false, unique = true)
    private int priority_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private Users users;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_id", nullable = false, updatable = false, insertable = false)
    private Statementtype type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "priority_id", nullable = false, updatable = false, insertable = false)
    private Priority priority;

    public Statement() {
    }

    public Statement(String description) {
        UserService service = new UserService();
        this.description = description;
        this.user_id = 6;
        this.type_id = 570;
        this.priority_id = 1;
        this.users = service.findUser(user_id);
        this.type = service.findStateType(type_id);
        this.priority = service.findPriority(priority_id);
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Users getUsers() {
        return users;
    }

    public int getType_id() {
        return type_id;
    }

    public int getPriority_id() {
        return priority_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public void setPriority_id(int priority_id) {
        this.priority_id = priority_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
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