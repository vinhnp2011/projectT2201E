import data.FakeData;

import java.util.stream.Stream;

public class Main {
    static int count = 0;
    public static void main(String[] args) {
        if(count == 0){
            new FakeData();
        }

        try {
            Menu.MenuParent();
        }catch (Exception e){
            System.out.println(e);
            System.out.println("Truong trinh` vua` bi out: "+ ++count + " lan vi` loi!!!!!!");
            main(new String[]{});
        }
    }

}
