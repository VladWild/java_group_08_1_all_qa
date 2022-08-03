package ru.yandex.qa.task_5.task_obj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryHistoryManager implements HistoryManager {

    private final Map<Integer, Node> nodeMap = new HashMap<>();

    private Node first;
    private Node last;

    @Override
    public void add(Task task) {

        removeNode(task.getId()); //Вот это тоже важно учесть!!!!!
        linkLast(task);
        nodeMap.put(task.getId(), last);
    }

    private void linkLast(Task task) {
        Node newNode = new Node(task, last, null);

        //some logic
    }

    @Override
    public void remove(int id) {
        removeNode(id);
    }

    private void removeNode(int id) {
        Node removeNode = nodeMap.remove(id);
        if (removeNode == null) {
            return;
        }

        //some logic
    }

    @Override
    public List<Task> getHistory() {
        List<Task> tasks = new ArrayList<>();

        //some logic with use while

        return tasks;
    }

    public static class Node {
        Task task;
        Node prev;
        Node next;

        public Node(Task task, Node prev, Node next) {
            this.task = task;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "task=" + task +
                    ", prev=" + (prev != null ? prev.task : null) +
                    ", next=" + (next != null ? next.task : null) +
                    '}';
        }
    }
}
