import java.io.*;
import java.util.Scanner;

public class Menu {

    String[] categories = new String[]{"Pizza", "Burger", "Sides"};
    public Menu() {
        //Create the contents of the menu by 3 categories
        String[] pizza = new String[]{"Margarita", "Pepperoni", "Hawaii"};
        writeCategoryMenuToFile(categories[0], pizza);

        String[] burger = new String[]{"Classic", "Bacon", "Vegetarian", "Chicken"};
        writeCategoryMenuToFile(categories[1], burger);

        String[] sides = new String[]{"Fries", "Ketchup"};
        writeCategoryMenuToFile(categories[2], sides);
    }

    public void writeCategoryMenuToFile(String category, String[] categoryMenu){
        //create a method with the variables String category and the String array categoryMenu.

        //Create a text-file within the src\ folder.
        //When it is created, it confirms it and writes the name of it.
        //the "try" and "catch" statements are used to indicate an exception in the file creation.
        File file = null;
        try {
            file = new File("src/" + category + ".txt");
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            }
            FileWriter filewriter = new FileWriter(file);
            for(int k = 0; k < categoryMenu.length; k++) {
                filewriter.write(categoryMenu[k] + "\n");
            }
            filewriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public int selectCategory(){
        //Use a for loop to indicate which number corresponds to a category
        System.out.println("Select a category number:");
        for(int k = 0; k < categories.length; k++){
            System.out.println(k + ": " + categories[k]);
        }
        //Use a scanner to read the input from the user and show them what they have chosen.
        Scanner userInput = new Scanner(System.in);
        int choice = Integer.parseInt(userInput.nextLine());
        System.out.println("You've selected: " + categories[choice]);
        return choice;
    }
    public void selectDish(int categoryNumber){
        System.out.println("Select dish from " + categories[categoryNumber] + " menu");
        //Create an array for the dishes with the max capacity at 5.
        //Reads the category from the file that was created earlier.
        //Using try and catch to throw an exception if an error during the file-read occurs.
        String[] dishes = new String[5];
        try {
            File file = new File("src/" + categories[categoryNumber] + ".txt");
            Scanner myReader = new Scanner(file);
            int i = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                dishes[i] = data;
                System.out.println(i + ": " + dishes[i]);
                i++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        //Use a scanner to read input from the user and lets them know what they have ordered.
        Scanner userInput = new Scanner(System.in);
        int choice = Integer.parseInt(userInput.nextLine());
        System.out.println("You've ordered a " + dishes[choice] +  " " + categories[categoryNumber]);

    }

}
