package ru.yandex.qa.inner_class.service;

import ru.yandex.qa.inner_class.info.Info;
import ru.yandex.qa.inner_class.info.MointInfo;

public class MothReporterService {
    int[] array = new int[]{};
    Info[] infos = new Info[3];

    public MothReporterService() {
    }

    public MointInfo method() {
        MointInfo mointInfo = new MointInfo();

        //some logic

        return mointInfo;
    }

    public class MouthInfo {

    }
}
