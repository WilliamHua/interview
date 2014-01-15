import java.util.Scanner;
import java.util.ArrayList;
import java.lang.Integer;
import java.io.InputStreamReader;

public class Solution {
    private ArrayList<Integer> list = new ArrayList<>();
    private int numLines;
    private long product = 1;
    private int zero_count = 0;

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.printList();
    }

    public Solution() {
        Scanner scan = new Scanner(new InputStreamReader(System.in));
        numLines = Integer.parseInt(scan.nextLine());

        for(int x = 0; x < numLines; x++) {
            int num = Integer.parseInt(scan.nextLine());
            if(num == 0) {
                zero_count++;
            } else {
                product *= num;
            }
            list.add(num);
        }
    }

    public void printList() {
        for(int x = 0; x < numLines; x++){
            if(zero_count == 0) {
                System.out.println(product/list.get(x));
            } else if (zero_count == 1) {
                if(list.get(x) == 0) System.out.println(product);
                else System.out.println(0);
            } else if (zero_count > 1) { 
                System.out.println(0);
            }
        }
    }
}
