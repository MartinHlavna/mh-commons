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

import sk.uniza.fri.hlavna2.commons.randomness.exception.IncorrectProbabilityException;

/**
 * Wrapper for Value of EmpiricRandomGenerator
 *
 * @author Martin Hlavňa {@literal <mato.hlavna@gmail.com>}
 * @param <T> Type of the value
 * @see EmpiricRandomGenerator
 */
public class EmpiricRandomValue<T> implements Comparable {

    private int probability;
    private T value;

    /**
     * Construct new value using percentage probality
     *
     * @param probability Probability in percentual value (0, 100)
     * @param value Value this object holds
     */
    public EmpiricRandomValue(int probability, T value) {
        if (probability >= 100 || probability <= 0) {
            throw new IncorrectProbabilityException();
        }
        this.probability = probability;
        this.value = value;
    }

    /**
     * Construct new value using war probability value
     *
     * @param probability double value from (0,1) interval
     * @param value Value this object holds
     */
    public EmpiricRandomValue(double probability, T value) {
        if (probability >= 1.0 || probability <= 0.0) {
            throw new IncorrectProbabilityException();
        }
        this.probability = (int) Math.floor(probability * 100);
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public double getProbability() {
        return probability / 100.0;
    }

    public int getIntProbability() {
        return probability;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof EmpiricRandomValue) {
            return ((EmpiricRandomValue) o).probability - this.probability;
        }
        return -1;
    }

}
