
import java.util.Scanner;

public class Main {
    public static void main(String args[]) throws Exception {

        //ввод исходных данных
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество элементов (0; 10^9]: size = ");
        int size = Integer.parseInt(scanner.nextLine());
        System.out.print("Введите минимальное значение элемента [-10^9; 10^9]: min = ");
        int min = Integer.parseInt(scanner.nextLine());
        System.out.print("Введите максимальное значение элемента [-10^9; 10^9]: max = ");
        int max = Integer.parseInt(scanner.nextLine());
        if (min >= max || Math.abs(min) > Math.pow(10, 9) || Math.abs(max) > Math.pow(10, 9) || Math.abs(size) > Math.pow(10, 9)) {
            System.out.println("Неверные входные данные");
            return;
        }

        //заполнение массива числами в диапазоне [min; max]
        int[] array = new int[size];
        for (int i = 1; i < size; i++) {
            array[i] = ((int) (Math.random() * (max - min + 1)) + min);
        }

        //вывод массива
        System.out.print("\nИсходный массив: ");
        printArray(array);

        int[] arrayBubbleSort = new int[array.length];
        copyArray(array, arrayBubbleSort);
        int[] arrayBubbleSortMod = new int[array.length];
        copyArray(array, arrayBubbleSortMod);
        int[] arrayBubbleSortVisualisation = new int[array.length];
        copyArray(array, arrayBubbleSortVisualisation);

        int[] arraySelectionSort = new int[array.length];
        copyArray(array, arraySelectionSort);
        int[] arraySelectionSortMod = new int[array.length];
        copyArray(array, arraySelectionSortMod);
        int[] arraySelectionSortVisualization = new int[array.length];
        copyArray(array, arraySelectionSortVisualization);

        int[] arrayInsertionSort = new int[array.length];
        copyArray(array, arrayInsertionSort);
        int[] arrayInsertionSortMod = new int[array.length];
        copyArray(array, arrayInsertionSortMod);
        int[] arrayInsertionSortVisualization = new int[array.length];
        copyArray(array, arrayInsertionSortVisualization);

        //сортировка пузырьком
        //чистая
        bubbleSort(arrayBubbleSort);
        //грязная
        bubbleSortMod(arrayBubbleSortMod);

        //сортировка выбором
        //чистая
        selectionSort(arraySelectionSort);
        //грязная
        selectionSortMod(arrayBubbleSortMod);

        //сортировка вставками
        //чистая
        insertionSort(arrayInsertionSort);
        //грязная
        insertionSortMod(arrayInsertionSortMod);

        //визуализация
        bubbleSortVisualisation(arrayBubbleSortVisualisation);
        selectionSortVisualization(arraySelectionSortVisualization);
        insertionSortVisualization(arrayInsertionSortVisualization);
    }

    //обмен местами элементов
    private static void swap(int[] array, int index1, int index2) {
        int tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }

    //вывод всего массива
    private static void printArray(int[] array) {
        System.out.println("");
        for (int array_item : array) {
            System.out.print(array_item + " ");
        }
    }

    //вывод первых 100 элементов массива
    private static void printArrayVisualization(int[] array) {
        System.out.println("");
        for (int array_item = 0; array_item < 100; array_item++) {
            System.out.print(array[array_item] + " ");
        }
    }

    //копирование массива
    public static int[] copyArray(int[] array, int[] newArray) {
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }



    //чистая сортировка пузырьком
    private static void bubbleSort(int[] array) {
        //начало алгоритма
        long time = System.nanoTime();
        boolean needIteration = true;
        while (needIteration) {
            needIteration = false;
            for (int i = 1; i < array.length; i++) {
                if (array[i] < array[i - 1]) {
                    swap(array, i, i - 1);
                    needIteration = true;
                }
            }
        }
        time = System.nanoTime() - time;
        //конец алгоритма

        System.out.print("\n\nМетод пузырька: ");
        printArray(array);
        System.out.print("\nВремя выполнения алгоритма (без подсчета): " + time / 1_000_000.0);
    }

    //грязная сортировка пузырьком
    private static void bubbleSortMod(int[] array) {
        //начало алгоритма
        int compareNumber = 0;
        int addressNumber = 0;
        int writeNumber = 0;

        long time = System.nanoTime();
        boolean needIteration = true;
        while (needIteration) {
            needIteration = false;
            for (int i = 1; i < array.length; i++) {
                if (array[i] < array[i - 1]) {
                    swap(array, i, i - 1);
                    needIteration = true;

                    addressNumber = addressNumber + 3;
                    writeNumber = writeNumber + 2;
                }
                compareNumber++;
                addressNumber = addressNumber + 2;
            }
        }
        time = System.nanoTime() - time;
        //конец алгоритма

        //System.out.println("\nГрязный метод пузырька:");
        //printArray(array);
        System.out.print("\nВремя выполнения алгоритма (с подсчетом): " + time / 1_000_000.0);
        System.out.print("\nЧисло сравнений: " + compareNumber);
        System.out.print("\nЧисло обращений: " + addressNumber);
        System.out.print("\nЧисло пере(записи): " + writeNumber);
    }

    //визуализация сортировки пузырьком
    private static void bubbleSortVisualisation(int[] array) {
        System.out.print("\n\nПроцесс сортировки пузырьком (каждый шаг):");
        printArray(array);
        System.out.print("- исходный массив");
        boolean needIteration = true;
        while (needIteration) {
            needIteration = false;
            if (array.length <= 100)
                for (int i = 1; i < array.length; i++) {
                    if (array[i] < array[i - 1]) {
                        swap(array, i, i - 1);
                        printArray(array);
                        needIteration = true;
                    } else printArray(array);
                }
            else
                for (int i = 1; i <= 100; i++) {
                    if (array[i] < array[i - 1]) {
                        swap(array, i, i - 1);
                        printArrayVisualization(array);
                        needIteration = true;
                    } else printArrayVisualization(array);
                }
        }
    }



    //чистая сортировка выбором
    private static void selectionSort(int[] array) {
        long time = System.nanoTime();
        for (int left = 0; left < array.length; left++) {
            int minInd = left;
            for (int i = left; i < array.length; i++) {
                if (array[i] < array[minInd]) {
                    minInd = i;
                }
            }
            swap(array, left, minInd);
        }
        time = System.nanoTime() - time;
        System.out.print("\n\nМетод сортировки выбором: ");
        printArray(array);
        System.out.print("\nВремя выполнения алгоритма (без подсчета): " + time / 1_000_000.0);
    }

    //грязная сортировка выбором
    private static void selectionSortMod(int[] array) {
        long time = System.nanoTime();

        int compareNumber = 0;
        int addressNumber = 0;
        int writeNumber = 0;
        for (int left = 0; left < array.length; left++) {
            int minInd = left;
            for (int i = left; i < array.length; i++) {
                if (array[i] < array[minInd]) {
                    minInd = i;
                }
                compareNumber = compareNumber + 1;
                addressNumber = addressNumber + 2;
            }
            swap(array, left, minInd);
            writeNumber = writeNumber + 2;
            addressNumber = addressNumber + 3;
        }
        time = System.nanoTime() - time;

        //System.out.println("\nГрязный метод сортировки выбором:");
        //printArray(array);
        System.out.print("\nВремя выполнения алгоритма (с подсчетом): " + time / 1_000_000.0);
        System.out.print("\nЧисло сравнений: " + compareNumber);
        System.out.print("\nЧисло обращений: " + addressNumber);
        System.out.print("\nЧисло пере(записи): " + writeNumber);
    }

    //визуализация сортировки выбором
    private static void selectionSortVisualization(int[] array) {
        System.out.print("\n\nПроцесс сортировки выбором (каждый шаг):");
        printArray(array);
        System.out.print("- исходный массив");
        if (array.length <= 100)
            for (int left = 0; left < array.length; left++) {
                int minInd = left;
                for (int i = left; i < array.length; i++) {
                    if (array[i] < array[minInd]) {
                        minInd = i;
                    }
                }
                swap(array, left, minInd);
                printArray(array);
            }
        else
            for (int left = 0; left < 100; left++) {
                int minInd = left;
                for (int i = left; i < 100; i++) {
                    if (array[i] < array[minInd]) {
                        minInd = i;
                    }
                }
                swap(array, left, minInd);
                printArrayVisualization(array);
            }
    }



    //чистая сортировка вставками
    private static void insertionSort(int[] array) {

        long time = System.nanoTime();
        for (int left = 0; left < array.length; left++) {
            int value = array[left];
            int i = left - 1;
            for (; i >= 0; i--) {
                if (value < array[i]) {
                    array[i + 1] = array[i];
                } else {
                    break;
                }
            }
            array[i + 1] = value;
        }
        time = System.nanoTime() - time;

        System.out.print("\n\nМетод сортировки вставками: ");
        printArray(array);
        System.out.print("\nВремя выполнения алгоритма (без подсчета): " + time / 1_000_000.0);
    }

    //грязная сортировка вставками
    private static void insertionSortMod(int[] array) {
        long time = System.nanoTime();

        int compareNumber = 0;
        int addressNumber = 0;
        int writeNumber = 0;

        for (int left = 0; left < array.length; left++) {
            int value = array[left];
            addressNumber++;
            int i = left - 1;
            for (; i >= 0; i--) {
                if (value < array[i]) {
                    array[i + 1] = array[i];
                    compareNumber++;
                    writeNumber++;
                    addressNumber = addressNumber + 3;
                } else {
                    compareNumber++;
                    break;
                }
            }
            array[i + 1] = value;
            writeNumber++;
            addressNumber++;
        }
        time = System.nanoTime() - time;

        //System.out.println("\n\nГрязный метод сортировки вставками:");
        //printArray(array);
        System.out.print("\nВремя выполнения алгоритма (с подсчетом): " + time / 1_000_000.0);
        System.out.print("\nЧисло сравнений: " + compareNumber);
        System.out.print("\nЧисло обращений: " + addressNumber);
        System.out.print("\nЧисло пере(записи): " + writeNumber);
    }

    //визуализация сортировки вставками
    private static void insertionSortVisualization(int[] array) {
        System.out.print("\n\nПроцесс сортировки вставками (каждый шаг):");
        printArray(array);
        System.out.print("- исходный массив");
        if (array.length <= 100)
            for (int left = 0; left < array.length; left++) {
                int value = array[left];
                int i = left - 1;
                for (; i >= 0; i--) {
                    if (value < array[i]) {
                        array[i + 1] = array[i];
                        printArray(array);
                    } else {
                        break;
                    }
                }
                array[i + 1] = value;
                printArray(array);
            }
        else
            for (int left = 0; left < 100; left++) {
                int value = array[left];
                int i = left - 1;
                for (; i >= 0; i--) {
                    if (value < array[i]) {
                        array[i + 1] = array[i];
                        printArrayVisualization(array);
                    } else {
                        break;
                    }
                }
                array[i + 1] = value;
                printArrayVisualization(array);
            }

    }
}