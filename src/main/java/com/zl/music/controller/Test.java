package com.zl.music.controller;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test {

    public static void main(String[] args) {
//        String s = "[{\"id\":2,\"alarmTypeName\":\"水管压力0\",\"alarmTypeCode\":\"WHATER\",\"parentId\":0,\"dataType\":0,\"unit\":\"pa0\",\"remark\":\"水管压力超过60报警0\",\"floor\":0,\"subList\":[],\"scopedSlots\":{\"title\":\"operation\"}},{\"id\":7,\"alarmTypeName\":\"麦克风告警\",\"alarmTypeCode\":\"MIC\",\"parentId\":0,\"dataType\":0,\"unit\":\"o\",\"remark\":\"\",\"floor\":0,\"subList\":[],\"scopedSlots\":{\"title\":\"operation\"}},{\"id\":8,\"alarmTypeName\":\"表记异常\",\"alarmTypeCode\":\"--\",\"parentId\":0,\"dataType\":0,\"unit\":\"--\",\"remark\":\"\",\"floor\":0,\"subList\":[{\"id\":9,\"alarmTypeName\":\"温度报警\",\"alarmTypeCode\":\"over\",\"parentId\":8,\"dataType\":1,\"unit\":\"℃\",\"remark\":\"\",\"floor\":1,\"subList\":[],\"scopedSlots\":{\"title\":\"operation\"}}],\"scopedSlots\":{\"title\":\"operation\"}}]";
//        JSONArray array = JSONArray.fromObject(s);
//        System.out.println(Test.test(array));
//        System.out.println(getNum(6));
        String s = "adc";
        int i = s.hashCode();
        System.out.println(i);
//        List<Integer> list = new ArrayList<>();
//        list.add(2);
//        list.add(4);
//        list.add(3);
//        list.add(5);
//        list.add(1);
//        list.add(6);
//        Iterator<Integer> it = list.iterator();
//        while(it.hasNext()){
//            Integer x = it.next();
//            if(x%2==0){
//                it.remove();
//            }
//        }
////        for (int i = 0; i <list.size() ; i++) {
////            if (list.get(i)%2==0){
////                list.remove(i);
////            }
////        }
//        System.out.println(list);

    }

    public static JSONObject test(JSONArray array){
        JSONObject data = new JSONObject();
        for (int i = 0; i < array.size(); i++) {
            if (array.getJSONObject(i).getInt("id")==9){
                data = array.getJSONObject(i);
                return data;
            }
            if (array.getJSONObject(i).getJSONArray("subList").size()!=0){
                return test(array.getJSONObject(i).getJSONArray("subList"));
            }
        }
        return data;
    }

    public static int getNum(int n ){
        if (n==1 || n==2){
            return 1;
        }
        return getNum(n-1)+getNum(n-2);
    }
}


