package com.prime.prime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;


@Service
public class PrimeService {

    public List<Integer> checkPrime(int bound) {
        List<Integer> primes = new ArrayList<>();

        boolean[] isPrime = new boolean[bound + 1];

        for(int i = 2; i <= bound; i++) {
            isPrime[i] = true;
        }

        for(int p = 2; p * p <= bound; p++){
            if(isPrime[p] == true){
                for(int i = p * p; i <= bound; i += p){
                    isPrime[i] = false;
                }
            }
        }

        for(int i = 2; i <= bound; i++){
            if(isPrime[i] == true){
                primes.add(i);
            }
        }

        return primes;
    }
}
