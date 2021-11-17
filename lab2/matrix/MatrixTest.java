package matrix;

import exceptions.*;
import matrix.Matrix;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {

    Matrix matrix = new Matrix();
    final static int SIZE = 5;

    @org.junit.jupiter.api.Test
    void setDimension() {
        TooSmallMatrixException thrown = assertThrows(TooSmallMatrixException.class, () ->
                matrix.setDimension(-5, 7));
        assertNotNull(thrown.getMessage());

        TooSmallMatrixException thrown2 = assertThrows(TooSmallMatrixException.class, () ->
                matrix.setDimension(5, 0));
        assertNotNull(thrown2.getMessage());

        TooSmallMatrixException thrown3 = assertThrows(TooSmallMatrixException.class, () ->
                matrix.setDimension(0, -10));
        assertNotNull(thrown3.getMessage());

        TooLargeMatrixException thrown4 = assertThrows(TooLargeMatrixException.class, () ->
                matrix.setDimension(1000001, 6));
        assertNotNull(thrown4.getMessage());

        TooLargeMatrixException thrown5 = assertThrows(TooLargeMatrixException.class, () ->
                matrix.setDimension(7, 2000003));
        assertNotNull(thrown5.getMessage());

        TooLargeMatrixException thrown6 = assertThrows(TooLargeMatrixException.class, () ->
                matrix.setDimension(2000003, 2000003));
        assertNotNull(thrown6.getMessage());

        int height = 3;
        int width = 4;
        try {
            matrix.setDimension(3, 4);
        } catch (TooLargeMatrixException | TooSmallMatrixException e) {
            e.printStackTrace();
        }
        assertEquals(height, matrix.getHeight());
        assertEquals(width, matrix.getWidth());
    }

    @org.junit.jupiter.api.Test
    void setDimensionFromFile() {
        NonExistentFileException thrown = assertThrows(NonExistentFileException.class, () ->
                matrix.setDimensionFromFile("nrivnmiemfnemio"));
        assertNotNull(thrown.getMessage());

        File file = new File("input.txt");
        try {
            file.createNewFile();
            try (FileWriter fileWriter = new FileWriter(file)) {
                fileWriter.write("3 * 4");
            }
            matrix.setDimensionFromFile("input.txt");
        } catch (IOException | NonExistentFileException | TooSmallMatrixException | TooLargeMatrixException e) {
            e.printStackTrace();
        }

        assertEquals(3, matrix.getHeight());
        assertEquals(4, matrix.getWidth());
    }
}
