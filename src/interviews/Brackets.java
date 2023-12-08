package interviews;

import java.util.ArrayList;
import java.util.List;

public class Brackets {
    public static List<String> brackets = new ArrayList<>();
    public static void main(String[] args) {
        calculateBrackets(new StringBuilder(), 3, 0);
        for (String b: brackets) {
            System.out.println(b);
        }
    }
    private static void calculateBrackets(StringBuilder sb, int n, int o) {
        if ( n== 0 && o == 0) {
            brackets.add(sb.toString());
        }
        if (n> 0) {
            calculateBrackets(sb.append("{"), --n, ++o);
            sb.deleteCharAt(sb.length()-1);
            ++n;
            --o;
        }
        if (o > 0) {
            calculateBrackets(sb.append("}"), n, --o);
            sb.deleteCharAt(sb.length()-1);
            ++o;
        }
    }
}
