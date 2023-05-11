package entity;
import entity.Asset;
import util.FileUtil;

import java.util.UUID;

import java.io.Serializable;

public class Account implements Serializable {
    private final String token;
    private String userName;
    private String password;
    private Asset asset;

    public Account(String userName, String password) {
        this.token = UUID.randomUUID().toString();
        this.userName = userName;
        this.password = password;
        this.asset = new Asset();
        FileUtil.writeDateToFileV2(this.asset,this.token+"_Asset.txt");
        System.out.println("Tạo tài khoản thành công !!!");
    }

    public String getToken() {
        return token;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Account(String token, String userName, String password, Asset asset) {
        this.token = token;
        this.userName = userName;
        this.password = password;
        this.asset = asset;
    }

    @Override
    public String toString() {
        return "Account{" +
                "token='" + token + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", asset=" + asset +
                '}';
    }
}
