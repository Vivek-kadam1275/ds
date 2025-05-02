import java.rmi.*;
public class Server {

    public static void main(String[] args) {
        
      try {
        ServerImpl serverImpl=new ServerImpl(); //create instance of imple so we can add it in rmi registry.
        Naming.rebind("Server", serverImpl);// adding to rmi registry with name Server so that can be accessed in client.
        System.out.println("Server is ready...");
      } catch (Exception e) {
        // TODO: handle exception
        System.out.println("exception"+e.getMessage());
      }
    }
}