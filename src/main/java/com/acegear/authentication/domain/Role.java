package com.acegear.authentication.domain;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = true, length = 30)
    private String roleName;

    @CreationTimestamp
    private Timestamp createAt;
    @UpdateTimestamp
    private Timestamp updateAt;

    @OneToMany
    @JoinTable(name = "role_acl", joinColumns = {@JoinColumn(name = "roleId")}, inverseJoinColumns = {
            @JoinColumn(name = "aclId")})
    private List<Acl> aclList;


    public Role() {
    }

    public Role(String roleName, Timestamp createAt, Timestamp updateAt, List<Acl> aclList) {
        this.roleName = roleName;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.aclList = aclList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
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

    public List<Acl> getAclList() {
        return aclList;
    }

    public void setAclList(List<Acl> aclList) {
        this.aclList = aclList;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", aclList=" + aclList +
                '}';
    }
}
