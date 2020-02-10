import java.util.ArrayList;

public class Sort {
    private String name;
    private SortingLogic logic;
    static ArrayList<Sort> sortList  = new ArrayList<>();

    public Sort(String name, SortingLogic logic){
        this.name = name;
        this.logic = logic;
        sortList.add(this);
    }
    public String getName() {
        return name;
    }
    public void sortAlgorithm(int[] a) throws InterruptedException{
        logic.algorithm(a);
    }

    @Override
    public String toString() {
        return name;
    }
}
