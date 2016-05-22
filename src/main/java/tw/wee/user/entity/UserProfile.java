package tw.wee.user.entity;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name = "TABLE_USER")
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID", length = 10)
    private Integer userId;

    @Column(name = "NAME", length = 255, nullable = false)
    private String name;

    @Column(name = "EMAIL", length = 255, nullable = false)
    private String email;

    @Column(name = "PASSWORD", length = 255, nullable = false)
    private String password;

    @Column(name = "BIRTH")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private LocalDate birth;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "MOBILE_NUMBER")
    private String mobile;

    @Column(name = "DISACTIVE_FLAG")
    private Character disacitveIndicator;

    @Column(name = "ROLE")
    private String role;

    public UserProfile() {
    }

    public UserProfile(Integer userId, String name, String email, String password, LocalDate birth, String gender, String role) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.birth = birth;
        this.gender = gender;
        this.role = role;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Character getDisacitveIndicator() {
        return disacitveIndicator;
    }

    public void setDisacitveIndicator(Character disacitveIndicator) {
        this.disacitveIndicator = disacitveIndicator;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
