import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class GaussMethod {

    void to_triangle(float[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int k = 0; k < rows; k++) {




            boolean isReplacement = true;
            for (int i = k; i < rows; i++) {
                int counter = 0;
                for (int j = 0; j < rows; j++) {
                    if (matrix[i][j] == 0) counter++;
                }
                if (counter < rows) {
                    if (matrix[k][k] == 0) isReplacement = switch_rows(matrix, k);
                    if (!isReplacement) return;
                    break;
                }
            }


            for (int i = 0; i < rows; i++) {
                float to_mul;
                if (matrix[i][k] == 0) to_mul = 0;
                else to_mul = -matrix[i][k] / matrix[k][k];
                for (int j = 0; j < cols; j++) {
                    if (i <= k || j < k) continue;
                    matrix[i][j] = matrix[i][j] + matrix[k][j] * to_mul;
                }
            }
        }
    }

    float get_determinant(float[][] matrix) {
        float det = 1;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][i] == 0) {
                det = 0;
                break;
            }
            det *= matrix[i][i];
        }
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
        if (c != -1) shift_rows(i, c, matrix);
        return true;
    }


    void shift_rows(int i, int c, float[][] matrix) {
        for (int j = 0; j < matrix[i].length; j++) {
            float temp = matrix[i + c][j];
            matrix[i + c][j] = matrix[i][j];
            matrix[i][j] = temp;
        }
    }

    int check_rang(float[][] matrix) {
        int n = matrix.length;
        int zero_sum = matrix.length;
        int zero_sum_b = matrix.length;
        for (float[] floats : matrix) {
            int sum = 0;
            for (int j = 0; j < matrix.length; j++) {
                if (floats[j] == 0) sum++;
            }
            if (sum == n) zero_sum--;
            if (sum == n && floats[n] == 0) zero_sum_b--;
        }
        if (zero_sum != zero_sum_b) return 0;
        else if (zero_sum < n) return 2;
        else return 1;
    }

    float[] get_solution(float[][] matrix) {
        MathContext context = new MathContext(20, RoundingMode.HALF_UP);
        int rows = matrix.length - 1;
        int cols = matrix[0].length - 1;
        float[] solutions = new float[cols];
        for (int i = rows; i >= 0; --i) {
            for (int j = cols - 1; j >= 0; --j) {
                float to_sub = 0;
                for (int k = j; k < cols; ++k) {
                    to_sub += solutions[k] * matrix[i][k];
                }
                solutions[j] = new BigDecimal((matrix[i][cols] - to_sub) / matrix[i][j], context).floatValue();
                i--;
            }
        }
        return solutions;
    }


    float[] get_discrepancy(float[][] matrix, float[] x) {
        MathContext context = new MathContext(20, RoundingMode.HALF_UP);
        float[] discrepancy = new float[x.length];
        for (int i = 0; i < matrix.length; i++) {
            float ax = 0;
            for (int j = 0; j < matrix.length; j++) {
                ax += matrix[i][j] * x[j];
            }
            discrepancy[i] = new BigDecimal(ax - matrix[i][matrix.length], context).floatValue();
        }
        return discrepancy;
    }


    void solve(float[][] matrix) {

        to_triangle(matrix);

        System.out.println("\nТреугольная матрица с преобразованным столбцом B:");
        for (int i = 0; i < matrix.length; i++) {
            for (int m = 0; m < matrix[0].length; m++) {
                if (m == 0 && i != 0) System.out.println();
                if (m == matrix[0].length - 1) System.out.print(" | ");
                System.out.printf("%4f\t", matrix[i][m]);

            }
        }

        float det = get_determinant(matrix);
        System.out.println("\n\nОпределитель: " + det);
        int rang = check_rang(matrix);
        if (rang == 1) {
            float[] solution = get_solution(matrix);
            System.out.println("\nВектор значений x:");
            for (int i = 0; i < solution.length; i++) {
                System.out.println("x" + i + " = " + solution[i]);
            }


            float[] discrepancy = get_discrepancy(matrix, solution);
            System.out.println("\nВектор невязок:");
            for (int i = 0; i < solution.length; i++) {
                System.out.println("r" + i + " = " + discrepancy[i]);
            }

        } else if (rang == 2) {
            System.out.println("\nМножество решений бесконечно.");
        } else if (rang == 0) {
            System.out.println("\nРешений нет.");
        }
    }

}
