package logic;
import entity.Account;
import myException.AccountAlreadyExists;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Register {
    // tạo tài khoản
    public static Account create() {
        System.out.print("Nhập tên người dùng(từ 6 ký tự chỉ chứa các ký tự a-z A-Z 0-9): ");
        String userName;
        while (true) {
            try {
                userName = new Scanner(System.in).nextLine();
                if (!userName.matches("^[a-zA-Z0-9]{6,}$")) {
                    throw new InputMismatchException();
                }
                if (!AccountLogic.notExist(userName)) {
                    throw new AccountAlreadyExists("tài khoản đã tồn tại !!!");
                }
                break;
            } catch (InputMismatchException e) {
                System.out.print("Nhập chưa đúng định dạng yêu cầu, vui lòng nhập lạiL: ");
            } catch (AccountAlreadyExists e) {
                System.out.print("Tên tài khoản đã tồn tại, vui lòng nhập tên khác: ");
            } catch (Exception e) {
                System.out.print("Nhập sai yêu cầu nhập lại: ");
            }
        }
        System.out.print("Nhập mật khẩu(từ 6 ký tự chỉ chứa các ký tự a-z A-Z 0-9): ");
        String password;
        while (true) {
            try {
                password = new Scanner(System.in).nextLine();
                if (!password.matches("^[a-zA-Z0-9]{6,}$")) {
                    throw new InputMismatchException();
                }
                break;
            } catch (InputMismatchException e) {
                System.out.print("Nhập chưa đúng định dạng yêu cầu, vui lòng nhập lạiL: ");
            } catch (Exception e) {
                System.out.print("Nhập sai yêu cầu nhập lại: ");
            }
        }
        return new Account(userName, password); // tạo tài khoản
    }
}
