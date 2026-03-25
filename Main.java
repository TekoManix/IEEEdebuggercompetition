import java.io.File;
import java.util.Scanner;

/**
 * Debug competition for IEEE. There will be 10 Tasks of different variety.
 * Task: You are going to make algorithms and use the debugger to solve the issues
 * Some will utilize external data in txt files. If that is the case we will provide needed setup of libs like scanner and File
 * (DO NOT CHANGE THE METHOD HEADERS AS IT WILL BREAK OUR TESTS)
 */
public class Main {

    /**
     * DO NOT CHANGE THIS FUNCTION ONLY TRAVERSE IT
     * Please traverse the algorithm below and derive a valid password that can pass this algorithm.
     * Use the debugger to help you see how the gets checked if you get stuck.
     * @return true_false
     */
    public static boolean task1_Valid_Password(){
        boolean pass = false;
        String password = "";
        try {
            File f = new File("data/task1/task1_Valid_Password.txt");
            Scanner file = new Scanner(f);
            while(file.hasNext()){
                password += file.nextLine();
            }
        }catch (Exception e){
            System.out.println("Can't open file, 'task1_Valid_Password.txt'");
        }
            if(password.length() < 9){
                return false;
            }

            if(!(password.charAt(6) == 'c' && password.charAt(8) == 'a')) {
                return false;
            }

            if(!password.contains("IEEE")){
                return false;
            }
            boolean nCheck = false;
            for(int i = 0; i < password.length(); i++) {
                if (password.charAt(i) == password.charAt(i + 1) && password.charAt(i) != 'E') {
                    return false;
                }
                var str = password.substring(i, i + 1);
                try {
                    Integer.parseInt(str);
                    nCheck = true;
                    break;
                } catch (NumberFormatException ignore) {

                }
            }
            if(!nCheck){
                return false;
            }

            if(!(password.contains("!") || password.contains("?") || password.contains("~"))){
                return false;
            }

            pass = true;


        return pass;
    }

    /**
     * Task 2: Remove function implementation for IEEE_LinkedList class
     * Follows LinkedList implementation, ensure that ONLY the node's index that
     * is entered is removed and no data is left behind
     */
    //task2
        //TODO: Please write remove algorithm in IEEE_Linked_List Class


    /**
     * Task 3: Swap function implementation for IEEE_LinkedList class
     * Follows LinkedList implementation, ensure that ONLY the two node's indexes that
     * are entered are swapped and no data is left behind.
     */
    //TASK3
        //TODO: Please write remove algorithm in IEEE_Linked_List Class


    /**
     * Task 4: Search for a target value in a BST.
     * Reads the tree from file, then traverses to find the target.
     * Returns true if found, false otherwise.
     */
    public void task4(){
        //TODO
    }

    /**
     * Task 5: In-order traversal of a BST.
     * Reads the tree from file, returns values in sorted order.
     */
    public void task5(){
        //TODO
    }

    /**
     * Task 6: Look up a value by key in a hash map file.
     * Reads the map from file, returns the value for the given key.
     * Returns null if the key is not found.
     */
    public void task6(){
        //TODO
    }

    /**
     * Task 7: Find all keys that share a duplicate value in a hash map file.
     * Reads the map from file, returns a map of value -> list of keys
     * for any value that appears more than once.
     */
    public void task7(){
        //TODO
    }

    /**
     * Task 8: Find the Max value from a given integer array.
     * It should return the max value found from the array.
     */
    public static int task8(int[] nums) {
        //TODO
        return -1;
    }

    /**
     * Task 9: Find if the given string is a palindrome.
     * Checks if the string 's' is the same forwards as backwards
     * (EX: RACECAR is the same forwards and backwards)
     * Will return true or false depending on if the string is a Palindrome or not
     */
    public static boolean task9(String str) {
        //TODO
        return false;
    }

    /**
     * Task 10: Reverse the order of a given standard array without losing data.
     */
    public static void task10(int[] nums) {
        //TODO
        return;
    }
}
