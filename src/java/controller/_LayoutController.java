package controller;

import ejb.CommonBeanLocal;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

@Named(value = "_LayoutController")
@RequestScoped
public class _LayoutController {

    @Inject
    CommonBeanLocal cbl;

    public _LayoutController() {
    }

    private String SiteName;
    private String SiteNameInitial;
    private String SiteURL;

    private String username;

    public String getUsername() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);

        if (session == null) {
            return null;
        }

        return session.getAttribute("username").toString();
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSiteName() {
        return cbl.getAppSetting("SiteName");
    }

    public void setSiteName(String SiteName) {
        this.SiteName = SiteName;
    }

    public String getSiteNameInitial() {
        return cbl.getAppSetting("SiteNameInitial");
    }

    public void setSiteNameInitial(String SiteNameInitial) {
        this.SiteNameInitial = SiteNameInitial;
    }

    public String getSiteURL() {
        return cbl.getAppSetting("SiteURL");
    }

    public void setSiteURL(String SiteURL) {
        this.SiteURL = SiteURL;
    }

}
