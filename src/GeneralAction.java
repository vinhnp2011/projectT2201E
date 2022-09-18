/**
 * @author VinhNP
 * @description
 * @date(MM-dd-yyyy HH:mm) 09-13-2022 00:30
 **/
public interface GeneralAction {

    void addAction(String name);

    void findAllAction(String name);

    void updateAction(String name);

    void searchAction(String name);
    void reportAction(String namePar, String nameChil);

}
