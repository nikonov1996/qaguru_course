package reqresin.models.pojoModels;

public class LoginRequestModel {
    public String email;
    public String password;

    public LoginRequestModel withEmail(String email) {
        this.email = email;
        return this;
    }

    public LoginRequestModel withPassword(String password) {
        this.password = password;
        return this;
    }


}
