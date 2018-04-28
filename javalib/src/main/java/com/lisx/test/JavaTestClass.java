package com.lisx.test;

import java.util.HashMap;
import java.util.Map;

public class JavaTestClass {


    public static void main(String[] args) {

        //System.out.println("你好，Java");
        testMap();

    }

    private static void testMap() {

        Map persionMap = new HashMap<Object, Map<String, String>>();

        Map html = new HashMap<String, String>();
        html.put("HTML5", "前端工程师");
        Map java = new HashMap<String, String>();
        java.put("JAVA", "JAVA工程师");
        Map architect = new HashMap<String, String>();
        architect.put("ARCH", "系统架构师");

        persionMap.put("小云", html);
        persionMap.put("小端", java);
        persionMap.put("小微", java);
        persionMap.put("小华", architect);

        for (Object key : persionMap.keySet()) {//由于set没有顺序,其输出顺序跟添加顺序可能不一致
            String str = key + ": ";//例:小云
            Map<String, String> map = (Map<String, String>) persionMap.get(key);
            for (Map.Entry<String, String> entry : map.entrySet()) {
                str += entry.getValue();//例:前端工程师
                str += entry.getKey();//例:HTML5
                System.out.println(str);
/*                输出如下:
                小微: JAVA工程师JAVA
                小华: 系统架构师ARCH
                小云: 前端工程师HTML5
                小端: JAVA工程师JAVA*/
            }
        }
    }

}
