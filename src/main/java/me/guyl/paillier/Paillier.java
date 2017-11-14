package me.guyl.paillier;

import java.math.BigInteger;
import java.util.Random;

/**
 * Created by Guyl Bastien on 03/01/2017.
 */
class Paillier {

    private static final int numBits = 32;
    private BigInteger pk, sk, r;
    private static Random rand = new Random();

    private Paillier(BigInteger pk, BigInteger sk){
        this.pk = pk;
        this.sk = sk;
    }

    BigInteger getPk() {
        return pk;
    }

    static Paillier KeyGeneration(){
        BigInteger p, q, pk, sk;
        p = new BigInteger(numBits, rand);
        q = new BigInteger(numBits, rand);

        while(!p.isProbablePrime(1000))
            p = new BigInteger(numBits, rand);
        while(!q.isProbablePrime(1000))
            q = new BigInteger(numBits, rand);
        pk = p.multiply(q);

        sk = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

        return new Paillier(pk, sk);
    }

    BigInteger Encryption(BigInteger message, BigInteger pk){
        BigInteger m = message;
        BigInteger r = new BigInteger(numBits, rand);
        while (r.compareTo(pk) > 0)
            r = new BigInteger(numBits, rand);
        return (pk.add(BigInteger.ONE)).modPow(m, pk.multiply(pk)).multiply(r.modPow(pk, pk.multiply(pk))).mod(pk.multiply(pk));
    }

    BigInteger Decryption(BigInteger ciphertext){
        BigInteger c = ciphertext;
        if(r == null)
            r = c.modPow(pk.modInverse(sk), pk).mod(pk);
        return c.multiply(r.modPow(pk.negate(), pk.multiply(pk))).subtract(BigInteger.ONE).divide(pk).mod(pk);
    }
}
