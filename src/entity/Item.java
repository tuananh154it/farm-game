package entity;

import constant.ItemType;

import java.time.LocalDateTime;

public class Item {
    private static int AUTO_ID = 10000;
    private int id;
    private LocalDateTime startTime;
    private ItemType itemType;
    public Item(ItemType itemType){
        this.id = AUTO_ID++;
        this.itemType = itemType;
        this.startTime = LocalDateTime.now();
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public int getId() {
        return id;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", startTime=" + startTime +
                ", itemType=" + itemType +
                '}';
    }
}
