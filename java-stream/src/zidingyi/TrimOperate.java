package zidingyi;

/**
 * @author : 张勇杰
 * @date : 2019/10/14 17:53
 * @Version : v1.0
 * @description
 **/
public class TrimOperate implements Operate<String>{

    @Override
    public String operate(String s) {
        return s.trim();
    }
}
