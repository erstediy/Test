import java.util.Arrays;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String[] args) {
        TestFields ts = new TestFields();
        Arrays.stream(ts.getClass().getDeclaredFields()).forEach(x -> {
            System.out.println(x.getName());
            System.out.println(x.getType());
            System.out.println(x.getType().getName());
            System.out.println(x.getType().getSimpleName());
            System.out.println(x.getClass());
            System.out.println(x.getClass().getName());
            System.out.println(x.getClass().getSimpleName());
            try {
                Object o = x.get(ts);
                String value = (String) o;
                concatSomething(value);

            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        });
        System.out.println("----------------------------------");
        doSomething(ts);
        System.out.println("----------------------------------");
        System.out.println(ts.stringField);
    }

    public static void doSomething(Object o) {
        System.out.println(o.getClass());
    }

    public static void concatSomething(String s) {
        s = s.concat("TEST CONCAT");
    }
}