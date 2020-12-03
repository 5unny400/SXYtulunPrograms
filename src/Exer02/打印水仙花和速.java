package Exer02;

class Main3 {
    private int begin;
    private int end;

    private Main3(int begin,int end){
        this.begin = begin;
        this.end = end;
    }

    private void print(){
        for(int i =begin;i<end;i++){
            if(juge(i)){
                System.out.println(i);
            }
        }
    }

    private boolean juge(int x){
        if(x<100){
            return false;
        }

        int result = 0;
        int tmp = 0;
        int xnum = x;
        while(x != 0){
            tmp = x%10;
            result = (int) (result + Math.pow(tmp,3));
            x = x/10;
        }
        return result == xnum;
    }

    public static void main(String[] args) {
        Main3 main3 = new Main3(100,1000);
        main3.print();
    }
}
