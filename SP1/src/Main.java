import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //initialize a menu object.
        Menu menu = new Menu();
        //make user select a menu category.
        int categoryNumber = menu.selectCategory();
        //make user select a dish within the chosen category.
        menu.selectDish(categoryNumber);

    }

}