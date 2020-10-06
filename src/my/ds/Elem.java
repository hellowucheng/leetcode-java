package my.ds;

public class Elem <E>{
    public E value;
    public int index;

    public Elem() {
    }

    public Elem(E value, int index) {
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
