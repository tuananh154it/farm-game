package logic;

import constant.ItemType;
import entity.Asset;
import entity.Item;
import myException.CheckCointException;

import java.time.LocalDateTime;
import java.util.*;

public class ItemLogic {
    // list chứa các item đang có
    private ArrayList<Item> itemArrayList;
    // đối tượng thao tác với tài sản hiện có
    private Asset myAsset;

    public ItemLogic(ArrayList<Item> itemArrayList, Asset myAsset) {
        this.itemArrayList = itemArrayList;
        this.myAsset = myAsset;
        checkHavest();
        checkAsset();
    }

    private void checkHavest() {
        Thread checkItem = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    ArrayList<Integer> removeItem = new ArrayList<>();
                    for (int i = 0; i < itemArrayList.size(); i++) {
                        Item x = itemArrayList.get(i);
                        if (x.getStartTime() == null) {
                            continue;
                        }
                        int alive = x.getItemType().getAlive();
                        LocalDateTime havestTime = x.getStartTime().plusMinutes(alive / 60);
                        if (havestTime.isBefore(LocalDateTime.now()) || havestTime.isEqual(LocalDateTime.now())) {
                            myAsset.setCoin(myAsset.getCoin() + x.getItemType().getSell());
                            removeItem.add(i);
                        }
                    }
                    if (!removeItem.isEmpty()) {
                        for (int i = 0; i < removeItem.size(); i++) {
                            itemArrayList.remove(removeItem.get(i));
                        }
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

            }
        });
        checkItem.start();
    }
    // kiểm tra nếu tài sản bằng 0 và không con nông sản nào thì thua
    private void checkAsset() {
        Thread checkAsset = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if(myAsset.getCoin() == 0 && itemArrayList.size() == 0){
                        System.out.println("Game Over !!!");
                        return;
                    }
                }
            }
        });
        checkAsset.start();
    }

    // mua thêm nông sản
    public void buyItem() {
        System.out.println("Bạn muốn mua nông sản nào:");
        System.out.println("1. Gà");
        System.out.println("2. Lợn");
        System.out.println("3. Bò");
        System.out.println("4. Lúa");
        System.out.println("5. Ngô");
        System.out.println("6. Đậu nành");
        System.out.println("7. Không muốn mua nữa !!!");
        System.out.print("Nhập vào lựa chọn chọn của bạn: ");
        int choose;
        ItemType itemType;
        while (true) {
            try {
                choose = new Scanner(System.in).nextInt();
                if (choose < 1 || choose > 7) {
                    throw new InputMismatchException();
                }
                if ( choose == 7){
                    System.out.println("Không mua gì !!!");
                    return;
                }
                itemType = ItemType.setItemType(choose);
                if(itemType.getPrice() > myAsset.getCoin()){
                    throw new CheckCointException();
                }
                break;
            } catch (InputMismatchException e) {
                System.out.print("Chỉ được nhập số từ 1-7, vui lòng nhập lại: ");
            } catch (CheckCointException ee){
                System.out.print("Không đủ tiền để mua con vật này, vui lòng chọn con khác, hoặc không mua nữa: ");
            }
        }
        System.out.print("Số lượng cần mua: ");
        int num = 0;
        while (true) {
            try {
                num = new Scanner(System.in).nextInt();
                if (num < 1 || num > getMax(itemType)) {
                    throw new InputMismatchException();
                }
                if (itemType.getPrice() * num > myAsset.getCoin()) {
                    throw new CheckCointException();
                }
                break;
            } catch (InputMismatchException e) {
                System.out.print("số lượng phải lớn hơn 0 à nhỏ hơn " + getMax(itemType) + ", vui lòng nhập lại: ");
            } catch (CheckCointException x) {
                System.out.print("số tiền của bạn không đủ để mua, vui lòng nhập lại: ");
            }
        }
        for (int i = 0; i < num; i++) {
            itemArrayList.add(new Item(itemType));
        }
        setAsset(itemType, num);
        myAsset.setCoin(myAsset.getCoin() - num * itemType.getPrice());
    }

    // tăng số lượng nông sản trong tài sản
    private void setAsset(ItemType itemType, int num) {
        switch (itemType) {
            case CHICKEN:
                myAsset.setChicken(myAsset.getChicken() + num);
                break;
            case PIG:
                myAsset.setPig(myAsset.getPig() + num);
                break;
            case COW:
                myAsset.setCow(myAsset.getCow() + num);
                break;
            case RICE:
                myAsset.setRice(myAsset.getRice() + num * ItemType.RICE.getArea());
                break;
            case MAIZE:
                myAsset.setMaize(myAsset.getMaize() + num * ItemType.MAIZE.getArea());
                break;
            case SOYBEAN:
                myAsset.setSoybean(myAsset.getSoybean() + num * ItemType.SOYBEAN.getArea());
                break;
        }
    }

    // tìm ra số lượng tối đa có thể mua của một nông sản
    private int getMax(ItemType itemType) {
        return (int) (myAsset.getFreeArea() / itemType.getArea());
    }
}
