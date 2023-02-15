package com.javarush.task.task38.task3804;

import java.util.Locale;

public class FactoryClass {
    public static Throwable getFactoryClass(Enum ennum) {
        if (ennum == null)
            return new IllegalArgumentException();
        String message = ennum.name().replaceAll("_", " ");
        String first = message.substring(0, 1);
        String second = message.substring(1).toLowerCase();
        message = first + second;
        System.out.println(message);
        if (ennum instanceof ApplicationExceptionMessage) {
            return new Exception(message);
        } else if (ennum instanceof DatabaseExceptionMessage) {
            return new RuntimeException(message);
        } else if (ennum instanceof UserExceptionMessage) {
            return new Error(message);
        }
        return new IllegalArgumentException();
    }
}
/*
Создай класс - фабрику исключений, который содержит один статический метод, возвращающий нужное исключение.
Этот метод должен принимать один параметр - энум.
Если передан энум:
* ApplicationExceptionMessage, верни исключение Exception
* DatabaseExceptionMessage, верни исключение RuntimeException
* UserExceptionMessage, верни Error иначе верни IllegalArgumentException без сообщения.

В качестве сообщения (message) для каждого возвращаемого объекта используй элементы энума, в которых все знаки подчеркивания замени на пробелы.
Сообщение должно быть в нижнем регистре за исключением первого символа.
Например, сообщение для ApplicationExceptionMessage.SOCKET_IS_CLOSED - "Socket is closed".

Верни класс созданной фабрики в методе Solution.getFactoryClass.

Энумы не меняй.
 */