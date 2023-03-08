import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import static java.lang.Float.*;

public class GaussMethod {

    public void to_triangle(float[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int k = 0; k < rows; k++) {
            System.out.println("k: " + k);
            System.out.println("matrix[k][k]: " + matrix[k][k]);
            boolean isReplacement = true;
            if (matrix[k][k] == 0) {
                System.out.println("it's 0\n___________________");
                isReplacement = switch_rows(matrix, k);
            }
            System.out.println("___________________");

            if (!isReplacement) {
                return;
            }

            for (int i = 0; i < rows; i++) {
                float to_mul;
                if (matrix[i][k] == 0) to_mul = 0;
                else to_mul = -matrix[i][k] / matrix[k][k];
                for (int j = 0; j < cols; j++) {
                    if (i <= k || j < k) {
                        System.out.println("Continue");
                        continue;
                    }
                    System.out.println("_____________\nfor [" + i + "," + j + "]\nto_mul= " + to_mul);
                    System.out.println("a[k][j] = " + matrix[k][j]);
                    System.out.println("a[i][j] = " + matrix[i][j]);
                    matrix[i][j] = matrix[i][j] + matrix[k][j] * to_mul;
                    System.out.println("we get " + matrix[i][j] + "\n_____________");
                }
                System.out.println("______________________________");

            }
        }
    }

    // пока для квадратной матрицы
    float get_determinant(float[][] matrix) {
        float det = 1;
        for (int i = 0; i < matrix.length; i++) {
            det *= matrix[i][i];
        }
        if (det == -0.0) det = 0;
        return det;
    }

    boolean switch_rows(float[][] matrix, int i) {
        int c = 0;
        int isInf = 0;
        while (matrix[i + c][i] == 0) {
            if (isInf > matrix.length + 2) return false;
            int temp = i + c == matrix.length - 1 ? c = -i : c++;
            isInf++;
        }
        if (c != -1) shift_rows(i,c,matrix);
        return true;
    }


    void shift_rows(int i, int c, float[][] matrix) {
        for (int j = 0; j < matrix[i].length; j++) {
            float temp = matrix[i + c][j];
            matrix[i + c][j] = matrix[i][j];
            matrix[i][j] = temp;
        }
    }

    int checkRang(float[][] matrix) {
        int n = matrix.length;
        int zero_sum = matrix.length;
        int zero_sum_b = matrix.length;
        for (int i = 0; i < matrix.length; i++) {
            int sum = 0;
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == 0) sum++;
            }
            if (sum == n) zero_sum--;
            if (sum == n && matrix[i][n] == 0) zero_sum_b--;
        }
        if (zero_sum != zero_sum_b) return 0;
        else if (zero_sum == zero_sum_b && zero_sum < n) return 2;
        else return 1;
    }

    float[] getSolution(float[][] matrix) {
        MathContext context = new MathContext(20, RoundingMode.HALF_UP);
        int rows = matrix.length - 1;
        int cols = matrix[0].length - 1;
        float[] solutions = new float[cols];
        for (int i = rows; i >= 0; --i) {
            for (int j = cols - 1; j >= 0; --j) {
                float to_sub = 0;
                for (int k = j; k < cols; ++k) {
                    to_sub += solutions[k] * matrix[i][k];
//                    System.out.println("solutions[k] = " + solutions[k]);
//                    System.out.println("matrix[i][k] = " + matrix[i][k]);
                }
                solutions[j] = new BigDecimal((matrix[i][cols] - to_sub) / matrix[i][j], context).floatValue();
//                System.out.println("temp = " + solutions[j]);
                i--;
            }
        }
        return solutions;
    }
}
