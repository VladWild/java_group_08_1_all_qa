package manager.impl;

import manager.TaskManagerTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.yandex.qa.tech_task_8.manager.impl.InMamoryTaskManager;
import ru.yandex.qa.tech_task_8.task.Task;

import java.util.List;

class InMamoryTaskManagerTest extends TaskManagerTest<InMamoryTaskManager> {

    @BeforeEach
    void setUp() {
        taskManager = new InMamoryTaskManager();
        initTasks(); //общие данные
    }

    @Test
    @DisplayName("Проверка получения тасок")
    void getTaskTest() {
        List<Task> tasks = taskManager.getTasks();
        taskManager.addNewTask(new Task(3));

        Assertions.assertAll(
                () -> Assertions.assertEquals(tasks.size(), 3),
                () -> Assertions.assertTrue(tasks.contains(new Task(1))),
                () -> Assertions.assertTrue(tasks.contains(new Task(2))),
                () -> Assertions.assertTrue(tasks.contains(new Task(3)))
        );
    }

    @Test
    @DisplayName("Проверка исключения")
    void getTaskTest2() {
        Assertions.assertThrows(UnsupportedOperationException.class, () -> taskManager.method());
    }
}