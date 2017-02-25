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
 *
 * @author Martin Hlavňa <mato.hlavna@gmail.com>
 */
public class RandomUtils {

    public static double nextDouble(Random random, double min, double max) {
        return ((random.nextDouble() * (max - min)) + min);
    }

    public static double nextDouble(Random random, double max) {
        //NOTE: Not reusing nextDouble(Random random, double min, double max) to minimize double precision errors
        return ((random.nextDouble() * (max)));
    }

    public static double nextFloat(Random random, float min, float max) {
        return ((random.nextFloat() * (max - min)) + min);
    }

    public static double nextFloat(Random random, float max) {
        //NOTE: Not reusing nextFloat(Random random, double min, double max) to minimize double precision errors
        return ((random.nextFloat() * (max)));
    }

    public static int nextInt(Random random, int min, int max) {
        return ((random.nextInt((max - min))) + min);
    }

    public static int nextInt(Random random, int max) {
        return nextInt(random, 0, max);
    }

    public static double nextLong(Random random, long min, long max) {
        return ((random.nextInt(1) * (max - min)) + min);
    }

    public static double nextLong(Random random, long max) {
        return nextLong(random, 0, max);
    }

    public static boolean nextBoolean(Random random, double trueTreshold) {
        double generatedValue = random.nextDouble();
        return generatedValue < trueTreshold;
    }
}
