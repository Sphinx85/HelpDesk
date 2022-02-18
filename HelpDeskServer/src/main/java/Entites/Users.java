package Entites;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, insertable = false, updatable = false)
    private Integer id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "secondname")
    private String secondname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "access")
    private int access_id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "access", insertable = false, updatable = false)
    private Access access;

    @OneToMany(mappedBy = "users")
    //@JoinColumn(name = "users_id")//@JoinColumn(name = "user_id")
    private List<Statement> userStatements;

    public Users() {
    }

    public Users(String firstname, String secondname, String lastname, int flag){
        this.firstname = firstname;
        this.secondname = secondname;
        this.lastname = lastname;
        this.access_id = flag;
        userStatements = new ArrayList<>();
    }

    public int getAccess_id() {
        return access_id;
    }

    public void setAccess_id(int access_id) {
        this.access_id = access_id;
    }

    public void addStatement(Statement statement){
        statement.setUsers(this);
        userStatements.add(statement);
    }

    public List<Statement> getUserStatements() {
        return userStatements;
    }

    public void setUserStatements(List<Statement> userStatements) {
        this.userStatements = userStatements;
    }

    public Access getAccess() {
        return access;
    }

    public void setAccess(Access access) {
        this.access = access;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}