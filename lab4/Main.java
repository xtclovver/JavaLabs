import java.util.Arrays;
import java.util.Scanner;

class HeapSort {
    public static void heapSort(int[] sortArr){
        int n = sortArr.length;
        int i = (n - 2) / 2;
        while ( i >= 0)
        {
            heapify(sortArr, i--, n);
        }
        while ( n > 0)
        {
            sortArr[n-1] = pop(sortArr,n);
            n--;
        }
    }
    public static int pop(int[] sortArr, int size){
        if (size <= 0)
        {
            return -1;
        }
        int top = sortArr[0];
        sortArr[0] = sortArr[size-1];
        heapify(sortArr, 0, size - 1);
        return top;
    }
    public static void heapify (int[] sortArr, int i, int size)
    {
        int left = LEFT(i);
        int right = RIGHT(i);
        int largest = i;
        if (left < size && sortArr[left] < sortArr[largest])
        {
            largest = left;
        }
        if (right < size && sortArr[right] < sortArr[largest])
        {
            largest = right;
        }
        if (largest != i)
        {
            swap(sortArr, i, largest);
//            System.out.print(i);
//            System.out.print(": ");
//            System.out.println(Arrays.toString(sortArr));
            heapify(sortArr, largest, size);
        }
    }
    static int LEFT(int i)
    {
        return 2 * i + 1;
    }
    static int RIGHT(int i)
    {
        return 2 * i + 2;
    }
    static void swap(int[] sortArr, int i, int j)
    {
        int swap = sortArr[i];
        sortArr[i] = sortArr[j];
        sortArr[j] = swap;
    }
}

public class Main {
    public static void main(String[] args) {
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

        HeapSort.heapSort(array);

        System.out.println("Сортированный массив (по убыванию): ");
        System.out.println(Arrays.toString(array));
    }
}