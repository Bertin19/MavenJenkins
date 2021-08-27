package de.bertin.learns.jenkins;

import org.junit.Assert;
import org.junit.Test;

public class JenkinsCalculatorUnitTest {

    @Test
    public void addTest() {
        JenkinsCalculator jc = new JenkinsCalculator();
        Assert.assertEquals(10, jc.add(4, 6));
    }

    @Test
    public void subTest() {
        JenkinsCalculator jc = new JenkinsCalculator();
        Assert.assertEquals(0, jc.sub(1,1));
        Assert.assertEquals(0, jc.sub(1,2));
        Assert.assertEquals(0, jc.sub(1,2));
        Assert.assertEquals(3, jc.sub(6,3));
    }
}
