package reqresin.models.pojoModels;

import java.util.Objects;

public class LoginResponseModel {
    String token;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoginResponseModel that = (LoginResponseModel) o;
        return Objects.equals(token, that.token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(token);
    }

    public LoginResponseModel withToken(String token){
        this.token = token;
        return this;
    }

    public String getToken(){
        return token;
    }
}
