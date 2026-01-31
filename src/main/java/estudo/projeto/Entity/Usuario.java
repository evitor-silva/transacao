package estudo.projeto.Entity;

import jakarta.persistence.*;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false )
    private String name;

    @Column(name = "password", nullable = false )
    private String password;

    public Usuario(){}

    public Usuario(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public void setPassword( String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}