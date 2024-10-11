package com.prime.prime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class PrimeServiceTest {

    private PrimeService primeService;

    @BeforeEach
    void setUp() {
        primeService = new PrimeService();
    }

    @Nested
    class checkPrimeTests {

        @Test
        @DisplayName("Bound less than 2")
        void testBoundLessThanTwo() {
            List<Integer> primes = primeService.checkPrime(1);
            assertTrue(primes.isEmpty());
        }

        @Test
        @DisplayName("Bound equal to 2")
        void testBoundTwo() {
            List<Integer> primes = primeService.checkPrime(2);
            assertEquals(1, primes.size());
            assertTrue(primes.contains(2));
        }

        @Test
        @DisplayName("Large bound")
        void testLargeBound() {
            int bound = 10000;
            List<Integer> primes = primeService.checkPrime(bound);
            assertEquals(1229, primes.size());
            assertEquals(2, primes.get(0));
            assertEquals(9973, primes.get(primes.size() - 1));
        }

        @Test
        @DisplayName("bound as a non-prime number")
        void testBoundAsNonPrime() {
            int bound = 9;
            List<Integer> primes = primeService.checkPrime(bound);
            List<Integer> expectedPrimes = List.of(2, 3, 5, 7);
            assertEquals(expectedPrimes, primes);
        }
    }
}
