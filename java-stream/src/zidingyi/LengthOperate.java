package zidingyi;

/**
 * @author : 张勇杰
 * @date : 2019/10/14 17:57
 * @Version : v1.0
 * @description
 **/
public class LengthOperate implements Operate<String> {
    @Override
    public String operate(String s) {
        if(s.length() <= 2){
            return "";
        }
        return s;
    }
}
