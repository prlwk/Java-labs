package main;

import exceptions.*;
import matrix.Matrix;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Write filename for reading:");
        Scanner input = new Scanner(System.in);
        String filename = input.nextLine();
        Matrix matrix = new Matrix();
        try {
            matrix.setDimensionFromFile(filename);
        } catch (NonExistentFileException | TooLargeMatrixException | TooSmallMatrixException | NullPointerException e) {
            e.printStackTrace();
        }
        matrix.fillMatrixWithRandomNumbers();
        System.out.println();
        try {
            for (int i = 0; i < 3; i++) {
                matrix.rotateMatrix90degrees();
                matrix.divideElementsBySumOfItsNeighbors();
                matrix.printMatrixInFile(filename);
            }
        } catch (NonExistentFileException | DivisionByZeroException | NonSquareMatrixRotationException e) {
            e.printStackTrace();
        }
    }
}
