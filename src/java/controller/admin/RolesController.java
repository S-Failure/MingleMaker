package controller.admin;

import ejb.AdminBeanLocal;
import entity.Roles;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@Named(value = "rolesController")
@RequestScoped
public class RolesController {

    @Inject
    AdminBeanLocal abl;

    public RolesController() {
    }

    private Integer roleId;
    private String roleName;
    private Boolean isDeleted;
    private Date creationDate;
    private Date modificationDate;

    private Collection<Roles> roles;
    private Roles role;

    public Integer getRoleId() {
        return roleId;
    }

    public Collection<Roles> getRoles() {
        return abl.getAllRoles();
    }

    public void setRoles(Collection<Roles> roles) {
        this.roles = roles;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        roleId = role.getRoleId();
        roleName = role.getRoleName();
        isDeleted = role.getIsDeleted();
        creationDate = role.getCreationDate();
        modificationDate = role.getModificationDate();
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }

    public String addRole() {
        abl.addRole(roleName);
        return "/auth/admin/roles/index.xhtml?faces-redirect=true";
    }

    public String editRole(Integer Id) {
        setRole(abl.getRoleById(Id));
        return "/auth/admin/roles/edit.xhtml";
    }

    public String editRole() {
        abl.updateRole(roleId, roleName);
        setRole(new Roles());
        return "/auth/admin/roles/index.xhtml?faces-redirect=true";
    }

    public String deleteRole(Integer Id) {
        abl.deleteRole(Id);
        return "/auth/admin/roles/index.xhtml?faces-redirect=true";
    }
}
