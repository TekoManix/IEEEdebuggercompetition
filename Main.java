import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Debug competition for IEEE. There will be 10 Tasks of different variety.
 * Task: You are going to make algorithms and use the debugger to solve the issues
 * Some will utilize external data in txt files. If that is the case we will provide needed setup of libs like scanner and File
 * (DO NOT CHANGE THERE OR THE METHOD HEADERS)
 */
public class Main {

    public static void main(String[] args) {
        task1();

    }

    public static void task1(){
        try {
            File f = new File("data.txt");
            Scanner file = new Scanner(f);








        }catch (Exception e){
            System.out.println("Can't open file, 'data.txt'");
        }
    }
    
    public static void task2(){

    }

    public static void task3(){

    }

    public static boolean task4(String filePath, int target) throws Exception {
        return false;
    }

    public static List<Integer> task5(String filePath) throws Exception {
        return null;
    }

    public static String task6(String filePath, String key) throws Exception {
        return null;
    }

    public static Map<String, List<String>> task7(String filePath) throws Exception {
        return null;
    }

    public static void task8(){

    }
    
    public static void task9(){
        
    }
    
    public static void task10(){
        
    }
}
