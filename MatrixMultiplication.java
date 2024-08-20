package Multithreading;

class MatrixMultiplier {
    private final int[][] matrixA;
    private final int[][] matrixB;
    private final int[][] resultMatrix;
    private final int numRowsA;
    private final int numColsA;
    private final int numColsB;
    public MatrixMultiplier(int[][] A, int[][] B) {
        this.matrixA = A;
        this.matrixB = B;
        this.numRowsA = A.length;
        this.numColsA = A[0].length;
        this.numColsB = B[0].length;
        this.resultMatrix = new int[numRowsA][numColsB];
    }

    public void multiplyMatrices() throws InterruptedException {
        Thread[] threads = new Thread[numRowsA];

        for (int i = 0; i < numRowsA; i++) {
            final int row = i;
            threads[i] = new Thread(() -> computeRow(row));
            threads[i].start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
    }

    private void computeRow(int row) {
        for (int col = 0; col < numColsB; col++) {
            int sum = 0;
            for (int k = 0; k < numColsA; k++) {
                sum += matrixA[row][k] * matrixB[k][col];
            }
            resultMatrix[row][col] = sum;
        }
    }

    public int[][] getResultMatrix() {
        return resultMatrix;
    }
}

public class MatrixMultiplication {
    public static void main(String[] args) {
        int[][] matrixA = {{1, 2}, {3, 4}};
        int[][] matrixB = {{5, 6}, {7, 8}};

        MatrixMultiplier multiplier = new MatrixMultiplier(matrixA, matrixB);
        try {
            multiplier.multiplyMatrices();
            int[][] result = multiplier.getResultMatrix();
            for (int[] row : result) {
                for (int val : row) {
                    System.out.print(val + " ");
                }
                System.out.println();
            }
        } catch (InterruptedException e) {
            System.err.println("Matrix multiplication interrupted: " + e.getMessage());
        }
    }
}
