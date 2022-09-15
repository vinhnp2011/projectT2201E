package view;

import utils.CommonUtils;

/**
 * @author VinhNP
 * @description
 * @date(MM-dd-yyyy HH:mm) 09-15-2022 12:15
 **/
public class MenuView {
     public static void MenuParentView() {
        System.out.println(" +---+---- Quan ly ban hang ---------+ ");
        System.out.println(" | 1.| CRUD nhom hang                | ");
        System.out.println(" | 2.| CRUD san pham                 | ");
        System.out.println(" | 3.| CRUD don hang                 | ");
        System.out.println(" | 4.| Bao cao                       | ");
        System.out.println(" | 5.| Ket thuc                      | ");
        System.out.println(" +---+-------------------------------+ ");
    }

    public static void MenuChildView(String name) {
        System.out.println(" +---+----" + name + "---------");
        System.out.println(" | 1.| Them " + name + " ");
        System.out.println(" | 2.| Hien thi " + name + " ");
        if (!name.equals(CommonUtils.DON_HANG)) {
            System.out.println(" | 3.| Tim kiem " + name + " ");
            System.out.println(" | 4.| Cap nhat " + name + " ");
            System.out.println(" | 5.| Ket thuc!             ");
        } else {
            System.out.println(" | 3.| Ket thuc!             ");
        }
        System.out.println(" +---+----------------------- ");
    }
}
