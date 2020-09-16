import java.util.Random;
import java.util.Scanner;

class Operation {
    Queue queue = new Queue();
    public void printHeader() {
        System.out.println("   x           Events                           state of the shop");
        System.out.println("+-------+------------------+-------------------------------------------------------------+");
    }

    public Boolean simulate() {
        String input = new Scanner(System.in).nextLine();
        return input.equals(" ");
    }

    public int generateNumber() {
        return new Random().nextInt(4);
    }

    public void printEvent(int x , Node node , boolean isFull) {
        String outPutString = "";
        if (isFull && x > 0){
            outPutString = x+"--->  (  +- client  )";
        }

        if (x == 0){
            outPutString = x+"--->  (  -- client  )";
        }else if(x == 1){
            outPutString = x+" ---> (  ++ VIP"+Node.LAST_VIP_INDEX+1+"  )";
        }else if (x == 2 || x == 3){
            outPutString = x+" ---> (  ++ ORD"+Node.LAST_ORD_INDEX+1+"  )";
        }
        System.out.print(outPutString);
    }
}
