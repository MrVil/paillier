package me.guyl.paillier

import java.math.BigInteger

/**
 * Created by Guyl Bastien on 17/01/2017.
 */
object ExerciceArbreDecision {

    @JvmStatic fun main(args: Array<String>) {
        val bob = Paillier.KeyGeneration()

        //Variables de bob
        val m1 = BigInteger("0")
        val m2 = BigInteger("0")
        val m3 = BigInteger("1")
        val m4 = BigInteger("1")
        val em1 = bob.Encryption(m1, bob.pk)
        val em2 = bob.Encryption(m2, bob.pk)
        val em3 = bob.Encryption(m3, bob.pk)
        val em4 = bob.Encryption(m1, bob.pk)

        //Variable d'Alice
        val one = BigInteger("1")
        val eone = bob.Encryption(m1, bob.pk)

        val nem1 = em1.pow(-1)
        val nem2 = em2.pow(-1)
        val nem4 = em4.pow(-1)
        val result:BigInteger = one*one*one*nem1*nem1*nem2*em3*nem4


    }

}
