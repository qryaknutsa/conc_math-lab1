public class Main {
    public static void main(String[] args) {
        MatrixIO matrixIO = new MatrixIO();
        float[][]matrix = matrixIO.read_matrix();
        new GaussMethod().solve(matrix);
    }
}

