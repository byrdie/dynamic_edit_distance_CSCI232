/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci232_inlab5_dynamic_edit_distance;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Roy Smart
 */
public class EditDistance {
    Node[][] table;
    int length1;
    int length2;

    EditDistance(String inputFile) throws FileNotFoundException {
        in = new Scanner(new File(inputFile));
    }
    
    public void calculateDistance(){
        while(in.hasNext()){
            char[] string1 = (" " + in.nextLine()).toCharArray();   // add emptystring to beginning
            char[] string2 = (" " + in.nextLine()).toCharArray();
            
            length1 = string1.length;
            length2 = string2.length;
            table = new Node[length1][length2];
            
            /*initialize table*/
            for(int i = 0; i < length1; i++){
                table[i][0] = new Node(i, 0);
            }
            for(int j = 0; j < length2; j++){
                table[0][j] = new Node(0, j);
            }
            
            Node addNode;
            Node delNode;
            Node subNode;
            /*find best alignment*/
            for(int i = 0; i < length1; i++){
                for (int j = 0; j < length2; j++){
                    addNode = new Node(table[i-1][j].value + 1, 1);
                    delNode = new Node(table[i][j-1].value + 1, 2);
                    subNode = new Node(table[i-1][j-1].value + 1, 3);
                    
                    table[i][j] = addNode;
                    if(addNode.compareTo(delNode) < 0){
                        table[i][j] = delNode;
                    }
                    if(delNode.compareTo(subNode) < 0){
                        table[i][j] = subNode;
                    }
                }
            }
            printTable();
        }
    }
    
    
    
    public void initialize() {
        int numberCoins;
        int maxChange;

        numberCoins = in.nextInt();
        System.out.println("Number of coins = " + numberCoins);
        coins = new int[numberCoins];

        for (int i = 0; i < numberCoins; i++) {
            coins[i] = in.nextInt();
            System.out.println("Coin " + i + "'s value = " + coins[i]);
        }

        maxChange = in.nextInt();
        System.out.println("Max change = " + maxChange);

        solutions = new int[maxChange + 1][numberCoins];

        for (int i = 0; i <= maxChange; i++) {
            solutions[i][0] = i;
        }

        for (int i = 0; i <= maxChange; i++) {
            for (int j = 1; j < numberCoins; j++) {
                solutions[i][j] = 0;
            }
        }

        printTable();
    }

    private void printTable() {
        System.out.println("Table");
        for (int i = 0; i < length1; i++) {
            for (int j = 0; j < length2; j++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void fillTable() {
        for (int column = 1; column < coins.length; column++) {
            for (int row = 0; row < solutions.length; row++) {
                // Dynamic Programming
                if (coins[column] > row) {
                    solutions[row][column] = solutions[row][column - 1];
                } else {
                    solutions[row][column] = Math.min(
                            solutions[row][column - 1],
                            solutions[row - coins[column]][column] + 1);
                }
            }
        }
        printTable();
    }

    public void solveProblems() {
        int changeAmount;

        while (in.hasNext()) {
            changeAmount = in.nextInt();
            System.out.println("The least number of coins for "
                    + changeAmount + " is " + solutions[changeAmount][coins.length - 1]);
        }
    }

    private int coins[];
    private int solutions[][];
    private Scanner in;
}
