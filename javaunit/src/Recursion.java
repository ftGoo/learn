/**
 * Created by wb on 2018/6/12
 */
public class Recursion {
    public static void RecursionTest(int i){
        if(i == 5){
            return;
        }
        i ++;
        System.out.println(i);
        RecursionTest(i);
    }

    public static void main(String[] args) {
        RecursionTest(1);
    }
}
