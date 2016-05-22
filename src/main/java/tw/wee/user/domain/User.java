package tw.wee.user.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.joda.deser.LocalDateDeserializer;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.joda.time.LocalDate;
import tw.wee.user.enumeration.Gender;
import tw.wee.user.enumeration.RoleType;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

@JsonInclude(NON_EMPTY)
public class User {

    private Integer userId;
    @NotBlank
    private String name;
    @NotBlank
    @Valid @Email
    private String email;
    @NotBlank
    private String password;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate birth;

    private Gender gender;
    @Max(value = 11)@Min(value = 11)
    private String mobile;

    private Boolean disactiveIndicator;
    @NotBlank
    private RoleType role;

    public User() {
    }

    public User(String name, String email, String password, RoleType role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer customerId) {
        this.userId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Boolean getDisactiveIndicator() {
        return disactiveIndicator;
    }

    public void setDisactiveIndicator(Boolean disactiveIndicator) {
        this.disactiveIndicator = disactiveIndicator;
    }

    public RoleType getRole() {
        return role;
    }

    public void setRole(RoleType role) {
        this.role = role;
    }
}
