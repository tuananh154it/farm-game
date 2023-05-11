package entity;

import javax.swing.*;
import java.io.Serializable;

public class Asset implements Serializable {
    private double lantArea;
    private double coin;
    // entity
    private int chicken;
    private int pig;
    private int cow;
    private double rice; // m2
    private double maize; // m2
    private double soybean;// m2
    public Asset(){
        this.coin = 100; // tạo tài khoản cho 100 coin
        this.lantArea = 100; // tạo tài khoản cho 100 m vuông đất
    }
    // diện tích trống
    public double getFreeArea(){
        return this.lantArea - this.chicken*3 - this.pig*6 - this.cow*10 - this.rice - this.maize- this.soybean;
    }
    public void showAsset() {
        System.out.println("-------- tài sản của bạn ---------");
        System.out.println("Tổng số tiền: " + this.coin + " coin");
        System.out.println("Đang sở hữu " + this.lantArea + " mét vuông đất");
        System.out.println("Đang nuôi: ");
        if (this.chicken > 0) {
            System.out.println(this.chicken + " con gà");
        }
        if (this.pig > 0) {
            System.out.println(this.pig + " con lợn");
        }
        if (this.cow > 0) {
            System.out.println(this.cow + " con bò");
        }
        System.out.println("Đang trồng: ");
        if (this.rice > 0) {
            System.out.println(this.rice + " mét vuông lúa");
        }
        if (this.maize > 0) {
            System.out.println(this.maize + " mét vuông lúa");
        }
        if (this.soybean > 0) {
            System.out.println(this.soybean + " mét vuông đậu nành");
        }
    }
        // getter, setter
    public double getCoin() {
        return coin;
    }

    public void setCoin(double coin) {
        this.coin = coin;
    }

    public int getChicken() {
        return chicken;
    }

    public void setChicken(int chicken) {
        this.chicken = chicken;
    }

    public int getPig() {
        return pig;
    }

    public void setPig(int pig) {
        this.pig = pig;
    }

    public int getCow() {
        return cow;
    }

    public void setCow(int cow) {
        this.cow = cow;
    }

    public double getRice() {
        return rice;
    }

    public void setRice(double rice) {
        this.rice = rice;
    }

    public double getMaize() {
        return maize;
    }

    public void setMaize(double maize) {
        this.maize = maize;
    }

    public double getSoybean() {
        return soybean;
    }

    public void setSoybean(double soybean) {
        this.soybean = soybean;
    }

    public double getLantArea() {
        return lantArea;
    }

    public void setLantArea(double lantArea) {
        this.lantArea = lantArea;
    }
}
