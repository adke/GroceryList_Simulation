import java.util.ArrayList;

public class GroceryList {

    private ArrayList<String> groceryList = new ArrayList<String>(); //creating an ArrayList object with elements in the array list of type string

    public void addGroceryItem(String addItem){ //method for adding item to the grocery list from given user input (parameter)
        groceryList.add(addItem);
    }

    //method to print the items from the grocery list
    public void printGroceryList(){
        System.out.println("You have " + groceryList.size() + " item(s) in your grocery list: ");
        if(groceryList.size() == 0){
            System.out.println("Please select choice number 2 from the options menu to add item(s) to your list");
        }
        for(int i = 0; i < groceryList.size(); i++){
            System.out.println((i+1) + "." + groceryList.get(i)); //i is still the index of the list - following the same procedure as an array
        }

    }
    //method to check and see if the current item exists and if it does, the method will replace the current item with a new item by calling the modifyGroceryItem(int index, String newItem) method
    public void modifyGroceryItem(String currentItem,String newItem){
        int index = findIndexItem(currentItem);
        if(index >= 0){
            modifyGroceryItem(index,newItem);
            System.out.println("Your current item - " + currentItem + " - has been replaced with " + newItem + ".");
            System.out.println("Please check your updated list by selecting choice number 1 from the options menu");
        }
        else{
            System.out.println("Item can not be replaced,the current item does not exist in your grocery list . Please try again.");
        }
    }

    //replace current item with new item, called by the above method
    private void modifyGroceryItem(int index, String newItem){
        groceryList.set(index, newItem);
    }

    //method will check to see if the item first exists in the list, if it does, the method will call the removeGroceryItem(int index) method to remove the item
    public void removeGroceryItem(String item){
        int index = findIndexItem(item);
        if(index >= 0){
            removeGroceryItem(index);
            System.out.println("Item - " + item + " - has been removed from your grocery list.");
            System.out.println("Please check your updated list by selecting choice number 1 from the options menu");
        }
        else{
            System.out.println("Sorry, the item you wish to remove is already not in your grocery list.");
        }
    }

    //method for removing the item from the list called by above method
    private void removeGroceryItem(int index){
        String theItem = groceryList.get(index);
        groceryList.remove(theItem);
    }

    //method for getting the index for an item from the list, this method is called by the other methods to check if the item exists in the list
    private int findIndexItem(String searchItem){
        // boolean exists = groceryList.contains(searchItem); - could also be used to search item
         return groceryList.indexOf(searchItem);
    }

    //method checks if the item is in the list or not by returning true or false
    public boolean onFile(String searchItem){
        int index = findIndexItem(searchItem);
        if(index >= 0){
            return true;
        }
        else{
            return false;
        }
    }

}
