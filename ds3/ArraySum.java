// Import the MPI library
import mpi.*;

public class ArraySum {
    public static void main(String[] args) throws Exception {
        // Initialize the MPI execution environment
        MPI.Init(args);

        // Get the rank (ID) of the current process
        int rank = MPI.COMM_WORLD.Rank();

        // Get the total number of processes
        int size = MPI.COMM_WORLD.Size();

        // Total number of elements in the array
        int N = 12;

        // Divide the array equally among all processes
        int chunkSize = N / size;

        // Declare the full array (only rank 0 will use it)
        int[] data = new int[N];

        // Each process will store its part of the array in this local array
        int[] localData = new int[chunkSize];

        // Initialize the array in the root process (rank 0)
        if (rank == 0) {
            // Fill the array with values from 1 to N (you can change to random values too)
            for (int i = 0; i < N; i++) {
                data[i] = i + 1;
            }

            // Display the original full array
            System.out.print("Original Array: ");
            for (int i = 0; i < N; i++) {
                System.out.print(data[i] + " ");
            }
            System.out.println("\n");
        }

        // Scatter the data array from root process to all processes
        // Each process receives chunkSize elements in localData
        MPI.COMM_WORLD.Scatter(
            data,      // send buffer (from root)
            0,         // offset in send buffer
            chunkSize, // number of elements each process gets
            MPI.INT,   // data type
            localData, // receive buffer for each process
            0,         // offset in receive buffer
            chunkSize, // number of elements to receive
            MPI.INT,   // data type
            0          // root process that sends data
        );

        // Print the chunk received by each process
        System.out.print("Process " + rank + " received chunk: ");
        for (int i = 0; i < chunkSize; i++) {
            System.out.print(localData[i] + " ");
        }
        System.out.println();

        // Each process calculates the sum of its local data
        int localSum = 0;
        for (int i = 0; i < chunkSize; i++) {
            localSum += localData[i];
        }

        // Display the local sum calculated by the current process
        System.out.println("Process " + rank + ": local sum = " + localSum);

        // This array will hold the final sum in the root process
        int[] totalSum = new int[1];

        // Reduce: combine local sums into total sum at the root (rank 0) using SUM operation
        MPI.COMM_WORLD.Reduce(
            new int[] { localSum }, // send buffer from each process
            0,                      // offset in send buffer
            totalSum,               // receive buffer at root
            0,                      // offset in receive buffer
            1,                      // number of elements
            MPI.INT,                // data type
            MPI.SUM,                // operation to perform (sum)
            0                       // root process
        );

        // Root process prints the total sum
        if (rank == 0) {
            System.out.println("\nTotal sum = " + totalSum[0]);
        }

        // Finalize the MPI environment (must be called at the end)
        MPI.Finalize();
    }
}
