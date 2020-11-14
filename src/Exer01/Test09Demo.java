package Exer01;

/**
 * 最长公共子序列问题。
 * 已知序列X=（A，B，C，A，B，D，A）和序列Y=（B，A，D，B，A）
 * 求它们的最长公共子序列S
 * @author 光
 */
public class Test09Demo {

    /**
     * 获得矩阵dp
     * 		dp矩阵最右下角的值为两个序列的最长公共子序列的长度
     * @param str1
     * @param str2
     * @return
     */
    public int[][] get_dp(char[] str1, char[] str2) {
        int[][] dp = new int[str1.length][str2.length];
        dp[0][0] = str1[0]==str2[0] ? 1 : 0 ;
        for (int i = 1; i < str1.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], str1[i]==str2[0] ? 1:0);
        }
        for (int j = 1; j < str2.length; j++) {
            dp[0][j] = Math.max(dp[0][j-1], str1[0]==str2[j] ? 1:0);
        }
        for (int i = 1; i < str1.length; i++) {
            for (int j = 1; j < str2.length; j++) {
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                if (str1[i]==str2[j]) {
                    dp[i][j] = Math.max(dp[i][j],dp[i-1][j-1]+1);
                }
            }
        }
        return dp;
    }
    /**
     * 通过dp矩阵求解最长公共子序列的过程
     * 		就是还原出当时如何求解dp的过程，
     * 		来自哪个方向的策略就朝哪个方向移动
     * @param s1
     * @param s2
     * @return
     */
    public String lcse(String s1,String s2){
        if(s1==null||s2==null||s1.equals("")||s2.equals("")){
            return "";
        }
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int[][] dp = get_dp(c1, c2);
        int m =c1.length-1;
        int n =c2.length-1;
        char[] result = new char[dp[m][n]];
        int index = result.length-1;
        while(index>=0){
            if(n>0 && dp[m][n] == dp[m][n-1]){//向左移动
                n--;
            }else if (m>0 && dp[m][n]==dp[m-1][n]) {//向上移动
                m--;
            }else{//向左上方移动
                result[index--]=c1[m];
                m--;
                n--;
            }
        }
        return String.valueOf(result);
    }

    public static void main(String[] args) {
        String str1 = "ABCABDA";
        String str2 = "BADBA";
        Test09Demo l = new Test09Demo();
        System.out.println(l.lcse(str1,str2));
    }
}
