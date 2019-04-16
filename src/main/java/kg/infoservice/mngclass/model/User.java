package kg.infoservice.mngclass.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userid")
    private int id;
    @NotEmpty(message = "*Необходимо ввести имя пользователя")
    private String login;
    /*@NotEmpty(message = "*Необходимо ввести номер телефона")
    private String msisdn;*/
    private boolean active;
    @NotEmpty(message = "*Введите ФИО")
    private String name;

    @NotEmpty(message = "*Введите пароль")
    private String password;

    @ManyToOne
    @JoinColumn(name = "roleid")
    private Role role;

}
