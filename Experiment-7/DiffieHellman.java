import java.math.BigInteger;
import java.util.*;

public class DiffieHellman {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("==== Diffie-Hellman Key Exchange ====");

        BigInteger p = BigInteger.valueOf(23);
        BigInteger g = BigInteger.valueOf(5);

        System.out.println("Public Prime (p) : " + p);
        System.out.println("Public Generator (g) : " + g);

        // Private keys
        System.out.print("\nEnter Alice's private key: ");
        BigInteger a = sc.nextBigInteger();

        System.out.print("Enter Bob's private key: ");
        BigInteger b = sc.nextBigInteger();

        // Alice calculates public key
        BigInteger A = g.modPow(a, p);

        // Bob calculates public key
        BigInteger B = g.modPow(b, p);

        System.out.println("\nAlice's public key : " + A);
        System.out.println("Bob's public key : " + B);

        // Shared secret calculated by Alice
        BigInteger secretAlice = B.modPow(a, p);

        // Shared secret calculated by Bob
        BigInteger secretBob = A.modPow(b, p);

        System.out.println("\n==== Shared Secret ====");
        System.out.println("Alice's shared secret : " + secretAlice);
        System.out.println("Bob's shared secret : " + secretBob);

        // Verify shared secret
        if (secretAlice.equals(secretBob)) {
            System.out.println("\nKey Exchange Successful!");
            System.out.println("Both Alice and Bob have the same secret key.");
        } else {
            System.out.println("\nKey Exchange Failed!");
        }

        sc.close();
    }
}

    //           DIFFIE-HELLMAN KEY EXCHANGE

    //                 Public Values
    //                p = 23, g = 5
    //                      |
    //           +----------+----------+
    //           |                     |
    //        ALICE                   BOB
    //           |                     |
    //     Private Key = 6       Private Key = 15
    //           |                     |
    //           ↓                     ↓
    //     A = 5^6 mod 23        B = 5^15 mod 23
    //           |                     |
    //           ↓                     ↓
    //      Public Key = 8        Public Key = 19
    //           |                     |
    //           |------ Exchange -----|
    //           |                     |
    //           ↓                     ↓
    //    Receive B = 19          Receive A = 8
    //           |                     |
    //           ↓                     ↓
    //    19^6 mod 23             8^15 mod 23
    //           |                     |
    //           ↓                     ↓
    //       Secret = 2             Secret = 2
    //           |                     |
    //           +----------+----------+
    //                      |
    //                 SAME SECRET
    //                      |
    //            Key Exchange Successful