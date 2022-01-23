package PrimeGenerator;

import PrimeGenerator.algorithm.PrimeGenerator;
import PrimeGenerator.algorithm.IterativePrimeGenerator;
import PrimeGenerator.algorithm.SieveOfEratosPrimeGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class AlgorithmTests {
	final PrimeGenerator underTestIterAlgorithm = new IterativePrimeGenerator();
	final PrimeGenerator underTestSieveAlgorithm = new SieveOfEratosPrimeGenerator();
	final int startRangeTest1 = 1, endRangeTest1 = 10;
	final List<Integer> expectedResult1 = new ArrayList<Integer>() {
		{
			add(2);
			add(3);
			add(5);
			add(7);
		}
	};

	@Test
	void IterativeAlgorithmTest1() {

		List<Integer> actualResult = underTestIterAlgorithm.generatePrimes(startRangeTest1, endRangeTest1);
		assertEquals(expectedResult1,actualResult);
	}


	@Test
	void SieveAlgorithmTest1(){
		List<Integer> actualResult = underTestSieveAlgorithm.generatePrimes(startRangeTest1, endRangeTest1);
		assertEquals(expectedResult1,actualResult);
	}

	private final int startRangeTest2 = 90, endRangeTest2 = 96;
	private final List<Integer> expectedResult2= new ArrayList<>();

	@Test
	void IterativeAlgorithmTest2() {
		List<Integer> actualResult = underTestIterAlgorithm.generatePrimes(startRangeTest2, endRangeTest2);
		assertEquals(expectedResult2, actualResult);
	}

	@Test
	void SieveAlgorithmTest2(){
		List<Integer> actualResult = underTestSieveAlgorithm.generatePrimes(startRangeTest2, endRangeTest2);
		assertEquals(expectedResult2, actualResult);
	}




}
