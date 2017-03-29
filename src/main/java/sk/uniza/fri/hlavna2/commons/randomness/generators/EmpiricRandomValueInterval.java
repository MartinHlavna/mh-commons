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
package sk.uniza.fri.hlavna2.commons.randomness.generators;

/**
 * Value of the EmpiricRandomGenerator which returns values from suplied generator generator
 *
 * @author Martin Hlavňa {@literal <mato.hlavna@gmail.com>}
 * @param <T> Type of the result
 */
public class EmpiricRandomValueInterval<T> extends EmpiricRandomValue<T> {

    private final RandomGenerator<T> generator;

    /**
     * Costructs value with random generator which is source of the values and probalitity in which these values will be
     * returned if this value is part of the generator
     *
     * @param generator Source of values
     * @param probability Probability of this interval
     */
    public EmpiricRandomValueInterval(RandomGenerator<T> generator, double probability) {
        super(probability, null);
        this.generator = generator;
    }

    @Override
    public T getValue() {
        return generator.next();
    }

}