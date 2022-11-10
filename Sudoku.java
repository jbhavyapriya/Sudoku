package com.bhavya.apnacollege;

import java.util.Scanner;
public class Sudoku {
    public static boolean isSafe(int sudoku[][],int row,int col,int digit)
    {
        for(int j=0;j<=8;j++)
        {
            if(sudoku[row][j]==digit)
            {
                return false;//returns false if the digit is already placed.
            }
        }
        for(int i=0;i<=8;i++)
        {
            if(sudoku[i][col]==digit)
            {
                return false;
            }
        }
        int sr=(row/3)*3;
        int sc=(col/3)*3;
        for(int i=sr;i<sr+3;i++)
        {
            for(int j=sc;j<sc+3;j++)
            {
                if(sudoku[i][j]==digit)
                {
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean solveSudoku(int sudoku[][], int row, int col) {
        if(row == 9) {
            return true;
        }

        int nextr=row, nextc=col+1;
        if(col+1 == 9) {
            nextr = row+1;
            nextc = 0;
        }

        //already placed so calling the function for next element
        if(sudoku[row][col] != 0) {
            return solveSudoku(sudoku, nextr, nextc);
        }

        for(int digit=1; digit<=9; digit++) {
            if(isSafe(sudoku, row, col, digit)) {
                sudoku[row][col] = digit;
                if(solveSudoku(sudoku, nextr, nextc)) {//if this function returns true it means solution exists.
                    return true;
                }
                //if it returns zero we assign the array index with zero again.
                sudoku[row][col] = 0;
            }
        }

        return false;
    }
    public static void printSudoku(int sudoku[][]) {
        for(int i=0; i<sudoku.length; i++) {
            for(int j=0; j<sudoku.length; j++) {
                System.out.print(sudoku[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        System.out.println("Enter the elements of sudoku and for the numbers to found enter zero at that index");
        Scanner sc=new Scanner(System.in);
        int sudoku[][]=new int[9][9];
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                    sudoku[i][j]=sc.nextInt();
            }
        }
        if(solveSudoku(sudoku,0,0))
        {
            System.out.println("solution exists");
            printSudoku(sudoku);
        }
        else{
            System.out.println("solution does not exist");
        }

    }
}
