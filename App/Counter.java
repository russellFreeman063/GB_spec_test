package App;

public class Counter implements AutoCloseable{
    private static int count = 0;
    public static void add() {
        count++;
    }

    @Override
    public void close() throws Exception {

    }
}
