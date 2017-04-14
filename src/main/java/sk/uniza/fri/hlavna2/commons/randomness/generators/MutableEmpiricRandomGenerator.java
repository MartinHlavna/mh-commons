/*
 * The MIT License
 *
 * Copyright 2017 Coder.
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

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MutableEmpiricRandomGenerator<T> extends EmpiricRandomGenerator<T> {

    public MutableEmpiricRandomGenerator(Random random, List<EmpiricRandomValue<T>> values) {
        super(random, values);
    }

    public MutableEmpiricRandomGenerator(Random random, EmpiricRandomValue<T>... values) {
        super(random, values);
    }

    /**
     * Reintiliaze generator with new values
     *
     * @param values New set of values
     */
    public void reinitValues(List<EmpiricRandomValue<T>> values) {
        List<EmpiricRandomValue<T>> tmpList = prepareValues(values);
        this.values = Collections.unmodifiableList(tmpList);
    }

    /**
     * Reintiliaze generator with new values
     *
     * @param values New set of values
     */
    public void reinitValues(EmpiricRandomValue<T>... values) {
        List<EmpiricRandomValue<T>> tmpList = prepareValues(Arrays.asList(values));
        this.values = Collections.unmodifiableList(tmpList);
    }

}
