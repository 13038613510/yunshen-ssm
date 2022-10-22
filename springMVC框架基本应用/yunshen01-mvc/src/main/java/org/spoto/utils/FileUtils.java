package org.spoto.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 文件工具类
 */
public class FileUtils {



    public static boolean save(String path,String data){
        return save(path, data, true);
    }
    /**
     * 文件保存
     * @param path 文件保存的路径
     * @param data 文件保存的数据
     * @param append 是否添加
     * @return  文件保存的结果
     */
    public static boolean save(String path,String data,boolean append){
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        try {
            fos = new FileOutputStream(path,append);//append不会覆盖原来的文件,往后添加
            //缓冲流
            bos = new BufferedOutputStream(fos);
            bos.write(data.getBytes());
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (bos != null){
                try {
                    bos.close();
                }catch (Exception e1){
                    e1.printStackTrace();
                }
            }
            if (fos != null){
                try {
                    fos.close();
                }catch (Exception e2){
                    e2.printStackTrace();
                }
            }
        }
        return false;
    }



    /**
     * 获取文件内容
     * @param path 文件路径
     * @return 文件内容
     */
    public static List<String> get(String path){
        List<String> dataList = new ArrayList<>();
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(path);
            br = new BufferedReader(fr);

            String line = "";
            while ((line = br.readLine()) != null){//br每次读一行赋值到line
                //空行的处理
                if ("".equals(line)){
                    continue;
                }
                //非空行
                dataList.add(line);
            }
            return dataList;
        }catch (Exception e1){
            e1.printStackTrace();
        }finally {
            if (br != null){
                try {
                    br.close();
                }catch (Exception e1){
                    e1.printStackTrace();
                }
            }
            if (fr != null){
                try {
                    fr.close();
                }catch (Exception e2){
                    e2.printStackTrace();
                }
            }
        }
        return null;
    }


    /**
     * 文件复制
     * @param src 源头文件
     * @param target 目标文件
     * @return 复制结果
     */
    public static boolean copy(String src,String target){
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        try {
            //读文件
            fis = new FileInputStream(src);
            bis = new BufferedInputStream(fis);
            //写文件
            fos = new FileOutputStream(target);
            bos = new BufferedOutputStream(fos);
            //一点一点读，一点一点写
            byte[] b = new byte[1024];
            int num = 0;
            while ((num = bis.read(b)) != -1){
                bos.write(b,0,num);
            }
            return true;
        }catch (Exception e){

//            e.printStackTrace();

            System.out.println("文件复制异常");
        }finally {
            if (bos != null)
                try {
                    bos.close();
                }catch (Exception e1){
                    e1.printStackTrace();
                    System.out.println("关闭失败");
                }
            if (fos != null){
                try {
                    fos.close();
                }catch (Exception e2){
                    e2.printStackTrace();
                    System.out.println("关闭失败");
                }
            }
            if (bis != null){
                try {
                    bis.close();
                }catch (Exception e3){
                    e3.printStackTrace();
                    System.out.println("关闭失败");
                }
            }
            if (fis != null){
                try {
                    fis.close();
                }catch (Exception e4){
                    e4.printStackTrace();
                    System.out.println("关闭失败");
                }
            }
        }
        return false;
    }


}
