package com.asher.learn.jvm;

/**
 *
 * @author : 张勇杰
 * @date : 2019/3/11 10:58
 * @Version : v1.0
 * @description
 * VM Args: -Xss 128K
 **/
public class StackLeafOOF {
    private int stackLength = 1;
    private void stackLeaf() {
        stackLength++;
        stackLeaf();
    }

    public static void main(String[] args) {
        StackLeafOOF oof = new StackLeafOOF();
        try {
            oof.stackLeaf();
        }catch (Throwable e){
            System.out.println("stack length:"+oof.stackLength);
            throw e;
        }
    }


}
