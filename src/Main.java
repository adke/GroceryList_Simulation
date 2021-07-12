
import java.util.Locale;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in); //creating Scanner object
    private static GroceryList groceryList = new GroceryList(); //creating GroceryList object

    public static void main(String[] args) {
        boolean quit = false;
        int choice = 0;

        //initial outputs for the program on the terminal
        System.out.println("\nWELCOME TO THE VIRTUAL GROCERY LIST SIMULATION!");
        System.out.println("\n----------------------------------------------");
        System.out.println("\nTo start using the program, please select one of the following options provided below for your grocery list: ");

        while(!quit){ //while loop for running the simulation program as long as quit == false

            printInstructions(); //will print the method onto the terminal with the given options
            System.out.println("\nPlease enter the choice number (number beside the given options) you wish to proceed with: ");
            choice = scanner.nextInt(); //will store the number from user input in the choice variable
            scanner.nextLine(); // for the enter key

            switch(choice){ //based on the user input for their choice number, one of these cases will initiate while the simulation is running
                case 1:
                    groceryList.printGroceryList();  //calling the printGroceryList() method in the GroceryList class
                    break;
                case 2:
                    addItem(); //calling the addItem() method
                    break;
                case 3:
                    modifyItem(); //calling the modifyItem() method
                    break;
                case 4:
                    removeItem(); //calling the removeItem() method
                    break;
                case 5:
                    searchForItem(); //calling the searchForItem() method
                    break;
                case 6:                //if the user selects option number 6, the simulation will end with 2 outputs mentioned below
                    quit = true;
                    System.out.println("THANK YOU FOR USING THE SIMULATION!");
                    System.out.println("Program has ended.");
                    break;
                default:
                    System.out.println("Invalid number, please enter a choice number from the options given"); //if the user selects another number out of the options range, they will see the resulting the output
                    break;
            }
        }
    }
    //method to print out the options into the terminal
    private static void printInstructions() {
        System.out.println("\n\t 1 - Print item(s)");
        System.out.println("\t 2 - Add item");
        System.out.println("\t 3 - Replace item");
        System.out.println("\t 4 - Remove item");
        System.out.println("\t 5 - Search item");
        System.out.println("\t 6 - Stop the simulation.");
    }

    //method for users to add an item to their grocery list
    private static void addItem(){
        System.out.println("Please enter the grocery item you wish to add (i.e. pasta, pizza, cake, etc): ");
        String userItem = scanner.nextLine().toLowerCase(Locale.ROOT);
        groceryList.addGroceryItem(userItem);
        System.out.println("Your item - " + userItem + " - has been added to your grocery list.");
        System.out.println("Your updated list can be found by selecting choice number 1 from the options menu");
    }
    //method for allowing users to replace their items from their grocery list
    private static void modifyItem(){
        System.out.println("Enter current item you wish to replace from your grocery list: ");
        String currentItem = scanner.nextLine().toLowerCase(Locale.ROOT);
        System.out.println("Enter your replacement item: ");
        String newItem = scanner.nextLine().toLowerCase(Locale.ROOT);
        groceryList.modifyGroceryItem(currentItem,newItem);
    }
    //method for users to remove item(s) from their list
    private static void removeItem(){
        System.out.println("Please enter the item name you wish to remove from your list: ");
        String removeItem = scanner.nextLine().toLowerCase(Locale.ROOT);
        groceryList.removeGroceryItem(removeItem);
    }
    //method for users to search for their item(s) from their list
    private static void searchForItem(){
        System.out.println("Please enter the item name you wish to search for from your list: ");
        String searchItem = scanner.nextLine().toLowerCase(Locale.ROOT);
        if(groceryList.onFile(searchItem)){
            System.out.println(searchItem + " was found in your grocery list");
            System.out.println("Please look at your list (by choosing choice number 1 from the options menu) to see the item number for this food product");
        }
        else {
            System.out.println("Sorry the item - " + searchItem + " - was not found in your grocery list.");
            System.out.println("Please check if the item has been added to your list");
        }
    }

}
