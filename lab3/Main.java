import java.util.Arrays;
import java.util.Scanner;

class Quicksort {

    static int partition(int array[], int low, int high) {

        // выбрать самый правый элемент как середину
        int middle = array[high];

        // указатель на больший элемент
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (array[j] >= middle) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return (i + 1);
    }

    static void quickSort(int array[], int low, int high) {
        if (low < high) {

            // находим элемент середины такой, что
            // элементы, меньшие, чем точка середины, находятся слева
            // элементы больше, чем точка чередины, находятся справа
            int pi = partition(array, low, high);

            // рекурсивный вызов справо от точки середины
            quickSort(array, low, pi - 1);

            // рекурсивный вызов слева от точки середины
            quickSort(array, pi + 1, high);
        }
    }
}

class Main {
    public static void main(String args[]) {
        int size = 7;
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[size];
        System.out.println("Введите 7 элементов массива: ");
        for (int i = 0; i < size; i++)
        {
            array[i] = scanner.nextInt();
        }
        System.out.println("Неотсортированный массив:");
        System.out.println(Arrays.toString(array));
        Quicksort.quickSort(array, 0, size - 1);

        System.out.println("Сортированный массив по убыванию");
        System.out.println(Arrays.toString(array));
    }
}