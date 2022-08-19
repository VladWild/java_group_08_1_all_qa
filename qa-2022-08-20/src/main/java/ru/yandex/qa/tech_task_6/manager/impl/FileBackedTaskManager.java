package ru.yandex.qa.tech_task_6.manager.impl;

import ru.yandex.qa.tech_task_6.manager.CSVTaskFormat;
import ru.yandex.qa.tech_task_6.tasks.Task;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class FileBackedTaskManager extends InMemoryTaskManager {
    private final File file;

    public FileBackedTaskManager(File file) {
        this.file = file;
    }

    public static FileBackedTaskManager loadFromFile(File file) {
        FileBackedTaskManager fileBackedTaskManager = new FileBackedTaskManager(file);
        try {
            if (true) {
                throw new IOException();
            }
        } catch (IOException e) {
            //свое исключение с message - can't read file
        }
        return fileBackedTaskManager;
    }

    @Override
    public int addNewTask(Task task) {
        int taskId = super.addNewTask(task);
        save();
        return taskId;
    }

    private void save() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(CSVTaskFormat.getHeader());
            writer.newLine();

            addTaskToWriter(writer, tasks);
            addTaskToWriter(writer, epics);
            addTaskToWriter(writer, subTasks);

            writer.newLine();
            //writer.write(CSVTaskFormat.toString(..)); //тут логика с historyManager
            //writer.newLine();
        } catch (IOException exception) {
            //свое исключение с message - can't save file
        }
    }

    private <T extends Task> void addTaskToWriter(BufferedWriter writer, Map<Integer, T> tasks) throws IOException {
        for (Map.Entry<Integer, T> entry : tasks.entrySet()) {
            Task task = entry.getValue();
            writer.write(CSVTaskFormat.toString(task));
            writer.newLine();
        }
    }
}
