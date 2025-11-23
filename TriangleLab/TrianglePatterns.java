package TriangleLab;

import java.util.Scanner;
public class TrianglePatterns {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        // Taking inputs and stuff
        int type = -1;
        System.out.println("Enter which triangle type you want: ");
        while(type < 1 || type > 5){
            type = sc.nextInt();
        }
        System.out.println("Your triangle: ");
        switch(type){
            case 1: 
                printLeftAlignedTriangle(5);
                break;
            case 2:
                printRightAlignedTriangle(5);
                break;
            case 3:
                printInvertedNumberTriangle(5);
                break;
            case 4:
                printFloydsTriangle(5);
                break;
            case 5:
                printPascalsTriangle(5);
                break;
        }
        System.out.println();
        sc.close();
        // print all types of triangles as test
        System.out.println("Left-Aligned Triangle of size 5: ");
        printLeftAlignedTriangle(5);
        System.out.println("Right-Aligned Triangle of size 5: ");
        printRightAlignedTriangle(5);
        System.out.println("Inverted Number Triangle of size 5: ");
        printInvertedNumberTriangle(5);
        System.out.println("Floyd's Triangle of size 5: ");
        printFloydsTriangle(5);
        System.out.println("Pascal's Triangle of size 5: ");
        printPascalsTriangle(5);
    }

    // Triangle Methods
    public static void printLeftAlignedTriangle(int size){
        for(int row = 1; row <= size; row++){
            for(int items = 1; items <= row; items++){
                System.out.print(items + " ");
            }
            System.out.println();
        }
    }
    public static void printRightAlignedTriangle(int size){
        for(int row = 1; row <= size; row++){
            // handle spaces
            for (int spaces = size; spaces >= row; spaces--){
                System.out.print("  ");
            }

            // print triangle
            for(int items = 1; items <= row; items++){
                System.out.print(items + " ");
            }
            System.out.println();
        }
    }
    public static void printInvertedNumberTriangle(int size){
        for(int row = 0; row < size; row++){
            for(int items = size - row; items > 0; items--){
                System.out.print(items + " ");
            }
            System.out.println();
        }
    }
    public static void printFloydsTriangle(int size){
        int nSum = 1;
        for(int row = 1; row <= size; row++){
            for(int items = 1; items <= row; items++){
                System.out.print(nSum + " ");
                nSum++;
            }
        System.out.println();
        }
    }


    public static void printPascalsTriangle(int size){
        // n = row; k = position
        for(int n = 0; n < size; n++){
            // spaces
            for (int spaces = size; spaces >= n; spaces--){
                System.out.print(" ");
            }

            for(int k = 0; k <= n; k++){
                System.out.print(factorial(n) / (factorial(k) * factorial(n-k)) + " ");
            }
            System.out.println();
        }
    }

    // helper method for pascal triangle
    public static int factorial(int n){
        int factorialed = 1;
        if(n <= 1){
            return 1;
        }
        for(int x = 2; x <=n; x++){
            factorialed*=x;
        }
        return factorialed;
    }
}
