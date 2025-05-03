import java.rmi.*;

import java.rmi.server.*;// It consists UnicastRemoteObject: which used to define that this methods can be accessed till server is running
public class ServerImpl extends UnicastRemoteObject implements ServerInterf  {

    public ServerImpl() throws RemoteException{
        super();
    }
    public double addition(double a,double b) throws RemoteException{
        System.out.println("Addition request handled by: " + Thread.currentThread().getName());
        return a+b;
    }
    public double substraction(double a,double b) throws RemoteException{
        System.out.println("Subtraction request handled by: " + Thread.currentThread().getName());

        return a-b;
    }
    public double multiplication(double a,double b) throws RemoteException{
        System.out.println("Multiplication request handled by: " + Thread.currentThread().getName());

        return a*b;
    }
    public double division(double a,double b) throws RemoteException{
        if(b==0){
            return -1;
        }
        System.out.println("Division request handled by: " + Thread.currentThread().getName());

        return a/b;
    }
     
    // public int square(int a) throws RemoteException {
    //     return a * a;
    // }
    // public int squareroot(int a) throws RemoteException {
    //     return (int) (Math.sqrt(a));
    // }

    // public void palindrome(String str) throws RemoteException {
    //     StringBuilder sb = new StringBuilder(str);
    //     sb.reverse();

    //     if (str.equals(sb.toString()))
    //         System.out.println("String is Palindrome!");
    //     else
    //         System.out.println("String is Not Palindrome!");

    // }

    // public void isequalstring(String str1, String str2) throws RemoteException {
    //     if (str1.equals(str2))
    //         System.out.println("String is equal!");
    //     else
    //         System.out.println("String is not equal!");
    // }
}