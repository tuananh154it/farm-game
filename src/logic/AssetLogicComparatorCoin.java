package logic;

import java.util.Comparator;

public class AssetLogicComparatorCoin implements Comparator<AssetLogic> {

    @Override
    public int compare(AssetLogic o1, AssetLogic o2) {
        return (int) ((int)o2.getMyAsset().getCoin() - o1.getMyAsset().getCoin());
    }
}
