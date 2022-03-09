package controller;

import ejb.CommonBeanLocal;
import entity.Users;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

@Named(value = "loginController")
@RequestScoped
public class LoginController {

    @Inject
    CommonBeanLocal cbl;

    public LoginController() {
    }

    private String email;
    private String password;

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

    public String doLogin() {
        Users user = null;
        user = cbl.doLogin(email, password);

        if (user != null) {
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            String roleName = cbl.getRoleNameByLogin(email, password);
            session.setAttribute("username", user.getFirstName() + " " + user.getLastName());
            session.setAttribute("userId", user.getUserId());
            session.setAttribute("rolename", roleName);
            session.setMaxInactiveInterval(60 * 15);

            if ("Super Admin".equals(roleName)) {
                return "/auth/admin/dashboard/index.xhtml?faces-redirect=true";
            } else if ("Bureo Admin".equals(roleName)) {
                Integer bureoId = cbl.getBureoIdByLogin(email, password);
                session.setAttribute("bureoId", bureoId);
                return "/auth/bureo/dashboard/index.xhtml?faces-redirect=true";
            } else {
                Integer bureoId = cbl.getBureoIdByLoginForUser(email, password);
                session.setAttribute("bureoId", bureoId);
                return "/auth/user/dashboard/index.xhtml?faces-redirect=true";
            }

        }
        return "/shared/login/login.xhtml?faces-redirect=true";
    }

    public String doLogout() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "/shared/home.xhtml?faces-redirect=true";
    }
}
