package me.guyl.paillier;

import java.math.BigInteger;

/**
 * Created by Guyl Bastien on 03/01/2017.
 */
public class Main {
    public static void main(String[] args){
        Paillier alice = Paillier.KeyGeneration(), bob = Paillier.KeyGeneration();
        BigInteger message = new BigInteger("5");
        BigInteger cyphertext = alice.Encryption(message, bob.getPk());
        System.out.println("Alice encrypt : "+message);
        System.out.println("Bob decrypt   : "+bob.Decryption(cyphertext));

        BigInteger m1 = new BigInteger("5"), m2 = new BigInteger("10");
        BigInteger c1 = alice.Encryption(m1, bob.getPk()), c2 = alice.Encryption(m2, bob.getPk());
        BigInteger c3 = c1.multiply(c2);
        System.out.println("Alice encrypt : "+m1+" & "+m2);
        System.out.println("Bob decrypt   : "+bob.Decryption(c3));
    }
}
