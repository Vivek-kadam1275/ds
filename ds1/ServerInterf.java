import java.rmi.*;

// Extends Remote class so we can use this methods remotely.
 interface ServerInterf extends Remote{

    public double addition(double a,double b) throws RemoteException; // this methods can throm remoteexception
    public double substraction(double a,double b) throws RemoteException;

    public double multiplication(double a,double b) throws RemoteException;

    public double division(double a,double b) throws RemoteException;


    
}