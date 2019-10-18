package fork_join;


import java.io.FileOutputStream;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.nio.channels.ServerSocketChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @author : 张勇杰
 * @date : 2019/9/23 16:19
 * @Version : v1.0
 * @description
 **/
public class Test {
    private static int threshold = 100;
    private static int sum = 0;
    static class MyRecursive extends RecursiveTask<Long>{

        Long sum = Long.valueOf(0);
        private int left;
        private int right;

        public MyRecursive(int left, int right) {
            this.left = left;
            this.right = right;
        }

        @Override
        protected Long compute() {
            if(right - left <= threshold){
                for(int i = left; i <= right ; i++){
                    sum += i;
                }
            }else{
                int mid = (left + right) / 2;
                MyRecursive left = new MyRecursive(this.left,mid);
                left.fork();
                MyRecursive right = new MyRecursive(mid,this.right);

                right.fork();

                Long l = left.join();
                Long r = right.join();

                sum = l + r;
            }
            return sum;
        }
    }

    public static void main(String[] args) throws Throwable {
//        ForkJoinPool commonpool = new ForkJoinPool();
//        MyRecursive myRecursive = new MyRecursive(1,100);
//        ForkJoinTask<Long> result = commonpool.submit(myRecursive);
//        System.out.println(result.get());
//        commonpool.shutdown();
//        ForkJoinPool commonpool = new ForkJoinPool();
//        List<User> userList = new ArrayList<>();
//
//        for(int i = 0 ;i< 100;i++){
//            userList.add(new User());
//        }
//        UserRecursiveAction userRecursiveAction = new UserRecursiveAction(userList);
//        commonpool.submit(userRecursiveAction);
//        System.out.println(userList);
//        commonpool.shutdown();
//        System.out.println(sum(100));
//        fanxing<String,Integer> fanxin = new fanxing<>("1",1);
//        Object object = new String("11");
////        getPrintlnMH(object).invokeExact("avcc");
//        FileOutputStream out = new FileOutputStream("D:\\a.txt");
//        out.write(97);
//        out.close();
//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.add(1);
//        list.add(3);
//        list.add(4);
//        list.add(5);
//        list.add(6);
//        list.add(7);
//        list.add(8);
//        for(Integer temp : list){
//            if(temp.equals(1)){
//                list.remove(temp);
//            }
////            list.removeAll(list);
//        }
        System.out.println(TestStatic.date);
        System.out.println(TestStatic.date);
        System.out.println(TestStatic.date);
    }

    public static MethodHandle getPrintlnMH(Object reveiver) throws NoSuchMethodException, IllegalAccessException {
        MethodType mt = MethodType.methodType(void.class,String.class);
        return MethodHandles.lookup().findVirtual(reveiver.getClass(),"println",mt).bindTo(reveiver);
    }

    public static int sum(int n){
        if(n == 1){
            return 1;
        }
        return n+sum(n-1);
    }
    static class fanxing<S,D>{
        S data;
        D data2;

        public fanxing(S data, D data2) {
            this.data = data;
            this.data2 = data2;
        }

    }

}
