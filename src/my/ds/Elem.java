package my.ds;

public class Elem {
    public int value;
    public int index;

    public Elem() {
    }

    public Elem(int value, int index) {
        this.value = value;
        this.index = index;
    }

    @Override
    public String toString() {
        return "Elem{" +
                "value=" + value +
                ", index=" + index +
                '}';
    }
}
