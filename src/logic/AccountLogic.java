package logic;

import entity.Account;
import util.FileUtil;
import java.util.ArrayList;
import java.util.Scanner;

public class AccountLogic {
    ArrayList<Account> accounts;
    public boolean status;

    public AccountLogic() {
        this.accounts = FileUtil.readDataFromFileVer2("Account.txt");
        this.status = false;
    }

    public void menu(){
        while (true){
            System.out.println("1. Đăng nhập");
            System.out.println("2. Đăng ký");
            System.out.println("3. thoát game");
            System.out.print("Nhập lựa chọn của bạn: ");
            int choose;
            while (true){
                try{
                    choose = new Scanner(System.in).nextInt();
                    if (choose<1 || choose>3){
                        throw new Exception();
                    }
                    break;
                }catch (Exception e){
                    System.out.print("Chỉ được chọn 1;2;3, vui lòng nhập lại: ");
                }
            }
            switch (choose){
                case 1:
                    status = Login.logIn(accounts);
                    if(status){
                        MenuManagement menuManagement = new MenuManagement();
                        menuManagement.menu();
                    }
                    break;
                case 2:
                    Account temp = Register.create();
                    if (accounts == null){ // ki?m tra xem file l?u danh sách tài kho?n có d? li?u ch?a
                        accounts = new ArrayList<>();
                    }
                    accounts.add(temp);
                    FileUtil.writeDateToFile(accounts,"Account.txt"); // l?u tài kho?n m?i vào file
                    break;
                case 3:
                    System.out.println("đã thoát game !!!");
                    System.exit(0);
            }
        }
    }
    // kiểm tra tài khoản có tồn tại trong data hay không
    public static boolean isExist(ArrayList<Account> accounts, String userName, String password){
        for(Account x : accounts){
            if(x.getUserName().compareTo(userName) == 0 && x.getPassword().compareTo(password) == 0 ){
                FileUtil.writeDateToFileV2(x,"AccountOnline.txt"); // lưu tài khoản đang onl
                return true;
            }
        }
        return false;
    }
    // kiểm tra tài khoản đã tồn tại chưa trước khi taọ
    public static boolean notExist(String userName){
        ArrayList<Account> accountArrayList = FileUtil.readDataFromFileVer2("Account.txt");
        if(accountArrayList != null){
            for(int i = 0; i< accountArrayList.size();i++){
                if(userName.compareTo(accountArrayList.get(i).getUserName()) == 0){
                    return false;
                }
            }
        }
        return true;
    }
}
