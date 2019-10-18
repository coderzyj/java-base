package zidingyi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;

/**
 * @author : 张勇杰
 * @date : 2019/10/14 17:52
 * @Version : v1.0
 * @description
 **/
public class Test {
    public static void main(String[] args) {
        String s = "aaaaaaaaaaaaa";
        List<Operate<String>> operates = new ArrayList<>();

        Operate<String> lenthO = new LengthOperate();
        Operate<String> judgeO = new JudgeStartOperate();
        operates.add(lenthO);
        operates.add(judgeO);
        doSomething(s,operates);
        Comparator<Integer> comparator = Integer::compare;
        System.out.println(comparator.compare(1,2));
    }

    public static String doSomething(String s, List<Operate<String>> operates){
        String re = "";
        for(Operate o :operates){
            if((re = (String) o.operate(s)).equals("")){
                break;
            }
        }
        return re;
    }
}
