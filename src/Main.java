import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
    }

    public Main(){
        System.out.println("Choose universe type to generate.");
        System.out.println("1 for infinite divergent universe");
        System.out.println("2 for infinite convergent universe");
        Scanner bobo = new Scanner(System.in);
        String choice = bobo.nextLine();
        if (choice.equals("1")){
            RunInfDiv();
        }else if (choice.equals("2")){
            //
            RunInfConv();
        }else{
            System.out.println("choose again");
        }
    }


    public void RunInfDiv(){
        InfiniteDivergentUniverse iDU = new InfiniteDivergentUniverse(1000, 0, 3, 1);
    }

    public void RunInfConv(){
        InfiniteConvergentUniverse iCU = new InfiniteConvergentUniverse();
    }




}
