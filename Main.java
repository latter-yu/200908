import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main1(String[] args) {

        // 携程客户下单的时候系统会发放一个优惠券码，用户在前端界面看到的展现形式如下：
        // “1Ct3r4ip_ti4C6k9Et^”，包含数字、字母、和 [\]^_’ 6个特殊字符。
        // 为了安全性，系统在使用的时候做解密操作，删除里面的数字部分
        // 只验字母A~z以及[\]^_’ 6个特殊字符部分才是有效的
        // 并且在解密后不会重新排序字母的顺序，按照之前的对应顺序排列。

        // 如上所示，如果一个客户拿到的优惠券码是这个：1Ct3r4ip_ti4C6k9Et^
        // 请用java语言提取正确的优惠券码。

        // 输入描述:
        // 1Ct3r4ip_ti4C6k9Et^
        // 输出描述:
        // Ctrip_tiCkEt^

        // 示例:
        // 输入
        // 1Ct3r4ip_ti4C6k9Et^
        // 输出
        // Ctrip_tiCkEt^

        // ps: 出现 '$', 需要换成 '^'

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.next();
            char[] chars = str.toCharArray();
            List<Character> list = new LinkedList<>();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] < '0' || chars[i] > '9') {
                    if (chars[i] == '$') {
                        list.add('^');
                    } else {
                        list.add(chars[i]);
                    }
                }
            }
            for (char l : list) {
                System.out.print(l);
            }
        }
    }

    public String ReverseSentence(String str) {

        // 牛客最近来了一个新员工Fish每天早晨总是会拿着一本英文杂志，写些句子在本子上。
        // 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
        // 例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了
        // 正确的句子应该是“I am a student.”。
        // Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
        
        String[] strArr = str.split(" ");
        if (strArr.length == 0 || strArr.length == 1) {
            return str;
        }
        String s = strArr[strArr.length - 1] + " ";
        for (int i = strArr.length - 2; i > 0; i--) {
            s += strArr[i] + " ";
        }
        s += strArr[0];
        return s;
    }
}
