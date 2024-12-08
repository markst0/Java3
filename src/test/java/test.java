import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class test {

    private static final int TEST_SIZE = 10000; // Количество операций
    private static final long MAX_TIME_LIMIT = 10000000; // Максимальное время в наносекундах

    @Test
    public void testArrayListPerformance() {
        ArrayList<Integer> arrayList = new ArrayList<>();

        long addTime = measureAddTime(arrayList);
        long getTime = measureGetTime(arrayList);
        long deleteTime = measureDeleteTime(arrayList);

        System.out.printf("ArrayList - Add: %d ns, Get: %d ns, Delete: %d ns\n", addTime, getTime, deleteTime);

        // Проверка, что операции выполняются в разумные сроки
        assertTrue(addTime < MAX_TIME_LIMIT, "ArrayList add time exceeded the limit");
        assertTrue(getTime < MAX_TIME_LIMIT, "ArrayList get time exceeded the limit");
        assertTrue(deleteTime < MAX_TIME_LIMIT, "ArrayList delete time exceeded the limit");
    }

    @Test
    public void testLinkedListPerformance() {
        LinkedList<Integer> linkedList = new LinkedList<>();

        long addTime = measureAddTime(linkedList);
        long getTime = measureGetTime(linkedList);
        long deleteTime = measureDeleteTime(linkedList);

        System.out.printf("LinkedList - Add: %d ns, Get: %d ns, Delete: %d ns\n", addTime, getTime, deleteTime);

        // Проверка, что операции выполняются в разумные сроки
        assertTrue(addTime < MAX_TIME_LIMIT, "LinkedList add time exceeded the limit");
        assertTrue(getTime < MAX_TIME_LIMIT, "LinkedList get time exceeded the limit");
        assertTrue(deleteTime < MAX_TIME_LIMIT, "LinkedList delete time exceeded the limit");
    }

    private long measureAddTime(java.util.List<Integer> list) {
        long startTime = System.nanoTime();
        for (int i = 0; i < TEST_SIZE; i++) {
            list.add(i);
        }
        return System.nanoTime() - startTime;
    }

    private long measureGetTime(java.util.List<Integer> list) {
        long startTime = System.nanoTime();
        for (int i = 0; i < TEST_SIZE; i++) {
            list.get(i);
        }
        return System.nanoTime() - startTime;
    }

    private long measureDeleteTime(java.util.List<Integer> list) {
        long startTime = System.nanoTime();
        for (int i = 0; i < TEST_SIZE; i++) {
            list.remove(0); // Удаляем первый элемент
        }
        return System.nanoTime() - startTime;
    }
}
