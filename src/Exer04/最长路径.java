package Exer04;

import java.util.Scanner;
import java.util.Stack;

/**
 * 题号41:最长路径
 * 城市 A 新建了 n 个座房子，城市规划处用 n−1 条双向街道将房子连在一起，使得任意两座房子之间有且仅有一条道路可达。小明和小红将被随机分到两个房子，现在小明想知道，他和小红房子的最长路径是多少。
 * 时间限制(ms)	内存限制(MB)	提交量	通过量	通过率
 * 3000	256	0	0	0%
 * 标准输入:
 * 7
 * 2,3,5,4,5,5
 * 5,2,1,6,7,4
 * 15,6,14,4,1,6
 */
class MainMaxLength {
    //存放顶点的栈
    private Stack<Integer> stack;
    private Edge[] edges;
    //存放最终结果
    private int finalResult = 0;
    //存储当前最长的长度
    private int result = 0;

    private MainMaxLength(int num) {
        //初始化变与顶点栈
        edges = new Edge[num];
        stack = new Stack<>();
    }

    //边
    static class Edge {
        private int from;
        private int to;
        private int weight;
        boolean label;

        Edge(int from, int to, int weight, boolean label) {
            this.from = from;
            this.to = to;
            this.weight = weight;
            this.label = label;
        }

        void setFrom(int from) {
            this.from = from;
        }

        void setTo(int to) {
            this.to = to;
        }

        void setWeight(int weight) {
            this.weight = weight;
        }

        int getFrom() {
            return from;
        }

        int getTo() {
            return to;
        }

        int getWeight() {
            return weight;
        }
    }

    private void process(int weight) {
        int tWeight = weight;
        while (!stack.isEmpty()) {
            int from = stack.peek();
            boolean findOne = false;

            for (int i = 0; i < edges.length; i++) {
                //起始点与栈顶点相同，并且该边未被访问
                if ((edges[i].getTo() == from||edges[i].getFrom() == from) && !edges[i].label) {
                    if(edges[i].getTo() == from) {
                        stack.push(edges[i].getFrom());
                    }else {
                        stack.push(edges[i].getTo());
                    }
                    //置访边edges[i]问标志,true;
                    edges[i].label = true;
                    //计算路径长度
                    result += edges[i].getWeight();
                    //置找到标志
                    findOne = true;
                    tWeight = edges[i].getWeight();
                    //跟当前最长路径比较
                    if (result > finalResult) {
                        finalResult = result;
                    }
                    //继续遍历
                    process(tWeight);
                }

            }
            if (!findOne) {
                stack.pop();
                result -= weight;
                break;
            }
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        String str1 = scanner.next();
        String str2 = scanner.next();
        String str3 = scanner.next();
        //处理数据
        String[] arrFrom = str1.split(",");
        String[] arrTo = str2.split(",");
        String[] arrLength = str3.split(",");

        MainMaxLength mainMaxLength = new MainMaxLength(n - 1);
        //处理数据
        for (int i = 0; i < n-1; i++) {
            mainMaxLength.edges[i] = new Edge(Integer.parseInt(arrFrom[i]), Integer.parseInt(arrTo[i]),
                    Integer.parseInt(arrLength[i]),
                    false);
        }
        //先把1号顶点入栈
        mainMaxLength.stack.push(1);
        //遍历开始
        mainMaxLength.process(0);

        System.out.println(mainMaxLength.finalResult);
    }
}
