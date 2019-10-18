package fork_join;

import java.util.List;
import java.util.concurrent.RecursiveAction;

/**
 * @author : 张勇杰
 * @date : 2019/9/23 17:52
 * @Version : v1.0
 * @description
 **/
public class UserRecursiveAction extends RecursiveAction {

    private List<User> userList;

    private int start,end;

    public UserRecursiveAction(List<User> userList) {
        this.userList = userList;
//        this.start = start;
//        this.end = end;
    }

    @Override
    protected void compute() {
        if(userList.size() <= 10){
            for(User u :userList){
                u.setAge(1);
                u.setName("zhang");
            }
        }else{
            int mid = userList.size()/2;
            UserRecursiveAction left = new UserRecursiveAction(userList.subList(0,mid));
            UserRecursiveAction right = new UserRecursiveAction(userList.subList(mid,userList.size()));
            left.fork();
            right.fork();


        }

    }
}
