package org.example;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Класс для тестирования производительности коллекций {@link ArrayList} и {@link LinkedList}.
 *
 * Выполняет операции добавления, получения и удаления элементов из коллекций
 * и измеряет время, затраченное на каждую из операций.
 */
public class Lists {

    private static final int TEST_SIZE = 10000; // Количество операций

    /**
     * Главный метод, который запускает тесты производительности для {@link ArrayList} и {@link LinkedList}.
     *
     * @param args аргументы командной строки (не используются)
     */
    public static void main(String[] args) {
        testArrayList();
        testLinkedList();
    }

    /**
     * Тестирует производительность {@link ArrayList}.
     * Измеряет время выполнения операций добавления, получения и удаления элементов
     * и выводит результаты.
     */
    private static void testArrayList() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        long addTime = measureAddTime(arrayList);
        long getTime = measureGetTime(arrayList);
        long deleteTime = measureDeleteTime(arrayList);

        printResults("ArrayList", addTime, getTime, deleteTime);
    }

    /**
     * Тестирует производительность {@link LinkedList}.
     * Измеряет время выполнения операций добавления, получения и удаления элементов
     * и выводит результаты.
     */
    private static void testLinkedList() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        long addTime = measureAddTime(linkedList);
        long getTime = measureGetTime(linkedList);
        long deleteTime = measureDeleteTime(linkedList);

        printResults("LinkedList", addTime, getTime, deleteTime);
    }

    /**
     * Измеряет время выполнения операции добавления элементов в коллекцию.
     *
     * @param list коллекция, в которую будут добавляться элементы
     * @return время в наносекундах, затраченное на добавление элементов
     */
    private static long measureAddTime(java.util.List<Integer> list) {
        long startTime = System.nanoTime();
        for (int i = 0; i < TEST_SIZE; i++) {
            list.add(i);
        }
        return System.nanoTime() - startTime;
    }

    /**
     * Измеряет время выполнения операции получения элементов из коллекции.
     *
     * @param list коллекция, из которой будут получаться элементы
     * @return время в наносекундах, затраченное на получение элементов
     */
    private static long measureGetTime(java.util.List<Integer> list) {
        long startTime = System.nanoTime();
        for (int i = 0; i < TEST_SIZE; i++) {
            list.get(i);
        }
        return System.nanoTime() - startTime;
    }

    /**
     * Измеряет время выполнения операции удаления элементов из коллекции.
     *
     * @param list коллекция, из которой будут удаляться элементы
     * @return время в наносекундах, затраченное на удаление элементов
     */
    private static long measureDeleteTime(java.util.List<Integer> list) {
        long startTime = System.nanoTime();
        for (int i = 0; i < TEST_SIZE; i++) {
            list.remove(0); // Удаляем первый элемент
        }
        return System.nanoTime() - startTime;
    }

    /**
     * Выводит результаты тестирования производительности.
     *
     * @param listType   тип коллекции ("ArrayList" или "LinkedList")
     * @param addTime    время добавления элементов в наносекундах
     * @param getTime    время получения элементов в наносекундах
     * @param deleteTime время удаления элементов в наносекундах
     */
    private static void printResults(String listType, long addTime, long getTime, long deleteTime) {
        System.out.println("Results " + listType + ":");
        System.out.printf("Add: %d ns\n", addTime);
        System.out.printf("Get: %d ns\n", getTime);
        System.out.printf("Delete: %d ns\n", deleteTime);
        System.out.println();
    }
}
