package day13;

/**
 * Created by deng on 17/11/5.
 * 1，模拟一个trim方法，去除字符串两端的空格。
 *   思路：
 *   1，判断字符串第一个位置是否是空格，如果是继续向下判断，直到不是空格为止。结尾处空格也是如此
 *   2，当开始和结尾都判断到不是空格时，就是要获取的字符串。
 *
 * 2，将一个字符串进行反转。将字符串中指定部分进行反转，"abcdefg";"abfedcg"
 *   思路：
 *   1、将字符串转换成数组
 *   2、将数组进行反转
 *   3、将数组转换成字符串
 *
 * 3，获取一个字符串在另一个字符串中出现的次数."abkkcdkkefkkskk"
 *   思路：
 *   1，定义个计数器
 *   2，获取kk第一次出现的位置
 *   3，从第一次出现位置后剩余的字符串中继续获取kk出现的位置，每获取异常就计数一次
 *   4，获取不到时计数完成。
 *
 * 4，获取两个字符串中最大相同子串。第一个动作：将短的那个串进行长度依次递减的子串打印。
 *    "abcwerthelloyuiodef"
 *    "cvhellobnm"
 *    思路：
 *    1，将短的那个子串按照长度递减的方式获取到
 *    2，将每获取到的子串去长串中判断是否包含，如果包含，已经找到！。
 */
public class StringTest {

    //练习4

    public static String getMaxSubString(String s1, String s2){
        String max = "",min="";
        max = s1.length()>s2.length()?s1:s2;
        min = (max==s1)?s2:s1;

//        sop("max="+max+"...min="+min);

        for (int x=0; x<min.length(); x++){
            for (int y=0,z=min.length()-x; z!=min.length()+1; y++,z++){
                String temp = min.substring(y, z);

//                sop(temp);
                if (max.contains(temp)) //if(max.indexOf(temp)!=-1)
                    return temp;
            }
        }
        return "";

    }

    //练习3：方式一
    public static int getSubCount(String s, String key){
        int count=0;
        int index=0;
        sop("s="+s);
        while ((index=s.indexOf(key))!=-1){
            s = s.substring(index+key.length());
            sop("s="+s);

            count++;
        }
        return count;
    }

    //练习3：方式二
    public static int getSubCount_2(String s, String key){
        int count=0;
        int index=0;
        while ((index=s.indexOf(key,index))!=-1){
            sop("index="+index);
            index = index + key.length();

            count++;
        }
        return count;
    }



    //练习2：字符串反转
    public static String reverseString(String s){
        return reverseString(s,0,s.length());
    }

    public static String reverseString(String s,int fromIndex, int endIndex){
        //字符串变数组
        char[] chs = s.toCharArray();

        //反转数组。
        reverse(chs,fromIndex,endIndex);

        //将数组变成字符串
        return new String(chs);
    }

    private  static void reverse(char[] arr,int x,int y){
        for (int start=x,end=y-1;start<end;start++,end--)
            swap(arr,start,end);
    }
    private static void swap(char[] arr, int x, int y){
        char temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;

    }
    //练习1：模拟字符串trim
    public static String myTrim(String str){
        int start = 0,end=str.length()-1;

        while (start<=end && str.charAt(start)==' ')
            start++;
        while (start<=end && str.charAt(end)==' ')
            end--;

        return str.substring(start, end+1);
    }
    public static void main(String[] args){
//        String s = "   ab cd    ";
//        sop("("+s+")");
////        s = myTrim(s);
////        sop("("+s+")");
//        s = reverseString(s,6,8);
//        sop("("+s+")");
//        s = reverseString(s);
//        sop("("+s+")");


//        String s = "kkabkkcdkkefkks";
//        String[] arr = s.split("kk");
//        for (String i:arr) {
//             sop(i);
//        }
        
//        sop("count=="+s.split("kk").length);  //不建议使用，不准 ，以kk开头的话，切出来的第一个字符串是空字符串" "
//        sop("count="+getSubCount(s,"kk"));
//        sop("count="+getSubCount_2(s,"kk"));

        String s1 = "abcwerthelloyuiodef";
        String s2 = "cvhellobnm";

        sop(getMaxSubString(s1,s2));


    }

    public static void sop(Object obj){
        System.out.println(obj);
    }
}
