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

import java.security.SecureRandom;
import java.util.Random;

/**
 * Provides random generators initialized with random seed
 *
 * During contruction of object, one random is created either with system time or given long seed. On call to
 * createRandom, new long seed is generated and generator is constructed with this seed
 *
 * @author Martin Hlavňa {@literal <mato.hlavna@gmail.com>}
 */
public class RandomProvider {

    private final Random random;

    public RandomProvider() {
        this.random = new SecureRandom();
    }

    public RandomProvider(long seed) {
        this.random = new Random(seed);
    }

    /**
     * Creates new Random generator initialized with random seed
     *
     * @return New instance of Random class
     */
    public Random createRandom() {
        return new Random(random.nextLong());
    }
}
