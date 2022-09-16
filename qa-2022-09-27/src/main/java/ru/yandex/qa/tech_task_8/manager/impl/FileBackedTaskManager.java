package ru.yandex.qa.tech_task_8.manager.impl;

import ru.yandex.qa.tech_task_8.task.Task;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;

public class FileBackedTaskManager extends InMamoryTaskManager {
    private final File file;

    public FileBackedTaskManager(File file) {
        this.file = file;
    }

    @Override
    public int addNewTask(Task task) {
        int i = super.addNewTask(task);
        save();
        return i;
    }

    public static FileBackedTaskManager loadFromFile(File file) {
        final FileBackedTaskManager taskManager = new FileBackedTaskManager(file);

        //some logic read file

        return taskManager;
    }

    private void save() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {

            bufferedWriter.write("id,type");
            bufferedWriter.newLine();

            addTasksToFile(bufferedWriter, tasks.values());
            addTasksToFile(bufferedWriter, epics.values());
            addTasksToFile(bufferedWriter, subTasks.values());

            bufferedWriter.newLine();

            //history

        } catch (IOException e) {
            //throw new RuntimeException();
        }
    }

    private <T extends Task> void addTasksToFile(BufferedWriter bufferedWriter, Collection<T> tasks) throws IOException {
        for (Task value : tasks) {
            bufferedWriter.write(value.getId() + "," + value.getTaskType());
            bufferedWriter.newLine();
        }
    }
}
