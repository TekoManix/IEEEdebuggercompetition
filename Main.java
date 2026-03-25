import java.io.File;
import java.util.Scanner;

/**
 * Debug competition for IEEE. There will be 10 Tasks of different variety.
 * Task: You are going to make algorithms and use the debugger to solve the issues
 * Some will utilize external data in txt files. If that is the case we will provide needed setup of libs like scanner and File
 * (DO NOT CHANGE THERE OR THE METHOD HEADERS)
 */
public class Main {

    /**
     * Please traverse the algorithm below and derive a valid password that can pass this algorithm.
     * Use the debugger to help you see how the gets checked if you get stuck.
     * @return
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
                } catch (NumberFormatException _) {

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
     * Make 'remove' function to IEEE_LinkedList class
     */
    public static void task2(){

    }

    public void task3(){

    }

    public void task4(){

    }

    public void task5(){

    }

    public void task6(){

    }

    public void task7(){

    }

    public void task8(){

    }

    public void task9(){

    }

    public void task10(){

    }
}
