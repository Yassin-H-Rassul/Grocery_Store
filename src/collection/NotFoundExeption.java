package collection;

public class NotFoundExeption extends Exception{
    private int number;

    public NotFoundExeption() {
        super();
    }

    public NotFoundExeption(int number) {
        super();
        this.number = number;
    }

    @Override
    public String toString() {
        return "NotFoundExeption{" +
                "number=" + number +
                '}';
    }
}
