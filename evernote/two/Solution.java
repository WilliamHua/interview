import java.util.HashMap;
import java.util.ArrayList;
import java.util.Set;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Comparator;
import java.lang.Integer;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution{
    public HashMap<String, Integer> count = new HashMap<>();

    
    public static void main(String[] args){
        try{
            Solution sol = new Solution(); 
        } catch (IOException e) {
            System.err.println("Did not find file: " + args[0]);
        }
    }

    public Solution() throws IOException{
        printTop(process());
    }

    private void increment(String word) {
        if(count.containsKey(word)) {
            count.put(word, count.get(word) + 1);
        } else {
            count.put(word, 1);
        }
    }

    private void printTop(int top) {
        List<String> sortedWords = sortHashMap();
        for(int x = 0; x < top; x++) System.out.println(sortedWords.get(x));
    }

    private int process() throws IOException {
        Scanner scan = new Scanner(new InputStreamReader(System.in));
        Integer numLines = Integer.valueOf(scan.nextLine());
        if(numLines == null) throw new IllegalStateException("File does not" + 
                "contain correct input");
        for(int x = 0; x < numLines; x++) increment(scan.nextLine());
        return Integer.parseInt(scan.nextLine());

    }

    private List<String> sortHashMap() {
        Set<String> set = count.keySet();
        List<String> keys = new ArrayList<String>(set);

        Collections.sort(keys, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int comp = Integer.compare(count.get(s2), count.get(s1));
                if(comp == 0) {
                    return s1.compareTo(s2);
                }
                return comp;
            }
        });
        return keys;
    }
}


