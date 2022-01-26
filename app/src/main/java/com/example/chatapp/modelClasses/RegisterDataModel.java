package com.example.chatapp.modelClasses;

public class RegisterDataModel {

    private String userName;
    private String userEmail;
    private String userPassword;
    private String id;
    private String imageURl;
    private String Status;
    private String search;


    public RegisterDataModel() {
    }

    public RegisterDataModel(String userName, String userEmail, String userPassword, String id, String imageURl, String status, String search) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.id = id;
        this.imageURl = imageURl;
        Status = status;
        this.search = search;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getImageURl() {
        return imageURl;
    }

    public void setImageURl(String imageURl) {
        this.imageURl = imageURl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
