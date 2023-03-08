import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MatrixIO {

    float[][] read_from_file(String fileName) {
        float[][] matrix;
        try {
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            String[] arr0 = line.split(" ");
            int rowCount = 0;
            matrix = new float[arr0.length - 1][arr0.length];
            for (int i = 0; i < arr0.length; i++) {
                try {
                    matrix[0][i] = Float.parseFloat(arr0[i]);
                } catch (NumberFormatException e) {
                    System.out.println("Введены неправильные данные.");
                    System.exit(-3);
                }
            }
            while (true) {
                rowCount++;
                line = reader.readLine();
                if (line == null || rowCount >= arr0.length - 1 || line.equals("")) return matrix;
                String[] arr = line.split(" ");
                for (int i = 0; i < arr.length; i++) {
                    try {
                        matrix[rowCount][i] = Float.parseFloat(arr[i]);
                    } catch (NumberFormatException e) {
                        System.out.println("Введены неправильные данные.");
                        System.exit(-3);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Такого файла не существует.");
            System.exit(-2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    float[][] read_from_console() {
        Scanner in = new Scanner(System.in);
        String[] arr0 = in.nextLine().split(" ");
        if (arr0.length == 1) return new float[0][0];
        int rowCount = 0;
        float[][] matrix = new float[arr0.length - 1][arr0.length];
        for (int i = 0; i < arr0.length; i++) {
            try {
                matrix[0][i] = Float.parseFloat(arr0[i]);
            } catch (NumberFormatException e) {
                System.out.println("В файле неправильные данные.");
                System.exit(-3);
            }
        }
        while (rowCount <= arr0.length - 3) {
            rowCount++;
            String[] arr = in.nextLine().split(" ");
            for (int i = 0; i < arr.length; i++) {
                try {
                    matrix[rowCount][i] = Float.parseFloat(arr[i]);
                } catch (NumberFormatException e) {
                    System.out.println("В файле неправильные данные.");
                    System.exit(-3);
                }
            }
        }
        return matrix;
    }


    float[][] read_matrix() {
        float[][] matrix = new float[0][];
        Scanner in = new Scanner(System.in);
        System.out.print("Выберите способ ввода матрицы (1 - консоль, 2 - файл):\n~ ");
        int res = 0;
        try {
            res = in.nextInt();

            if (res == 1) {
                System.out.println("Введите значения расширенной матрицы через пробел:");
                matrix = read_from_console();
            } else if (res == 2) {
                System.out.print("Введите адрес файла:\n~ ");
                Scanner in1 = new Scanner(System.in);
                String filename = in1.nextLine();
                matrix = read_from_file(filename);
            } else {
                System.out.println("\nТакой опции нет.");
                System.exit(-1);
            }
        } catch (InputMismatchException e) {
            System.out.println("\nТакой опции нет.");
            System.exit(-1);
        }
        return matrix;
    }
}
