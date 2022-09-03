package ru.yandex.qa.tech_task_6.manager.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.yandex.qa.tech_task_6.manager.ManagersTest;
import ru.yandex.qa.tech_task_6.tassk.Task;

import java.util.List;

class InMamoryTaskManagerTest extends ManagersTest<InMamoryTaskManager> {

    @BeforeEach
    void setUp() {
        taskManager = new InMamoryTaskManager();
        initTasks();
    }

    @Test
    @DisplayName("Проверка получения тасок")
    void getTasks() {
        List<Task> tasks = taskManager.getTasks();

        Assertions.assertAll(
                () -> Assertions.assertEquals(tasks.size(), 2),
                () -> Assertions.assertTrue(tasks.contains(new Task(1))),
                () -> Assertions.assertTrue(tasks.contains(new Task(2)))
        );
    }
}