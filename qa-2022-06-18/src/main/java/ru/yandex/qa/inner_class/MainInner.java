package ru.yandex.qa.inner_class;

import ru.yandex.qa.inner_class.info.Info;
import ru.yandex.qa.inner_class.service.MothReporterService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;

public class MainInner {

    public static void main(String[] args) {
        //MothReporterService mothReporterService = new MothReporterService();
        //mothReporterService.method();

        //MothReporterService.MouthInfo mouthInfo = new MothReporterService.MouthInfo();

        String fileStr = readFile("qa-2022-06-18/src/main/resources/example.csv");
        System.out.println(fileStr);

        if (fileStr != null) {
            String[] split = fileStr.split(System.lineSeparator());
            System.out.println(Arrays.toString(split));

            ArrayList<Info> infos = new ArrayList<>();

            for (int i = 1; i < split.length; i++) {
                String[] split1 = split[i].split(";");
                System.out.println(Arrays.toString(split1));

                Info info = new Info(split1[0], Integer.parseInt(split1[1]), Boolean.parseBoolean(split1[2]));
                infos.add(info);
            }

            System.out.println("--------------");
            System.out.println(infos);
        }
    }

    private static String readFile(String path) {
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            //throw new RuntimeException(e);
            return null;
        }
    }
}
