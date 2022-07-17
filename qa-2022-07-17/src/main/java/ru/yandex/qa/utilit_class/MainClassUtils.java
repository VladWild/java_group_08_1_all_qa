package ru.yandex.qa.utilit_class;

import java.util.LinkedList;
import java.util.List;

import static ru.yandex.qa.utilit_class.MainClassUtils.HistoryManagerFactory.getHistoryManagerDB;
import static ru.yandex.qa.utilit_class.MainClassUtils.HistoryManagerFactory.getHistoryManagerMemory;

public class MainClassUtils {

    public static void main(String[] args) {
        HistoryManager historyManager = getHistoryManagerMemory();
        historyManager.add(new Task());
        historyManager.getTasks();

        int abs = Math.abs(-5);
        System.out.println(abs);

        int sum = MathUtils.sum(5, 8);
        System.out.println(sum);
    }

    public interface HistoryManager {

        void add(Task task);

        List<Task> getTasks();
    }

    public static class MemoryHistoryManager implements HistoryManager {
        private List<Task> tasks = new LinkedList<>();

        @Override
        public void add(Task task) {
            //some logic
        }

        @Override
        public List<Task> getTasks() {
            return tasks;
        }
    }

    public static class MemoryHistoryDataBase implements HistoryManager {

        @Override
        public void add(Task task) {
            //some logic with database
        }

        @Override
        public List<Task> getTasks() {
            return null;
        }
    }

    public static class HistoryManagerFactory {

        public static HistoryManager getHistoryManagerMemory() {
            return new MemoryHistoryManager();
        }

        public static HistoryManager getHistoryManagerDB() {
            return new MemoryHistoryDataBase();
        }
    }

    public static class Task {}

    public static class MathUtils {

        private MathUtils() {};

        public static int sum(int a, int b) {
            return a + b;
        }
    }
}
