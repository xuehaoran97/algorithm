import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueuePrac {
    public static void main(String[] args) {
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(
                new Comparator<int[]>() {
                    @Override
                    public int compare(int[] m, int[] n) {
                        return m[1] - n[1];
                    }
                }
        );
    }
}
