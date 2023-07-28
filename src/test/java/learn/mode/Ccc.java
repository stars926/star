package learn.mode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ccc {

    public static void main(String[] args) {
        debugStream();
        debugCondition();
    }

    public static void debugStream(){
        List<Integer> list = Arrays.asList(1,20,21,111,222,44,56);
        list.stream()
                .filter(x -> x > 21)
                .map(x -> x + 100)
                .forEach(x->{
                    if (x == 144){
                        System.out.println("断点");
                    }
                    System.out.println(x);
                });
    }


    public static void debugCondition() {
        List<Integer> list = Arrays.asList(1, 20, 21, 44, 56, 22, 12, 345);
        // 条件断点
        for (Integer i : list) {
            System.out.println(i);
            if (i==22){
                System.out.println("右键断点，配置DEBUG条件！");
            }
        }
    }
}
