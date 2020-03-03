import java.util.Scanner;
public class Main {

    public static void main(String[] args){
        MyCurrentDate[] array = new MyCurrentDate[3];
        MyCurrentDate mcd;
        Scanner sc = new Scanner(System.in);

        for(int i=0; i<3; i++){
            mcd = new MyCurrentDate(i);
            array[i] = mcd;
            mcd.start();
        }
        boolean stop = true;
        int toKill;
        for(int x = 0; x< 3; x++){
           try{
               Thread.sleep(3000);
               array[x].setFlag(false);
               System.out.println("Killed thread #" + x);
           }catch(Exception e){}
       }

    }
}
