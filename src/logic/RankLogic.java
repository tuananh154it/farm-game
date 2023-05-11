package logic;

import entity.Account;
import entity.Asset;
import util.FileUtil;

import java.util.ArrayList;

public class RankLogic {
    public static void showRank() {
        ArrayList<Account> accountArrayList = FileUtil.readDataFromFileVer2("Account.txt");
        ArrayList<AssetLogic> assetLogics = new ArrayList<>();
        for (int i = 0; i < accountArrayList.size(); i++) {
            Asset assetTemp = FileUtil.readAssetFromFile(accountArrayList.get(i).getToken() + "_Asset.txt");
            assetLogics.add(new AssetLogic(accountArrayList.get(i), assetTemp));
        }
        assetLogics.sort(new AssetLogicComparatorCoin());
        for (int i = 0; i < assetLogics.size(); i++) {
            System.out.print((i + 1) + "   :   " + assetLogics.get(i).getAccount().getUserName() + "   :   ");
            System.out.println(assetLogics.get(i).getMyAsset().getCoin() + " coin");
        }
    }
}
