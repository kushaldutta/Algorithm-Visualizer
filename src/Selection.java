import java.util.*;

public class Selection {
    ArrayList<Integer> list;
    public Selection(ArrayList<Integer> unsortedList) {
        list = unsortedList;
    }

    public void sort() {
        for (int i = 0; i < list.size(); i++) {
            int smallest = list.get(i);
            int pos = i;
            for (int j = i; j < list.size(); j++) {
                if (list.get(j) < smallest) {
                    smallest = list.get(j);
                    pos = j;
                }
            }
            list.set(pos, list.get(i));
            list.set(i, smallest);
        }
    }

    public ArrayList<Integer> print() {
        return list;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(6);
        arr.add(9);
        arr.add(600);
        arr.add(3);
        arr.add(8);
        arr.add(-2);
        arr.add(34);
        arr.add(6);

        Selection selection = new Selection(arr);
        selection.sort();
        System.out.println(selection.print());
    }
}
