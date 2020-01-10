import java.util.ArrayList;

public abstract class Sort {
    private String name;
    static ArrayList<Sort> sortList  = new ArrayList<>();

    public Sort(String name){
        this.name = name;
        sortList.add(this);
    }
    public String getName() {
        return name;
    }
    public abstract void sortAlgorithm(int[] a) throws InterruptedException;

    @Override
    public String toString() {
        return name;
    }
}
