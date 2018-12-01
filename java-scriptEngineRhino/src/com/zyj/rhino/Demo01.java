package com.zyj.rhino;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileReader;
import java.net.URL;
import java.util.List;

/**
 * 版权声明：CopyRight (c) 2018 ucarinc. All Rights Reserved.
 *
 * @author : 张勇杰
 * @date : 2018/11/28 12:52
 * @Version : v1.0
 * @description 测试脚本引擎执行javascript代码
 **/
public class Demo01 {
    public static void main(String[] args) throws Exception {
        //获得脚本引擎对象
        ScriptEngineManager sem = new ScriptEngineManager();
        ScriptEngine engine = sem.getEngineByName("javascript");

        //定义变量,存储到引擎上下文
        engine.put("msg","zhangyongjie is a good man!");
        String str = "var user = {name:'zhangyongjie',age:18,schools:['诸暨中学','温州大学']};";
        str += "print(user.name);";

        //执行脚本
        engine.eval(str);
        engine.eval("msg = 'sxt is a bad school';");
        System.out.println(engine.get("msg"));

        System.out.println("*************************");
        //定义函数
        engine.eval("function add(a,b){var sum = a+b; return sum;}");
        //取得调用接口
        Invocable jsInvoke = (Invocable) engine;
        //执行脚本中定义的方法
        Object obj = jsInvoke.invokeFunction("add",1,2);
        System.out.println(obj);

        //导入其他java包，使用其他保重的java类
        //java1.8之后要这么写。
        String jsCode = "var list = java.util.Arrays.asList(\"温州大学\",\"诸暨中学\")";
        engine.eval(jsCode);
        List<String> list = (List<String>) engine.get("list");
        for(String a:list){
            System.out.println(a);
        }

        //执行一个js文件（将a.js置于项目的src下即可
        URL url = Demo01.class.getClassLoader().getResource("a.js");
        System.out.println(url);
        FileReader fr = new FileReader(url.getPath());
        engine.eval(fr);
        fr.close();
    }
}
