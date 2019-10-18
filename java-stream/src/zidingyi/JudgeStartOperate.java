package zidingyi;

/**
 * @author : 张勇杰
 * @date : 2019/10/14 18:02
 * @Version : v1.0
 * @description
 **/
public class JudgeStartOperate implements Operate<String>{
    @Override
    public String operate(String s) {
        if(s.startsWith("x")){
            return s;
        }
        return "";
    }
}
