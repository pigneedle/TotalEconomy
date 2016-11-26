/*
 * This file is part of Total Economy, licensed under the MIT License (MIT).
 *
 * Copyright (c) Eric Grandt <https://www.ericgrandt.com>
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.erigitic.jobs.jobs;

import com.erigitic.jobs.Job;
import ninja.leaping.configurate.ConfigurationNode;

public class FishermanJob implements Job {
    public void setupJobValues(ConfigurationNode jobsConfig) {
        String[][] catchValues = {{"cod", "25", "50.00"}, {"salmon", "100", "150.00"}, {"pufferfish", "250", "300.00"}};

        for (int i = 0; i < catchValues.length; i++) {
            jobsConfig.getNode("Fisherman", "catch", catchValues[i][0], "expreward").setValue(catchValues[i][1]);
            jobsConfig.getNode("Fisherman", "catch", catchValues[i][0], "pay").setValue(catchValues[i][2]);
        }

        jobsConfig.getNode("Fisherman", "disablesalary").setValue(false);
        jobsConfig.getNode("Fisherman", "salary").setValue(20);
        jobsConfig.getNode("Fisherman", "permission").setValue("totaleconomy.job.fisherman");
    }
}