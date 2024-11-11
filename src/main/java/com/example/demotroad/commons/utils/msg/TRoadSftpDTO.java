package com.example.demotroad.commons.utils.msg;

public class TRoadSftpDTO {

    private String path;
    private String address;
    private String id;
    private String pwd;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public String getpath() {
        return this.path;
    }

    public TRoadSftpDTO path(String path) {
        this.setpath(path);
        return this;
    }

    public void setpath(String path) {
        this.path = path;
    }

    public String getaddress() {
        return this.address;
    }

    public TRoadSftpDTO address(String address) {
        this.setaddress(address);
        return this;
    }

    public void setaddress(String address) {
        this.address = address;
    }

    public String getid() {
        return this.id;
    }

    public TRoadSftpDTO id(String id) {
        this.setid(id);
        return this;
    }

    public void setid(String id) {
        this.id = id;
    }

    public String getpwd() {
        return this.pwd;
    }

    public TRoadSftpDTO pwd(String pwd) {
        this.setpwd(pwd);
        return this;
    }

    public void setpwd(String pwd) {
        this.pwd = pwd;
    }


    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TRoadSftpDTO{" +
            " path='" + getpath() + "'" +
            ", address='" + getaddress() + "'" +
            ", id='" + getid() + "'" +
            ", pwd='" + getpwd() + "'" +
            "}";
    }
}
