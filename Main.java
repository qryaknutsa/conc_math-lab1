public class Main {
    //Variant 1
    public static float[][] matrix = {{2, -3, 2, 1}, {1, 1, 1, 3}, {1, 1, -2, 0}};

    //        float[][] a = {{1, 1, 2, -1, 9}, {1, 1, -2, 1, 7}, {1, -1, 1, 2, -9}, {1, -1, -1, -2, 5}};
//        float[][] a = {{1, 1, 2, 3, 1}, {1, 2, 3, -1, -4}, {3, -1, -1, -2, -4}, {2, 3, -1, -1, -6}};
    public static void main(String[] args) {
        GaussMethod gaussMethod = new GaussMethod();

        gaussMethod.to_triangle(matrix);
    }


}

