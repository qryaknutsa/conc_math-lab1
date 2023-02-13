public class Main {
    //Variant 1
//    public static float[][] matrix = {{0, 1, 2, 3}, {4, 0, 5, 6}, {7, 8, 0, 9}};
    public static float[][] matrix = {{-7, 8, 9}, {1, -2, 3}, {4, 0, 6}};

    //        float[][] a = {{1, 1, 2, -1, 9}, {1, 1, -2, 1, 7}, {1, -1, 1, 2, -9}, {1, -1, -1, -2, 5}};
//        float[][] a = {{1, 1, 2, 3, 1}, {1, 2, 3, -1, -4}, {3, -1, -1, -2, -4}, {2, 3, -1, -1, -6}};
    public static void main(String[] args) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        GaussMethod gaussMethod = new GaussMethod();

        gaussMethod.to_triangle(matrix);

        System.out.println("_______________________________");
        for (int l = 0; l < rows; l++) {
            for (int m = 0; m < cols; m++) {
                System.out.println(matrix[l][m]);
            }
        }
    }


}

