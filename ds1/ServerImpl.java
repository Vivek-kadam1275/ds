import java.rmi.*;

import java.rmi.server.*;// It consists UnicastRemoteObject: which used to define that this methods can be accessed till server is running
public class ServerImpl extends UnicastRemoteObject implements ServerInterf  {

    public ServerImpl() throws RemoteException{

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
     
}