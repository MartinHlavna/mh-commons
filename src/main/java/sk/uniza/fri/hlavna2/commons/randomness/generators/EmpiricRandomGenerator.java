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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import sk.uniza.fri.hlavna2.commons.randomness.exception.IncorrectProbabilityException;

/**
 * Generator of the values with given empiric probability intervals
 *
 * @author Martin Hlavňa {@literal <mato.hlavna@gmail.com>}
 * @param <T> Type of result
 */
public class EmpiricRandomGenerator<T> implements RandomGenerator<T> {

    private final Random random;
    private final List<EmpiricRandomValue<T>> values;

    public EmpiricRandomGenerator(Random random, List<EmpiricRandomValue<T>> values) {
        this.random = random;
        List<EmpiricRandomValue<T>> tmpList = init(values);
        this.values = Collections.unmodifiableList(tmpList);
    }

    public EmpiricRandomGenerator(Random random, EmpiricRandomValue<T>... values) {
        this.random = random;
        List<EmpiricRandomValue<T>> tmpList = init(Arrays.asList(values));
        this.values = Collections.unmodifiableList(tmpList);
    }

    private List<EmpiricRandomValue<T>> init(List<EmpiricRandomValue<T>> values) throws IncorrectProbabilityException {
        double prob = 0;
        for (EmpiricRandomValue<T> value : values) {
            prob += value.getProbability();
        }
        if (Double.compare(prob, 1.0) != 0) {
            throw new IncorrectProbabilityException();
        }
        ArrayList<EmpiricRandomValue<T>> tmpList = new ArrayList<>(values);
        Collections.sort(tmpList);
        return tmpList;
    }

    @Override
    public T next() {
        double randomNumber = random.nextDouble();
        double probabilitySum = 0;
        for (EmpiricRandomValue<T> value : values) {
            probabilitySum += value.getProbability();
            if (randomNumber < probabilitySum) {
                return value.getValue();
            }
        }
        return null;
    }

}
