package Работа_с_JVM;

public class JvmComprehension {
    // Класс JvmComprehension отдается для загрузки в систему ClassLoader'ов,
    // и перемещается в Metaspace для сохранения данных о классе JvmComprehension.
    public static void main(String[] args) {
        // В момент вызова метода main создается фрейм в Stack.
        int i = 1; // 1 Во фрейме main создается переменная i со значением 1.
        Object o = new Object(); // 2 В heap(куча) создается объект Object и во фрейме main создается переменная o,
        // которой присваивается ссылка на этот объект.
        Integer ii = 2; // 3 В heap(куча) создается объект Integer со значением 2,
        // а во фрейме main появляется переменная ii с ссылкой на этот объект.
        printAll(o, i, ii); // 4 В Stack создается фрейм printAll,
        // и в нем записываются переменные o, i, ii.
        System.out.println("finished"); // 7 В Stack создается фрейм println,
        // которому передается ссылка на созданный в heap(куча) объект String со значением "finished".
        // В ходе работы программы отрабатывает Garbage Collection.
    }

    private static void printAll(Object o, int i, Integer ii) {
        Integer uselessVar = 700; // 5 В heap(куча) создается объект Integer со значением 700,
        // а во фрейме printAll появляется переменная uselessVar с ссылкой на этот объект.
        System.out.println(o.toString() + i + ii); // 6 В Stack создается фрейм println,
        // куда передаются ссылки на o, i, ii. В Stack создается фрейм toString.
    }
}
