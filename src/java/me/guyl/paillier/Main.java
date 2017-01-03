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
    }
}
