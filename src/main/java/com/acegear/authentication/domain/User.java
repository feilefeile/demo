package com.acegear.authentication.domain;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "user")
public class User implements Serializable {
    private static final long serialVersionUID = 4646368308006129222L;
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = true, length = 50)
    private String username;
    @Column(nullable = true, length = 50)
    private String password;
    @Column(nullable = true, length = 50)
    private String accessToken;
    @Column(nullable = true, length = 50)
    private String name;
    @Column(nullable = true)
    private Long phone;
    @Column(nullable = true, length = 50)
    private String email;
    @Column(nullable = false)
    private int state;

    @CreationTimestamp
    private Timestamp createAt;
    @UpdateTimestamp
    private Timestamp updateAt;

    @OneToOne
    @JoinTable(name = "user_role", joinColumns = {@JoinColumn(name = "userId")}, inverseJoinColumns = {
            @JoinColumn(name = "roleId")})
    private Role role;

    @OneToMany
    @JoinTable(name = "user_acl", joinColumns = {@JoinColumn(name = "userId")}, inverseJoinColumns = {
            @JoinColumn(name = "aclId")})
    private List<Acl> aclList;


    public User() {
    }

    public User(String username, String password, String accessToken, String name, Long phone, String email, int state, Timestamp createAt, Timestamp updateAt, Role role, List<Acl> aclList) {
        this.username = username;
        this.password = password;
        this.accessToken = accessToken;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.state = state;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.role = role;
        this.aclList = aclList;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Timestamp getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }

    public Timestamp getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Timestamp updateAt) {
        this.updateAt = updateAt;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Acl> getAclList() {
        return aclList;
    }

    public void setAclList(List<Acl> aclList) {
        this.aclList = aclList;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", accessToken='" + accessToken + '\'' +
                ", name='" + name + '\'' +
                ", phone=" + phone +
                ", email='" + email + '\'' +
                ", state=" + state +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", role=" + role +
                ", aclList=" + aclList +
                '}';
    }
}
