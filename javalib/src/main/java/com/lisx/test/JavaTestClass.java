package com.lisx.test;

import java.util.HashMap;
import java.util.Map;

public class JavaTestClass {


    public static void main(String[] args) {

        //System.out.println("你好，Java");
        //testMap();
        testEnum();
    }

    /**
     * 测试enum类的输出类型
     */
    private static void testEnum(){
        RemindType rt = RemindType.ALL;

        System.out.println("rt:" + rt);
        System.out.println("rt.getType:" + rt.getType());
        System.out.println("rt.equals(0):" + rt.equals(0));
        System.out.println("rt.getType(0):" + rt.getType(0));
/*      rt:ALL
        rt.getType:0
        rt.equals(0):false
        rt.getType(0):ALL*/

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

    /**
     * Created by lisx on 18-4-27.
     * <p>
     * 提醒的类型
     */
    public static enum RemindType {
        UNKNOW(-1),
        ALL(0),
        BIRTHDAY(1),
        ANNIVERSARY(2),
        COUNTDOWN(3);
        private int type;

        RemindType(int type) {
            this.type = type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getType() {
            return type;
        }

        public static RemindType getType(int num) {
            RemindType type = UNKNOW;
            switch (num) {
                case 0:
                    type = ALL;
                    break;
                case 1:
                    type = BIRTHDAY;
                    break;
                case 2:
                    type = ANNIVERSARY;
                    break;
                case 3:
                    type = COUNTDOWN;
                    break;
            }
            return type;
        }
    }
}
