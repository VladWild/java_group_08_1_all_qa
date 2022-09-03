package ru.yandex.qa.tech_task_6.manager.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.yandex.qa.tech_task_6.manager.ManagersTest;
import ru.yandex.qa.tech_task_6.tassk.Task;

import java.io.File;
import java.util.List;

class FileBackedTaskManagerTest extends ManagersTest<FileBackedTaskManager> {

    private File file;

    @BeforeEach
    void setUp() {
        file = new File("qa-2022-08-20/src/main/resources/tasks.csv");
        taskManager = new FileBackedTaskManager(file);
        initTasks();
    }

    @AfterEach
    public void cleanUpEach() {
        file.delete();
    }

    @Test
    void loadFileTest() {
        FileBackedTaskManager fileBackedTaskManager = taskManager.loadFromFile(file);
        List<Task> tasks = fileBackedTaskManager.getTasks();

        Assertions.assertAll(
                () -> Assertions.assertNotNull(tasks)
                //() -> Assertions.
        );
    }
}