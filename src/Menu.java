
import data.FakeData;

import java.util.Scanner;

public class Menu {
    static Scanner scPar = new Scanner(System.in);
    static Scanner scChild = new Scanner(System.in);

    static FakeData fakeData = new FakeData();
    static Menu menu = new Menu();
    static Aaction action = new Aaction();


    public Menu() {
    }

    public static void main(String[] args) {

        menu.MenuParent();
        System.out.printf("Cam on ban da su dung dich vu!!!!!");


    }

    void MenuParent() {
        while (true) {
            MenuParentStr();
            System.out.print("=> Moi ban chon: ");
            int choose = scPar.nextInt();
            System.out.println();
            switch (choose) {
                case 1:
                    System.out.println(" ==> CRUD nhom hang    ");
                    MenuChild(utils.NHOM_HANG);
                    break;
                case 2:
                    System.out.println(" ==> CRUD san pham     ");
                    MenuChild(utils.SAN_PHAM);
                    break;
                case 3:
                    System.out.println(" ==> CRUD don hang     ");
                    MenuChild(utils.DON_HANG);
                    break;
                case 4:
                    System.out.println(" ==> CRUD Bao cao      ");
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
            MenuChildStr(name);
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
                    if(!name.equals(utils.DON_HANG)) {
                        System.out.println(" ==> Tim kiem " + name + " ");
                        action.searchAction(name);
                        break;
                    }
                    choose = 5;
                case 4:
                    if(!name.equals(utils.DON_HANG)){
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

    private void MenuParentStr() {
        System.out.println(" +---+---- Quan ly ban hang ---------+ ");
        System.out.println(" | 1.| CRUD nhom hang                | ");
        System.out.println(" | 2.| CRUD san pham                 | ");
        System.out.println(" | 3.| CRUD don hang                 | ");
        System.out.println(" | 4.| Bao cao                       | ");
        System.out.println(" | 5.| Ket thuc                      | ");
        System.out.println(" +---+-------------------------------+ ");
    }

    private void MenuChildStr(String name) {
        System.out.println(" +---+----" + name + "---------");
        System.out.println(" | 1.| Them " + name + " ");
        System.out.println(" | 2.| Hien thi " + name + " ");
        if (!name.equals(utils.DON_HANG)) {
            System.out.println(" | 3.| Tim kiem " + name + " ");
            System.out.println(" | 4.| Cap nhat " + name + " ");
            System.out.println(" | 5.| Ket thuc!             ");
        } else {
            System.out.println(" | 3.| Ket thuc!             ");
        }
        System.out.println(" +---+----------------------- ");
    }
}
