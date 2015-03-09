package sample;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HasAnagrams {
    public static boolean hasAnagrams(List<String> arr){
        Set<String> set = new HashSet<>();
        for (int i = 0; i < arr.size(); i++) {
            if (set.add(sort(arr.get(i))) == false) {
                return true;
            }
        }
        return false;       
    }
  
    public static String sort(String s) {
        char[] ch = s.toCharArray();
        Arrays.sort(ch);
        return new String(ch);
    }
}
