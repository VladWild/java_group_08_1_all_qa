package ru.yandex.qa.annotations;

import java.lang.annotation.*;

public class MainAnnotations {

    //@SuppressWarnings("all")
    public static void main(String[] args) {
        Class2 class2 = new Class2();
        class2.method();

        MyClass myClass = new MyClass();
        myClass.method();

        //Thread thread = new Thread();
        //thread.stop();

        //Object object = null;
        //object.getClass();

        Annotation[] annotations = class2.getClass().getAnnotations();
        MyAnnotation annotation = (MyAnnotation) annotations[0];
        String message = annotation.message();
        int value = annotation.value();
        System.out.println(message);
        System.out.println(value);

        Annotation[] annotations2 = class2.getClass().getMethods()[0].getAnnotations();
        MyAnnotation annotation2 = (MyAnnotation) annotations2[0];
        String message2 = annotation2.message();
        int value2 = annotation2.value();
        System.out.println(message2);
        System.out.println(value2);
    }

    public static class Class1 {

        public void method() {

        }
    }

    @MyAnnotation(message = "я стою над классом")
    public static class Class2 extends Class1 {

        @Override
        @MyAnnotation(message = "я стою над методом", value = 201)
        public void method() {

        }
    }

    @Documented
    @Target({ElementType.TYPE, ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface MyAnnotation {
        String message();

        int value() default 100;
    }
}
