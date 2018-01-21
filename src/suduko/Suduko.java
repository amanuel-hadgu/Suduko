
package suduko;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Suduko {

    public static int i, j;
    public static int suduko[][] = new int[3][3];
    public static Random randomNum = new Random();
    public static int sudukoCount;
    public static String strSuduko;
    public static Set<String> sudukoSet;
    public static Set<Integer> sudukoElementsSet;
    public static int count;

    public static void main(String[] args) {
        // write your code here
        sudukoSet = new HashSet<>();
        sudukoElementsSet = new HashSet<>();

        for (int n = 0; n < 1000000; n++) {
            strSuduko = "";
            sudukoElementsSet.clear();
            generatSuduko();

            if(sudukoSet.add(strSuduko)) {
                count++;
                if ((suduko[0][0] + suduko[0][1] + suduko[0][2]) == 15 && (suduko[1][0] + suduko[1][1] + suduko[1][2]) == 15
                        && (suduko[2][0] + suduko[2][1] + suduko[2][2]) == 15 && (suduko[0][0] + suduko[1][0] + suduko[2][0]) == 15
                        && (suduko[0][1] + suduko[1][1] + suduko[2][1]) == 15 && (suduko[0][2] + suduko[1][2] + suduko[2][2]) == 15
                        && (suduko[0][0] + suduko[1][1] + suduko[2][2]) == 15 && (suduko[2][0] + suduko[1][1] + suduko[0][2]) == 15) {
                    sudukoCount++;
                    System.out.println("This is Suduko Number: " + sudukoCount);
                    printSuduko();
                }
            }
        }
        System.out.println("All Sudokos Printed");
        System.out.println(count);
    }
    
    public static void generatSuduko(){
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                setRandomNum();
                strSuduko = strSuduko + suduko[i][j];
            }
        }
    }
    /**
     a method which generates random numbers between 1 and 9 with out repetition
     */
    public static void setRandomNum() {
        suduko[i][j] = 1 + randomNum.nextInt(9);
        if(!sudukoElementsSet.add(suduko[i][j])){
            setRandomNum();
        }
    }

    public static void printSuduko() {
        for (int l = 0; l < 3; l++) {
            for (int m = 0; m < 3; m++) {
                System.out.print(suduko[l][m] + " ");
            }
            System.out.println();
        }
    }
}
