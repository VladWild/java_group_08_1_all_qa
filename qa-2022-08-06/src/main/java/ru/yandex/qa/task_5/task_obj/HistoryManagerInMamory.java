package ru.yandex.qa.task_5.task_obj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HistoryManagerInMamory implements HistoryManager {

    private Map<Integer, Node> nodeMap = new HashMap<>();
    private Node first;
    private Node last;

    @Override
    public void add(Task task) {

        removeNode(task.getId());
        linkLast(task);
        nodeMap.put(task.getId(), last);
    }

    private void linkLast(Task task) {
        Node node = new Node(task, last, null);

        //some logic
    }

    @Override
    public void remove(int taskId) {
        removeNode(taskId);
    }

    private void removeNode(int taskId) {
        Node remove = nodeMap.remove(taskId);
        if (remove == null) {
            return;
        }

    }

    @Override
    public List<Task> getHistory() {
        List<Task> list = new ArrayList<>();



        return list;
    }

    private class Node {
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
