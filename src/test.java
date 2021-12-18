import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class test {

    public static void main(String[] args){
        String fullFilePath = "D:\\java code\\编译原理考试\\1.txt";
        List<String> ans = new ArrayList<>();
        StringBuilder result = new StringBuilder();
        try {
            File file = new File(fullFilePath);
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                ans.add(line);
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        int length = ans.size();
//        System.out.println(result);
        System.out.println(ans);
        System.out.println(length);

        List<Integer> x1 = new ArrayList<>();
        List<Integer> x3 = new ArrayList<>();
        for(int i=0;i<ans.size();i++){
            if(ans.get(i).contains("if")){
                x1.add(i+1);
            }
            if(ans.get(i).contains("goto")){
                String  s = ans.get(i);
                int l1 = (s.lastIndexOf("("));
                String x = s.substring(l1+1, s.length()-1);
                System.out.println(x);
                if(!x3.contains(Integer.parseInt(x))){
                    x3.add(Integer.parseInt(x));//parseInt是将String型转换为int类型
                }
                }
            }
        System.out.println("这是出现if转移语句的序号"+x1);
        System.out.println("这是goto的入口语句的序号"+x3);
        List<Integer> x2 = new ArrayList<>(x3);
        x2.add(1);
        for(int i:x1){
            int xx = i+1;
            if(!x2.contains(xx)){
                x2.add(xx);
            }
        }
        for(int i:x3){
            int xx = i-1;
            if(!x1.contains(xx)){
                x1.add(xx);
            }
        }
        x1.add(length);
        Collections.sort(x2);//对列表排序的方法
        Collections.sort(x1);
        System.out.println("开始语句"+x2);
        System.out.println("结束语句"+x1);
        int count=0;
        for(int i=0;i<x1.size();i++){
            System.out.println("这是第"+(i+1)+"个基本块");
            for(int j=x2.get(i)-1;j<x1.get(i);j++){
                System.out.println(ans.get(j));
            }
        }
    }
}


