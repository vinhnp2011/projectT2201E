import java.util.Scanner;

public class Menu {
    ;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        prepaidData();
        while (true) {
            MenuParent();
            System.out.print("Moi ban chon: ");
            int choose = sc.nextInt();
            switch (choose) {
                case 1:
                    System.out.println(" ==> CRUD nhom hang:    ");
                    MenuChild("nhom hang");
                    break;
                case 2:
                    System.out.println(" ==> CRUD san pham:     ");
                    MenuChild("san pham");
                    break;
                case 3:
                    System.out.println(" ==> CRUD don hang:     ");
                    MenuChild("don hang");
                    break;
                case 4:
                    System.out.println(" ==> CRUD Bao cao:      ");
                    break;
                case 5:
                    break;
                default:
                    System.out.println("ko co lua chon: " + choose + "! Xin vui long chon lai!!!!");
            }
            if (choose == 5) {
                break;
            }
            System.out.printf("Cam on ban da su dung dich vu!!!!!");
        }


    }

    static void MenuParent() {
        System.out.println(" ---------Quan Ly ban hang---------      ");
        System.out.println(" 1. CRUD nhom hang:     ");
        System.out.println(" 2. CRUD san pham:      ");
        System.out.println(" 3. CRUD don hang:      ");
        System.out.println(" 4. Bao cao             ");
        System.out.println(" 5. Ket thuc            ");

    }

    static void MenuChild(String name) {
        System.out.println(" ---------" + name + "---------      ");
        System.out.println(" 1. Them "     + name + "  ");
        System.out.println(" 2. Hien thi " + name + "  ");
        System.out.println(" 3. Tim kiem " + name + "  ");
        System.out.println(" 4. cap nhat " + name + "  ");
        System.out.println(" 5. Ket thuc !             ");
    }

    static void prepaidData() {
        NhomHangDao prepaidDataNhomHangDao = new NhomHangDao();
        prepaidDataNhomHangDao.createFakeDataNhomHangDao();
    }
}
