package constant;

public enum ItemType {
    RICE("Lúa",50,150,180,2), //3 phút
    MAIZE("Ngô",100,300,300,3), // 5 phút
    SOYBEAN("Đậu Nành",200,400,420,4), // 7 phút
    CHICKEN("Gà",50,150,180,3), //3 phút
    PIG("Lợn",100,300,300,6), // 5 phút
    COW("Bò",300,600,420,10); // 7 phút
    private final String name;
    private final int price;
    private final int sell;
    private final int alive;
    private final double area;

    ItemType(String name, int price, int sell, int alive, double area) {
        this.name = name;
        this.price = price;
        this.sell = sell;
        this.alive = alive;
        this.area = area;
    }
     public static ItemType setItemType(int choose){
         switch (choose) {
             case 1:
                 return CHICKEN;
             case 2:
                 return PIG;
             case 3:
                 return COW;
             case 4:
                 return RICE;
             case 5:
                 return MAIZE;
             case 6:
                 return SOYBEAN;
         }
         return null;
     }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getSell() {
        return sell;
    }

    public int getAlive() {
        return alive;
    }

    public double getArea() {
        return area;
    }
}
