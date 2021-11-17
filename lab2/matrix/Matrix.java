package matrix;

import exceptions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Matrix {
    private int height = 0;
    private int width = 0;
    private double[][] numbers = new double[1][1];

    public void setDimension(final int height, final int width) throws TooLargeMatrixException, TooSmallMatrixException {
        if (height > 1000000) {
            throw new TooLargeMatrixException("Height is too much.");
        } else if (height <= 0) {
            throw new TooSmallMatrixException("Height is too small.");
        }
        if (width > 1000000) {
            throw new TooLargeMatrixException("Width is too much.");
        } else if (width <= 0) {
            throw new TooSmallMatrixException("Width is too small.");
        }
        this.height = height;
        this.width = width;
    }

    public void setDimensionFromFile(final String fileName) throws NonExistentFileException, TooLargeMatrixException, TooSmallMatrixException, NullPointerException {
        if (fileName == null) {
            throw new NullPointerException();
        }
        List<Integer> dimensions = null;
        try {
            dimensions = getDimensionFromFile(fileName);
        } catch (IncorrectDimensionsException e) {
            e.printStackTrace();
        }
        if (dimensions != null) {
            setDimension(dimensions.get(0), dimensions.get(1));
        }
    }

    private List<Integer> getDimensionFromFile(final String fileName) throws NonExistentFileException, IncorrectDimensionsException {
        if (fileName == null) {
            throw new NullPointerException();
        }
        File file = new File(fileName);
        List<Integer> list = new ArrayList<>();

        if (!file.exists()) {
            throw new NonExistentFileException();
        }
        try (Scanner fileReader = new Scanner(file)) {
            if (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                fileReader.close();
                list = getDataFromString(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return list;
    }

    private List<Integer> getDataFromString(final String line) throws IncorrectDimensionsException {
        if (line == null) {
            throw new NullPointerException();
        }
        int width = -1;
        int height = -1;
        Scanner stringReader = new Scanner(line);
        if (stringReader.hasNextInt()) {
            height = stringReader.nextInt();
            if (stringReader.hasNext()) {
                if (stringReader.next().charAt(0) == '*') {
                    if (stringReader.hasNextInt()) {
                        width = stringReader.nextInt();
                    } else {
                        stringReader.close();
                        throw new IncorrectDimensionsException("There must be a number after the asterisk!");
                    }
                } else {
                    stringReader.close();
                    throw new IncorrectDimensionsException("There must be a asterisk after the number!");
                }
            } else {
                stringReader.close();
                throw new IncorrectDimensionsException("Insufficient data in line!");
            }
        } else {
            stringReader.close();
            throw new IncorrectDimensionsException("The string must start with a number!");
        }
        stringReader.close();

        List<Integer> list = new ArrayList<>();
        list.add(height);
        list.add(width);
        return list;
    }

    public void fillMatrixWithRandomNumbers() {
        this.numbers = new double[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int averageSizeMatrix = (width + height) / 2;
                this.numbers[i][j] = Math.random() * 2 * averageSizeMatrix - averageSizeMatrix;
            }
        }
    }

    public void rotateMatrix90degrees() throws NonSquareMatrixRotationException {
        if (height != width) {
            throw new NonSquareMatrixRotationException();
        }
        double[][] newMatrix = new double[width][width];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < width; j++) {
                newMatrix[i][j] = numbers[j][width - i - 1];
            }
        }

        for (int i = 0; i < width; i++) {
            if (height >= 0)
                System.arraycopy(newMatrix[i], 0, numbers[i], 0, height);
        }
    }

    public void divideElementsBySumOfItsNeighbors() throws DivisionByZeroException {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                double sum = 0.0;
                if (i != 0) {
                    sum += numbers[i - 1][j];
                }
                if (i != height - 1) {
                    sum += numbers[i + 1][j];
                }
                if (j != 0) {
                    sum += numbers[i][j - 1];
                }
                if (j != width - 1) {
                    sum += numbers[i][j + 1];
                }
                if (sum == 0.0) {
                    throw new DivisionByZeroException();
                } else {
                    numbers[i][j] /= sum;
                }
            }
        }
    }

    public void printMatrixInFile(final String fileName) throws NonExistentFileException {
        File file = new File(fileName);
        if (!file.exists()) {
            throw new NonExistentFileException();
        }
        try (FileWriter fileWriter = new FileWriter(fileName, true)) {
            if (height != 0 && width != 0)
                fileWriter.write("\n");
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    String temp = String.format("% 14.2f|", numbers[i][j]);
                    fileWriter.write(temp + " ");
                }
                fileWriter.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

}
