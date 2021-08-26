package de.bertin.learns.jenkins;

public class JenkinsCalculator {
    // Addition
    public int add(int a, int b) {
        return a + b;
    }

    // Subtraction
    public int sub(int a, int b) {
        if (a > b)
            return a - b;
        return 0;
    }
}
