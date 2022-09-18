
import utils.CommonUtils;
import view.MenuView;

import java.util.Scanner;

public class Menu {
    static GeneralAction action = new GeneralActionImpl();

    static void MenuParent() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            MenuView.MenuParentView();
            System.out.print("=> Moi ban chon: ");
            int choose = sc.nextInt();
            switch (choose) {
                case 1:
                    System.out.println(" ==> Da chon CRUD nhom han");
                    MenuChild(CommonUtils.PRODUCT_TYPE);
                    break;
                case 2:
                    System.out.println(" ==> Da chon CRUD san pham");
                    MenuChild(CommonUtils.PRODUCT);
                    break;
                case 3:
                    System.out.println(" ==> Da chon CRUD don hang");
                    MenuChild(CommonUtils.ORDER);
                    break;
                case 4:
                    System.out.println(" ==> Da chon CRUD Bao cao ");
                    MenuChild(CommonUtils.REPORT);
                    break;
                case 5:
                    System.out.println(" Cam on ban da su dung dich vu!");
                    break;
                default:
                    System.out.println("ko co lua chon: " + choose + "! Xin vui long chon lai!!!!");
            }
            if (choose == 5) {
                break;
            }
        }
    }

    static void MenuChild(String name) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            MenuView.MenuChildView(name);
            System.out.print("=> Moi ban chon: ");
            int choose = sc.nextInt();
            System.out.println();
            if (name.equals(CommonUtils.REPORT)){
                choose = getChooseReport(name, choose);
            }else{
                choose = getChoose(name, choose);
            }

            if (choose == 5) {
                break;
            }
        }
    }

    private static int getChooseReport(String name, int choose) {
        switch (choose) {
            case 1:
                System.out.println(" ==> Hien thi " + name + " san pham ");
                action.reportAction(name,CommonUtils.REPORT_ORDER);
                break;
            case 2:
                System.out.println(" ==> Hien thi " + name + " TOP 3 san pham ");
                action.reportAction(name,CommonUtils.REPORT_TOP3);
                break;
            case 3:
                System.out.println(" ==> Ket thuc " + name + "! ");
                break;
            default:
                System.out.println("ko co lua chon: " + choose + "! Xin vui long chon lai!!!!");
        }
        return choose;
    }

    private static int getChoose(String name, int choose) {
        switch (choose) {
            case 1:
                System.out.println(" ==> Them " + name + " ");
                action.addAction(name);
                break;
            case 2:
                System.out.println(" ==> Hien thi " + name + " ");
                action.findAllAction(name);
                break;
            case 3:
                if (!name.equals(CommonUtils.ORDER)) {
                    System.out.println(" ==> Tim kiem " + name + " ");
                    action.searchAction(name);
                    break;
                }
                choose = 5;
            case 4:
                if (!name.equals(CommonUtils.ORDER)) {
                    System.out.println(" ==> Cap nhat " + name + " ");
                    action.updateAction(name);
                }
                break;
            case 5:
                System.out.println(" ==> Ket thuc " + name + "! ");
                break;
            default:
                System.out.println("ko co lua chon: " + choose + "! Xin vui long chon lai!!!!");
        }
        return choose;
    }
}
