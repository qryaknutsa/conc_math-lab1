
public class GaussMethod {

    int determinant_sign = 1;
    // matrix = {{2, -3, 2, 1}, {1, 1, 1, 3}, {1, 1, -2, 0}};

    public void to_triangle(float[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int k = 0; k < rows; k++) {
            System.out.println("k: " + k);
            System.out.println("matrix[k][k]: " + matrix[k][k]);
            if (matrix[k][k] == 0) {
                System.out.println("it's 0\n___________________");
                switch_rows(matrix, k);
            }
            System.out.println("___________________");


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


                System.out.println("_______________________________");
                for (int l = 0; l < rows; l++) {
                    for (int m = 0; m < cols; m++) {
                        System.out.println(matrix[l][m]);
                    }
                }
            }
        }


        float det = get_determinant(matrix);
        System.out.println("Det = " + det);
    }

    // пока для квадратной матрицы
    float get_determinant(float[][] matrix){
        float det = 1;
        for (int i = 0; i < matrix.length; i++) {
            det *= matrix[i][i];
        }
        return det;
    }

    void switch_rows(float[][] matrix, int i) {
        int c = 0;
        System.out.println("new call\ni = " + i);
        while (matrix[i + c][i] == 0) {
            if (i + c == matrix.length - 1) {
                c = -i;
                System.out.println("new cycle");
            } else {
                System.out.println("to switch with: " + matrix[i + c][i]);
                c++;
            }
        }
        for (int j = 0; j < matrix[i].length; j++) {
            float temp = matrix[i + c][j];
            matrix[i + c][j] = matrix[i][j];
            matrix[i][j] = temp;
        }

    }
}
