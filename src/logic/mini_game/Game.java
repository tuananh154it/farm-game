package logic.mini_game;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Game {
    public static boolean showGame() {
        XucSac[] xucSacs = new XucSac[3];
        System.out.println("================= Cơ hội x2 tiền cược =================");
        System.out.println("=                                                     =");
        System.out.println("=       TÀI (nhập số 1)    ?    XỈU (nhập số 2)       =");
        System.out.println("=                                                     =");
        System.out.println("======== Được ăn cả, ngã về lập tài khoản mới =========");
        int luaChon;
        System.out.print("nhập lựa chọn của bạn(tài nhập 1, xỉu nhập 2): ");
        while (true){
            try{
                luaChon = new Scanner(System.in).nextInt();
                if(luaChon <1 || luaChon>2){
                    throw new InputMismatchException();
                }
                break;
            }catch (InputMismatchException e){
                System.out.println("Chỉ được nhập 1 hoặc 2, nhập lại : ");
            }catch (Exception e){
                System.out.println("Nhập không hợp lệ, vui lòng nhập lại: ");
            }
        }
        lacXucSac(xucSacs);
        return taiHayXiu(xucSacs, luaChon);
    }

    private static void lacXucSac(XucSac[] xucSacs) {
        for (int i = 0; i < xucSacs.length; i++) {
            xucSacs[i] = new XucSac();
            xucSacs[i].setSoCham(new Random().nextInt(6) + 1);
        }
    }

    private static boolean taiHayXiu(XucSac[] xucSacs, int luaChon) {
        inXucSac(xucSacs);
        if (xucSacs[0] == xucSacs[1] && xucSacs[0] == xucSacs[2]) {
            System.out.println("bộ ba đồng nhất ( bạn THUA )");
            return false;
        }
        int sum = xucSacs[0].getSoCham() + xucSacs[1].getSoCham() + xucSacs[2].getSoCham();
        int mark = 1;
        if (sum >= 4 && sum <= 10) {
            System.out.println("số điểm: " + sum + "( XỈU )");
            mark = 2;
        }else {
            System.out.println("số điểm: " + sum + "( TÀI )");
        }
        return checkKQ(luaChon,mark);
    }

    private static boolean checkKQ(int luaChon, int mark) {
        if (luaChon == mark) {
            System.out.println(" !!!!!!!!!!!!!!!!!!!!!!!!!!!Bạn Thắng !!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            return true;
        }
        System.out.println(" !!!!!!!!!!!!!!!!!!!!!!!!!!!  Bạn Thua !!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        return false;
    }

    private static void inXucSac(XucSac[] xucSacs) {
        for (int i = 0; i < xucSacs.length; i++) {
            xucSacs[i].inXucSac();
        }
    }
    public static double inputCoin(double coin){
        double x;
        System.out.print("Nhập số tiền cần cược: ");
        while (true){
            try{
                x = new Scanner(System.in).nextDouble();
                if(x> coin){
                    throw  new InputMismatchException();
                }
                break;
            }catch (InputMismatchException e){
                System.out.print("Không được nhập số tiền cược lớn hơn số tiền bạn đang có: ");
            }catch (Exception e){
                System.out.print("Nhập không hợp lệ, vui lòng nhập lại: ");
            }
        }
        return x;
    }
}
