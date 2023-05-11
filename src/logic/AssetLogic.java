package logic;

import entity.Account;
import entity.Asset;

public class AssetLogic {
    private Account account;
    private Asset myAsset;


    public AssetLogic(Account account, Asset myAsset) {
        this.account = account;
        this.myAsset = myAsset;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Asset getMyAsset() {
        return myAsset;
    }

    public void setMyAsset(Asset myAsset) {
        this.myAsset = myAsset;
    }
}
