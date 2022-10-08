package ru.yandex.qa.annotations;

import java.lang.annotation.*;

public class MainAnnotations {

    //@SuppressWarnings("all")
    public static void main(String[] args) {
        /*MyClass myClass = new MyClass();
        myClass.method();

        Thread thread = new Thread();
        thread.stop();

        Object o = null;
        o.toString();*/

        Class2 class2 = new Class2();
        Class<? extends Class2> aClass = class2.getClass();

        Annotation[] annotations = aClass.getAnnotations();
        MyAnnotation annotation = (MyAnnotation) annotations[0];
        String message = annotation.message();
        int value = annotation.value();
        System.out.println(message);
        System.out.println(value);

        MyAnnotation annotation2 = (MyAnnotation) aClass.getMethods()[0].getAnnotations()[0];
        System.out.println(annotation2.message());
        System.out.println(annotation2.value());
    }

    public static class Class1 {

        public void method() {

        }
    }

    @MyAnnotation(message = "я стою над классом")
    public static class Class2 extends Class1 {

        @Override
        @MyAnnotation(message = "я стою над методом", value = 200)
        public void method() {
            //super.method();
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
