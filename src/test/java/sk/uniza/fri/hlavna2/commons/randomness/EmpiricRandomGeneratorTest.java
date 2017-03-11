/*
 * The MIT License
 *
 * Copyright 2017 Martin Hlavňa <mato.hlavna@gmail.com>.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package sk.uniza.fri.hlavna2.commons.randomness;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import org.junit.Assert;
import org.junit.Test;
import sk.uniza.fri.hlavna2.commons.randomness.exception.IncorrectProbabilityException;

/**
 *
 * @author Martin Hlavňa {@literal <mato.hlavna@gmail.com>}
 */
public class EmpiricRandomGeneratorTest {

    private static final int THREE = 3;
    private static final int TWO = 2;
    private static final int ONE = 1;
    private static final int NUMBER_OF_ITERATIONS = 1000000;
    private static final double DELTA = 0.01;

    @Test
    public void testCorrectProbability() {
        new EmpiricRandomGenerator<>(new Random(12345),
                new EmpiricRandomValue<>(50, ONE),
                new EmpiricRandomValue<>(10, TWO),
                new EmpiricRandomValue<>(40, THREE)
        );
        new EmpiricRandomGenerator<>(new Random(12345),
                new EmpiricRandomValue<>(0.5, ONE),
                new EmpiricRandomValue<>(0.1, TWO),
                new EmpiricRandomValue<>(0.4, THREE)
        );
        new EmpiricRandomGenerator<>(new Random(12345),
                new EmpiricRandomValue<>(50, ONE),
                new EmpiricRandomValue<>(0.1, TWO),
                new EmpiricRandomValue<>(40, THREE)
        );
    }

    @Test(expected = IncorrectProbabilityException.class)
    public void testIncorrectProbabilityInt() {
        new EmpiricRandomGenerator<>(new Random(12345),
                new EmpiricRandomValue<>(50, ONE),
                new EmpiricRandomValue<>(20, TWO),
                new EmpiricRandomValue<>(40, THREE)
        );
    }

    @Test(expected = IncorrectProbabilityException.class)
    public void testIncorrectProbabilityDouble() {

        new EmpiricRandomGenerator<>(new Random(12345),
                new EmpiricRandomValue<>(0.5, ONE),
                new EmpiricRandomValue<>(0.2, TWO),
                new EmpiricRandomValue<>(0.4, THREE)
        );

    }

    @Test(expected = IncorrectProbabilityException.class)
    public void testIncorrectProbabilityMixed() {
        new EmpiricRandomGenerator<>(new Random(12345),
                new EmpiricRandomValue<>(50, ONE),
                new EmpiricRandomValue<>(0.2, TWO),
                new EmpiricRandomValue<>(40, THREE)
        );
    }

    @Test(expected = IncorrectProbabilityException.class)
    public void testIncorrectProbabilityValueDoubleSmall() {
        new EmpiricRandomValue<>(-0.2, TWO);
    }

    @Test(expected = IncorrectProbabilityException.class)
    public void testIncorrectProbabilityValueDoubleBig() {
        new EmpiricRandomValue<>(1.2, TWO);
    }

    @Test(expected = IncorrectProbabilityException.class)
    public void testIncorrectProbabilityValueIntSmall() {
        new EmpiricRandomValue<>(-10, TWO);
    }

    @Test(expected = IncorrectProbabilityException.class)
    public void testIncorrectProbabilityValueIntBig() {
        new EmpiricRandomValue<>(110, TWO);
    }

    @Test
    public void testProbability() {
        final int seed = 12345;
        Random random = new Random(seed);
        for (int i = 0; i < 20; i++) {
            probabilityTestIteration(random.nextLong());
        }

    }

    private void probabilityTestIteration(final long seed) {
        EmpiricRandomGenerator<Integer> empiricRandomGenerator = new EmpiricRandomGenerator<>(new Random(seed),
                new EmpiricRandomValue<>(50, ONE),
                new EmpiricRandomValue<>(10, TWO),
                new EmpiricRandomValue<>(40, THREE)
        );
        Map<Integer, Integer> results = new HashMap<>(NUMBER_OF_ITERATIONS);
        generateValues(results, empiricRandomGenerator);
        Integer countOfOne = results.get(ONE);
        Integer countOfOTwo = results.get(TWO);
        Integer countOfThree = results.get(THREE);
        Assert.assertTrue(countOfOne >= (NUMBER_OF_ITERATIONS * 0.5 - NUMBER_OF_ITERATIONS * DELTA) && countOfOne <= (NUMBER_OF_ITERATIONS * 0.5 + NUMBER_OF_ITERATIONS * DELTA));
        Assert.assertTrue(countOfOTwo >= (NUMBER_OF_ITERATIONS * 0.1 - NUMBER_OF_ITERATIONS * DELTA) && countOfOTwo <= (NUMBER_OF_ITERATIONS * 0.1 + NUMBER_OF_ITERATIONS * DELTA));
        Assert.assertTrue(countOfThree >= (NUMBER_OF_ITERATIONS * 0.4 - NUMBER_OF_ITERATIONS * DELTA) && countOfThree <= (NUMBER_OF_ITERATIONS * 0.4 + NUMBER_OF_ITERATIONS * DELTA));

        empiricRandomGenerator = new EmpiricRandomGenerator<>(new Random(seed),
                new EmpiricRandomValue<>(0.5, ONE),
                new EmpiricRandomValue<>(0.1, TWO),
                new EmpiricRandomValue<>(0.4, THREE)
        );

        results = new HashMap<>(NUMBER_OF_ITERATIONS);
        generateValues(results, empiricRandomGenerator);
        countOfOne = results.get(ONE);
        countOfOTwo = results.get(TWO);
        countOfThree = results.get(THREE);

        Assert.assertTrue(countOfOne >= (NUMBER_OF_ITERATIONS * 0.5 - NUMBER_OF_ITERATIONS * DELTA) && countOfOne <= (NUMBER_OF_ITERATIONS * 0.5 + NUMBER_OF_ITERATIONS * DELTA));
        Assert.assertTrue(countOfOTwo >= (NUMBER_OF_ITERATIONS * 0.1 - NUMBER_OF_ITERATIONS * DELTA) && countOfOTwo <= (NUMBER_OF_ITERATIONS * 0.1 + NUMBER_OF_ITERATIONS * DELTA));
        Assert.assertTrue(countOfThree >= (NUMBER_OF_ITERATIONS * 0.4 - NUMBER_OF_ITERATIONS * DELTA) && countOfThree <= (NUMBER_OF_ITERATIONS * 0.4 + NUMBER_OF_ITERATIONS * DELTA));

        empiricRandomGenerator = new EmpiricRandomGenerator<>(new Random(seed),
                new EmpiricRandomValue<>(50, ONE),
                new EmpiricRandomValue<>(0.1, TWO),
                new EmpiricRandomValue<>(40, THREE)
        );

        results = new HashMap<>(NUMBER_OF_ITERATIONS);
        generateValues(results, empiricRandomGenerator);
        countOfOne = results.get(ONE);
        countOfOTwo = results.get(TWO);
        countOfThree = results.get(THREE);

        Assert.assertTrue(countOfOne >= (NUMBER_OF_ITERATIONS * 0.5 - NUMBER_OF_ITERATIONS * DELTA) && countOfOne <= (NUMBER_OF_ITERATIONS * 0.5 + NUMBER_OF_ITERATIONS * DELTA));
        Assert.assertTrue(countOfOTwo >= (NUMBER_OF_ITERATIONS * 0.1 - NUMBER_OF_ITERATIONS * DELTA) && countOfOTwo <= (NUMBER_OF_ITERATIONS * 0.1 + NUMBER_OF_ITERATIONS * DELTA));
        Assert.assertTrue(countOfThree >= (NUMBER_OF_ITERATIONS * 0.4 - NUMBER_OF_ITERATIONS * DELTA) && countOfThree <= (NUMBER_OF_ITERATIONS * 0.4 + NUMBER_OF_ITERATIONS * DELTA));
    }

    private void generateValues(Map<Integer, Integer> results, EmpiricRandomGenerator<Integer> empiricRandomGenerator) {
        results.put(ONE, 0);
        results.put(TWO, 0);
        results.put(THREE, 0);

        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            Integer generatedValue = empiricRandomGenerator.next();
            Integer oldVal = results.get(generatedValue);
            results.put(generatedValue, ++oldVal);
        }
    }

}
