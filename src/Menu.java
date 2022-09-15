
import data.FakeData;
import utils.CommonUtils;
import view.MenuView;

import java.util.Scanner;

public class Menu {
    static Scanner scPar = new Scanner(System.in);
    static Scanner scChild = new Scanner(System.in);

    static FakeData fakeData = new FakeData();
    static Menu menu = new Menu();
    static GeneralAction action = new GeneralAction();


    public Menu() {
    }

    public static void main(String[] args) {

        menu.MenuParent();
        System.out.printf("Cam on ban da su dung dich vu!!!!!");


    }

    void MenuParent() {
        while (true) {
            MenuView.MenuParentView();
            System.out.print("=> Moi ban chon: ");
            int choose = scPar.nextInt();
            System.out.println();
            switch (choose) {
                case 1:
                    System.out.println(" ==> Da chon CRUD nhom han");
                    MenuChild(CommonUtils.NHOM_HANG);
                    break;
                case 2:
                    System.out.println(" ==> Da chon CRUD san pham");
                    MenuChild(CommonUtils.SAN_PHAM);
                    break;
                case 3:
                    System.out.println(" ==> Da chon CRUD don hang");
                    MenuChild(CommonUtils.DON_HANG);
                    break;
                case 4:
                    System.out.println(" ==> Da chon CRUD Bao cao ");
                    break;
                case 5:
                    break;
                default:
                    System.out.println("ko co lua chon: " + choose + "! Xin vui long chon lai!!!!");
            }
            if (choose == 5) {
                break;
            }
        }
    }

    void MenuChild(String name) {
        while (true) {
            MenuView.MenuChildView(name);
            System.out.print("=> Moi ban chon: ");
            int choose = scChild.nextInt();
            System.out.println();
            switch (choose) {
                case 1:
                    System.out.println(" ==> Them " + name + " ");
                    action.addAction(name);
                    break;
                case 2:
                    System.out.println(" ==> Hien thi " + name + " ");
                    action.showAction(name);
                    break;
                case 3:
                    if(!name.equals(CommonUtils.DON_HANG)) {
                        System.out.println(" ==> Tim kiem " + name + " ");
                        action.searchAction(name);
                        break;
                    }
                    choose = 5;
                case 4:
                    if(!name.equals(CommonUtils.DON_HANG)){
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
            if (choose == 5) {
                break;
            }
        }
    }
}
