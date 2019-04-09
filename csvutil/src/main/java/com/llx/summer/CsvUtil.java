package com.llx.summer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Auther: sharps
 * @Date: 19-4-3 09:13
 * @Description: CSV操作（读取和写入）
 */
public class CsvUtil {


    public static void main(String[] args) throws Exception{
        String jh = "K--123-哈哈lk";
        String regEx="[^0-9-]";
        Pattern p=Pattern.compile(regEx);
        Matcher m=p.matcher(jh);
        String result=m.replaceAll("").trim();
        System.out.println(result);
        if(result!=null&&!result.isEmpty()) {
            Character ch = result.charAt(0);
            System.out.println(ch);
            int index = jh.indexOf(ch);
            String jm = jh.substring(0, index);
            System.out.println("井名前缀：" + jm);
            String bh = jh.substring(index);
            System.out.println("井名编号：" + bh);
        }else{
            String jm = jh;
            System.out.println("井名前缀：" + jm);

            System.out.println("井名编号：" );
        }
    }


}
