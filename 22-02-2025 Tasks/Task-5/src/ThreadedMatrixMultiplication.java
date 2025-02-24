class MatrixWorker extends Thread {
    private int[][] firstMatrix, secondMatrix, resultMatrix;
    private int rowIndex, colIndex, dimension;

    public MatrixWorker(int[][] firstMatrix, int[][] secondMatrix, int[][] resultMatrix, int rowIndex, int colIndex, int dimension) {
        this.firstMatrix = firstMatrix;
        this.secondMatrix = secondMatrix;
        this.resultMatrix = resultMatrix;
        this.rowIndex = rowIndex;
        this.colIndex = colIndex;
        this.dimension = dimension;
    }

    public void run() {
        for (int i = 0; i < dimension; i++) {
            resultMatrix[rowIndex][colIndex] += firstMatrix[rowIndex][i] * secondMatrix[i][colIndex];
        }
    }
}

public class ThreadedMatrixMultiplication {
    public static void main(String[] args) throws InterruptedException {
        int[][] matrixA = { {1, 2}, {3, 4} };
        int[][] matrixB = { {5, 6}, {7, 8} };
        int[][] resultMatrix = new int[matrixA.length][matrixB[0].length];

        Thread[][] threadPool = new Thread[matrixA.length][matrixB[0].length];

        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixB[0].length; j++) {
                threadPool[i][j] = new MatrixWorker(matrixA, matrixB, resultMatrix, i, j, matrixA[0].length);
                threadPool[i][j].start();
            }
        }

        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixB[0].length; j++) {
                threadPool[i][j].join();
            }
        }

        System.out.println("Resultant Matrix:");
        for (int[] row : resultMatrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
