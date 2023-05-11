package logic;

import entity.Account;
import entity.Asset;
import entity.Item;
import logic.mini_game.Game;
import util.FileUtil;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuManagement {
    // Account
    private Account account;
    // Asset
    private Asset asset;
    // Item
    private ArrayList<Item> itemArrayList;
    private ItemLogic itemLogic;

    public MenuManagement() {
        this.account = FileUtil.readAccountFromFile("AccountOnline.txt");
        if(account != null){
            this.asset = FileUtil.readAssetFromFile(account.getToken() + "_Asset.txt");
        }else {
            this.asset = new Asset();
        }
        this.itemArrayList = new ArrayList<>();
        this.itemLogic = new ItemLogic(itemArrayList, asset);
    }

    public void menu() {
        while (true) {
            showMenu();
            System.out.print("Nhập vào lựa chọn chọn của bạn: ");
            int choose;
            while (true){
                try{
                    choose = new Scanner(System.in).nextInt();
                    if (choose<1 || choose>5){
                        throw new Exception();
                    }
                    break;
                }catch (Exception e){
                    System.out.print("Chỉ được nhập số từ 1-5, vui lòng nhập lại: ");
                }
            }
            switch (choose) {
                case 1:
                    if (asset == null) {
                        System.out.println("Tài khoản chưa có gì");
                        asset = new Asset();
                        FileUtil.writeDateToFileV2(asset, account.getToken() + "_Asset.txt");
                    }else {
                        asset.showAsset();
                    }
                    break;
                case 2:
                    itemLogic.buyItem();
                    FileUtil.writeDateToFileV2(asset, account.getToken() + "_Asset.txt");
                    break;
                case 3:
                    double bets = Game.inputCoin(asset.getCoin());
                    if (Game.showGame()) {
                        asset.setCoin(asset.getCoin() + bets);
                    } else {
                        asset.setCoin(asset.getCoin() - bets);
                    }
                    FileUtil.writeDateToFileV2(asset, account.getToken() + "_Asset.txt");
                    System.out.println("số dư: " + asset.getCoin() + " coin");
                    break;
                case 4:
                    RankLogic.showRank();
                    break;
                case 5:
                    FileUtil.writeDateToFileV2(asset,account.getToken() + "_Asset.txt");
                    return;
            }
        }
    }

    private void showMenu() {
        System.out.println("+-----------------------Funy Farm-----------------------+");
        System.out.println("|                                                       |");
        System.out.println("|       1. Thống kê tài sản hiện có                     |");
        System.out.println("|       2. Mua giống                                    |");
        System.out.println("|       3. Mini game                                    |");
        System.out.println("|       4. Xem bảng xếp hạng                            |");
        System.out.println("|       5. Đăng xuất                                    |");
        System.out.println("|                                                       |");
        System.out.println("+-------------------------------------------------------+");
    }


}
