import java.io.IOException;
import java.util.Random;
import java.util.Scanner;


public class BarberingShop {

    public static void main(String[] args) throws IOException {

        Operation operation = new Operation();
        operation.printHeader();

        Queue queue = new Queue();
        String input = "";
        while (input.isEmpty()){
            input = new Scanner(System.in).nextLine();
            int rand = operation.generateNumber();

            queue.addClient(new Node(rand));
            operation.printEvent(rand ,null,queue.isFull());
            queue.print();
        }

    }
}

