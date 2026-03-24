import java.util.ArrayList;

public class Practice01 {
    public static void main(String[] args) {

    }


    public static int[] ArraylistToArray(ArrayList<Integer> arrlist) {
        int[] result = new int[arrlist.size()];
        for (int i = 0; i < arrlist.size(); i++) {
            result[i] = arrlist.get(i);
        }
        return result;
    }
}
