import java.util.*;
public class TokenRing{
    public static void main (String[] args){
        Scanner sc=new Scanner(System.in);
        
        System.out.println("Enter the number of nodes in token ring ");
        int n=sc.nextInt();

        System.out.println("Ring formed is as below:");
        for(int i=0;i<n;i++){
            System.out.print(i+" ");
        }
        System.out.println("0");

        int choice=0;

        do{
            System.out.println("Enter the sender");
            int sender=sc.nextInt();
           
            System.out.println("Enter the reciever");
            int reciever=sc.nextInt();
            System.out.println("Enter data to send");
            int data=sc.nextInt();
            if(sender>=n || reciever>= n){
                System.out.println("You have entered wrong inputs");
                choice=1;
                continue;
            }
            int token=0;
            System.out.println("Initially token is at -> "+token);

            System.out.println("token is passing to sender :");

            for(int i=0;i<sender;i++){
                System.out.print(i+" -> ");
            }
            System.out.println(sender);

            for(int i=sender;i!=reciever;i=(i+1)%n){
                System.out.println("Data is forwarding from "+i+" -> "+((i+1)%n));;
            }
            System.out.println("finally data is recieved by reciever "+reciever);

            System.out.println("Do you want to repeat:");
            choice=sc.nextInt();

        }while(choice==1);

    }
}