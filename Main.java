public class Main {
    //Variant 1
    //TODO: 3 x неправильный
//    public static float[][] matrix = {
//            {0, 1, 2, 3},
//            {4, 0, 5, 6},
//            {7, 8, 0, 9}};


//    public static float[][] matrix = {
//            {2, -3, 2, 1},
//            {1, 1, 1, 3},
//            {1, 1, -2, 0}};

//        public static float[][] matrix = {
//                {1, 1, 2, -1, 9},
//                {1, 1, -2, 1, 7},
//                {1, -1, 1, 2, -9},
//                {5, -2, -1, -1, 1}};


    //TODO: not triangle
    public static float[][] matrix = {
            {0, 0, 0, 0, 0},
            {1, 1, -2, 1, 7},
            {1, -1, 1, 2, -9},
            {5, -2, -1, -1, 1}};

//    public static float[][] matrix = {
//            {(float) 1.0001, (float) 20.202, (float) 33.333, (float) 4.22},
//            {(float) 45.002, (float) 3.35, (float) 88.6, (float) 5.089},
//            {42, (float) 0.08, (float) 7.256, (float) 0.001}};


//    public static float[][] matrix = {
//            {1,  2,  1,  5},
//            {2,  4,  3,  7},
//            {0,  0,  0,  0}};


    //it is zero
//    public static float[][] matrix = {
//            {0, 0, 0, 0},
//            {0, 0, 0, 7},
//            {0, 0, 0, 3}};

    //it is infinitivy
//    public static float[][] matrix = {
//            {2, 3, 5, 7, 9, 12},
//            {3, 1, 4, 7, 10, 11},
//            {1, 3, 4, 5, 6, 9},
//            {2, 1, 3, 5, 7, 8}};


//    public static float[][] matrix = {
//            {2, 3, 5, 7, 9, 12},
//            {3, 1, 4, 7, 10, 11},
//            {0, 0, 0, 0, 0, 9},
//            {0, 0, 0, 0, 0, 8}};

    //        float[][] a = {{1, 1, 2, 3, 1}, {1, 2, 3, -1, -4}, {3, -1, -1, -2, -4}, {2, 3, -1, -1, -6}};
    public static void main(String[] args) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        GaussMethod gaussMethod = new GaussMethod();

        gaussMethod.to_triangle(matrix);

        System.out.println("_______________________________");
        for (int l = 0; l < rows; l++) {
            for (int m = 0; m < cols; m++) {
                if (m == 0) System.out.println();
                System.out.print(matrix[l][m] + "         ");
            }
        }
        System.out.println("\n_______________________________");

        float det = gaussMethod.get_determinant(matrix);

        System.out.println("Determinant: " + det);


        int rang = gaussMethod.checkRang(matrix);
//        System.out.println("rang = " + rang);
        if (rang == 1) {
            float[] result = gaussMethod.getSolution(matrix);
            System.out.println("___________________________\n");
            for (float i : result) {
                System.out.println(i);
            }
        }else if(rang == 2){
            System.out.println("Solutions are endless.");
        } else if(rang == 0){
            System.out.println("There are no solutions.");
        }
    }


}

