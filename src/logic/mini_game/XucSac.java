package logic.mini_game;
public class XucSac {
    private int soCham;

    public int getSoCham() {
        return soCham;
    }

    public void setSoCham(int soCham) {
        this.soCham = soCham;
    }

    public XucSac() {
        this.soCham = 1;
    }
    public void inXucSac(){
        switch (this.soCham){
            case 1:
                System.out.println("----------");
                System.out.println("|        |");
                System.out.println("|    *   |");
                System.out.println("|        |");
                System.out.println("----------");
                break;
            case 2:
                System.out.println("----------");
                System.out.println("|        |");
                System.out.println("|  *  *  |");
                System.out.println("|        |");
                System.out.println("----------");
                break;
            case 3:
                System.out.println("----------");
                System.out.println("|       *|");
                System.out.println("|    *   |");
                System.out.println("|*       |");
                System.out.println("----------");
                break;
            case 4:
                System.out.println("----------");
                System.out.println("| *    * |");
                System.out.println("|        |");
                System.out.println("| *    * |");
                System.out.println("----------");
                break;
            case 5:
                System.out.println("----------");
                System.out.println("| *    * |");
                System.out.println("|    *   |");
                System.out.println("| *    * |");
                System.out.println("----------");
                break;
            case 6:
                System.out.println("----------");
                System.out.println("| *    * |");
                System.out.println("| *    * |");
                System.out.println("| *    * |");
                System.out.println("----------");
                break;
        }
    }
}
