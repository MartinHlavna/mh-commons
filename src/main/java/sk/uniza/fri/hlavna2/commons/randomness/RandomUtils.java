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

import java.util.Random;

/**
 * Various utilities for generating random numbers
 *
 * @author Martin Hlavňa {@literal <mato.hlavna@gmail.com>}
 */
public class RandomUtils {

    /**
     * Uses provided generator to get double of given min max interval
     *
     * @param random Random generator to use
     * @param min Minimum value to generate, inclusive
     * @param max Maximum value to generate, exclusive
     * @return double between {@literal <min, max)}
     */
    public static double nextDouble(Random random, double min, double max) {
        return ((random.nextDouble() * (max - min)) + min);
    }

    /**
     * Uses provided generator to get double of given 0 to max interval. Same as calling nextDouble(Ranom, 0, double)
     *
     * @param random Random generator to use
     * @param max Maximum value to generate, exclusive
     * @return double between {@literal <min, max)}
     */
    public static double nextDouble(Random random, double max) {
        //NOTE: Not reusing nextDouble(Random random, double min, double max) to minimize double precision errors
        return ((random.nextDouble() * (max)));
    }

    /**
     * Uses provided generator to get float of given min max interval
     *
     * @param random Random generator to use
     * @param min Minimum value to generate, inclusive
     * @param max Maximum value to generate, exclusive
     * @return float between {@literal <min, max)}
     */
    public static double nextFloat(Random random, float min, float max) {
        return ((random.nextFloat() * (max - min)) + min);
    }

    /**
     * Uses provided generator to get loat of given 0 to max interval. Same as calling nextFloat(Ranom, 0, float)
     *
     * @param random Random generator to use
     * @param max Maximum value to generate, exclusive
     * @return double between {@literal <min, max)}
     */
    public static double nextFloat(Random random, float max) {
        //NOTE: Not reusing nextFloat(Random random, double min, double max) to minimize double precision errors
        return ((random.nextFloat() * (max)));
    }

    /**
     * Uses provided generator to get double of given min max interval
     *
     * @param random Random generator to use
     * @param min Minimum value to generate, inclusive
     * @param max Maximum value to generate, exclusive
     * @return int between {@literal <min, max)}
     */
    public static int nextInt(Random random, int min, int max) {
        return ((random.nextInt((max - min))) + min);
    }

    /**
     * Uses provided generator to get double of given 0 max interval. Same as calling nextInt(Random, 0, int)
     *
     * @param random Random generator to use
     * @param max Maximum value to generate, exclusive
     * @return int between {@literal <min, max)}
     */
    public static int nextInt(Random random, int max) {
        return nextInt(random, 0, max);
    }

    /**
     * Uses provided generator to get long of given min max interval
     *
     * @param random Random generator to use
     * @param min Minimum value to generate, inclusive
     * @param max Maximum value to generate, exclusive
     * @return long between {@literal <min, max)}
     */
    public static double nextLong(Random random, long min, long max) {
        return ((random.nextInt(1) * (max - min)) + min);
    }

    /**
     * Uses provided generator to get double of given 0 max interval. Same as calling nextLong(Random, 0, long)
     *
     * @param random Random generator to use
     * @param max Maximum value to generate, exclusive
     * @return long between {@literal <min, max)}
     */
    public static double nextLong(Random random, long max) {
        return nextLong(random, 0, max);
    }

    /**
     * Uses provided generator to get boolean value.
     *
     * Value is created as follows: Random.nextDouble() is called. If generated value is less that trueTresshold, then
     * true is returned. Otherwise false is returned.
     *
     * @param random Random generator to use
     * @param trueTreshold Maximum value (inclusive) that will return true
     * @return True, with trueTreshold probability
     */
    public static boolean nextBoolean(Random random, double trueTreshold) {
        double generatedValue = random.nextDouble();
        return generatedValue <= trueTreshold;
    }
}
