import java.util.*;

public class Bubble {
    ArrayList<Integer> list;
    public Bubble(ArrayList<Integer> unsortedList) {
        list = unsortedList;
    }

    public void sort() {
        int i = 0;
        while (i < list.size()) {
            int j = 0;
            while (j < list.size() - i - 1) {
                if (list.get(j) > list.get(j + 1)) {
                    int temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
                j++;
            }
            i++;
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

        Bubble bubble = new Bubble(arr);
        bubble.sort();
        System.out.println(bubble.print());
    }
}
