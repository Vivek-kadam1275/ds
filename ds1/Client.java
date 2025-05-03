// import java.rmi.*;
// import java.util.Scanner;
// public class Client {

//     public static void main(String[] args) {
//         try {
//             Scanner sc=new Scanner(System.in);
//             String serverUrl="rmi://localhost/Server";
//             ServerInterf serverInterf=(ServerInterf) Naming.lookup(serverUrl);
//             System.out.println("Enter first number");
//             double a=sc.nextDouble();
//             System.out.println("Enter second number");
//             double b=sc.nextDouble();
//             System.out.println("***************************************");
//             System.out.println("addition is-"+serverInterf.addition(a, b));
//             System.out.println("substraction is-"+serverInterf.substraction(a, b));
            
//         } catch (Exception e) {
//             // TODO: handle exception
//             System.out.println("exception"+e.getMessage());

//         }
//     }
// }

import java.rmi.*;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            String serverUrl = "rmi://localhost/Server"; // rmiregistry url to get object
            ServerInterf serverInterf = (ServerInterf) Naming.lookup(serverUrl); // get object from rmi registry

            // Getting input from the user
            System.out.println("Enter first number");
            double a = sc.nextDouble();
            System.out.println("Enter second number");
            double b = sc.nextDouble();

            // Creating threads to call methods concurrently
            Thread additionThread = new Thread(() -> { // lambda function
                try {
                    System.out.println("Addition is" + serverInterf.addition(a, b));
                } catch (RemoteException e) {
                    System.out.println("Addition exception: " + e.getMessage());
                }
            });

            Thread subtractionThread = new Thread(() -> {
                try {
                    System.out.println("Subtraction is" + serverInterf.substraction(a, b));
                } catch (RemoteException e) {
                    System.out.println("Subtraction exception: " + e.getMessage());
                }
            });

            // Start both threads
            additionThread.start();
            subtractionThread.start();

            // Wait for both threads to finish
            additionThread.join();
            subtractionThread.join();

        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
