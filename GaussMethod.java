
public class GaussMethod {

    int determinant_sign = 1;
    // matrix = {{2, -3, 2, 1}, {1, 1, 1, 3}, {1, 1, -2, 0}};

    public void to_triangle(float[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int k = 0; k < rows; k++) {
//            System.out.println("k: " + k);
//            System.out.println("matrix[k][k]: " + matrix[k][k]);
            if (matrix[k][k] == 0) {
//                System.out.println("it's 0\n___________________");
                switch_rows(matrix, k);
            }
//            System.out.println("___________________");


            for (int i = 0; i < rows; i++) {
                float to_mul = -matrix[i][k] / matrix[k][k];
                for (int j = 0; j < cols; j++) {
                    if (i <= k || j < k) {
//                        System.out.println("Continue");
                        continue;
                    }
//                    System.out.println("_____________\nfor [" + i + "," + j + "]\nto_mul= " + to_mul);
//                    System.out.println("a[k][j] = " + matrix[k][j]);
//                    System.out.println("a[i][j] = " + matrix[i][j]);
                    matrix[i][j] = matrix[i][j] + matrix[k][j] * to_mul;
//                    System.out.println("we get " + matrix[i][j] + "\n_____________");
                }
//                System.out.println("______________________________");


//                System.out.println("_______________________________");
                for (int l = 0; l < rows; l++) {
                    for (int m = 0; m < cols; m++) {
//                        System.out.println(matrix[l][m]);
                    }
                }
            }
        }


        float det = get_determinant(matrix);
//        System.out.println("Det = " + det);
    }

    // пока для квадратной матрицы
    float get_determinant(float[][] matrix) {
        float det = 1;
        for (int i = 0; i < matrix.length; i++) {
            det *= matrix[i][i];
        }
        return det;
    }

    void switch_rows(float[][] matrix, int i) {
        int c = 0;
//        System.out.println("new call\ni = " + i);
        while (matrix[i + c][i] == 0) {
            if (i + c == matrix.length - 1) {
                c = -i;
//                System.out.println("new cycle");
            } else {
//                System.out.println("to switch with: " + matrix[i + c][i]);
                c++;
            }
        }
        for (int j = 0; j < matrix[i].length; j++) {
            float temp = matrix[i + c][j];
            matrix[i + c][j] = matrix[i][j];
            matrix[i][j] = temp;
        }
    }

    float[] getSolution(float[][] matrix) {
        int rows = matrix.length - 1;
        int cols = matrix[0].length - 1;
        System.out.println("rows = " + rows);
        System.out.println("cols = " + cols);
        float[] solutions = new float[cols];

        for (int i = rows; i >= 0; --i) {
            for (int j = cols - 1; j >= 0; --j) {
                System.out.println("j = " + j);
                System.out.println("i = " + i);
//                float temp = 0;
//                if (j == cols - 1) {
//                    temp = matrix[i][j + 1] / matrix[i][j];
//                    solutions[j] = temp;
//                    System.out.println("matrix[i][j + 1] = " + matrix[i][j + 1]);
//                    System.out.println("matrix[i][j] = " + matrix[i][j]);
//                    System.out.println("temp = " + temp);
//                    i--;
//                } else if (j == cols - 2) {
//                    temp = (matrix[i][j + 2] - solutions[j + 1] * matrix[i][j + 1]) / matrix[i][j];
//                    solutions[j] = temp;
//                    System.out.println("matrix[i][j + 2] = " + matrix[i][j + 2]);
//                    System.out.println("matrix[i][j + 1] = " + matrix[i][j + 1]);
//                    System.out.println("matrix[i][j] = " + matrix[i][j]);
//                    System.out.println("temp = " + temp);
//                    i--;
//                } else if (j == cols - 3) {
//                    temp = (matrix[i][j + 3] - solutions[j + 2] * matrix[i][j + 2] - solutions[j + 1] * matrix[i][j + 1]) / matrix[i][j];
//                    solutions[j] = temp;
//                    System.out.println("matrix[i][j + 3] = " + matrix[i][j + 3]);
//                    System.out.println("matrix[i][j + 2] = " + matrix[i][j + 2]);
//                    System.out.println("matrix[i][j + 1] = " + matrix[i][j + 1]);
//                    System.out.println("matrix[i][j] = " + matrix[i][j]);
//                    System.out.println("temp = " + temp);
//                    i--;
//                }

                float to_sub = 0;
                for (int k = j; k < cols; ++k) {
                    to_sub += solutions[k] * matrix[i][k];
                }
                solutions[j] = (matrix[i][cols] - to_sub) / matrix[i][j];
                System.out.println("temp = " + solutions[j]);
                i--;
            }
        }
        return solutions;
    }
}
