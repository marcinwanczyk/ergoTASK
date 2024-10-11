package com.prime.prime;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PrimeService {

    public List<Integer> checkPrime(int bound) {
        List<Integer> primes = new ArrayList<>();

        // Sieve of Eratosthenes algorithm
        // Bitset instead of boolean array to save memory
        BitSet isPrime = new BitSet(bound + 1);
        isPrime.set(2, bound + 1, true);

        for (int p = 2; p * p <= bound; p++) {
            if (isPrime.get(p)) {
                for (int i = p * p; i <= bound; i += p) {
                    isPrime.clear(i);
                }
            }
        }

        // Every prime number is odd except 2 --> skip even numbers
        primes.add(2);
        for (int i = 3; i <= bound; i += 2) {
            if (isPrime.get(i)) {
                primes.add(i);
            }
        }

        return primes;
    }
}
