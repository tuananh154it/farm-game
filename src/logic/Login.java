package logic;

import entity.Account;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Login {
    public static boolean logIn(ArrayList<Account> accounts) {
        String userName;
        String password;
        while (true) {
            try {
                System.out.print("Nhập tên tài khoản: ");
                userName = new Scanner(System.in).nextLine();
                System.out.print("Nhập mật khẩu: ");
                password = new Scanner(System.in).nextLine();
                if (!AccountLogic.isExist(accounts, userName, password)) {
                    throw new Exception();
                }
                return true;
            } catch (Exception e) {
                System.out.println("Nhập sai tài khoản hoặc mật khẩu, vui lòng nhập lại !!!");
                System.out.println("1. Nhập lại");
                System.out.println("2. Không đăng nhập nữa");
                System.out.print("Nhập vào lựa chọn chọn của bạn: ");
                int choose;
                while (true) {
                    try {
                        choose = new Scanner(System.in).nextInt();
                        if (choose < 1 || choose > 2) {
                            throw new InputMismatchException();
                        }
                        break;
                    } catch (Exception ee) {
                        System.out.print("Chỉ được chọn 1 hoặc 2, vui lòng nhập lại: ");
                    }
                }
                if (choose != 1) {
                    return false; // trả về đánh dấu
                }
            }
        }
    }

}
