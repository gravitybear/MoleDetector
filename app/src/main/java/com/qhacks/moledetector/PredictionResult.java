package com.qhacks.moledetector;

/**
 * Represents a result of a prediction from the server
 */

public class PredictionResult {
    private double likelihood, asymmetry, jagedness, coloring;

    public PredictionResult(double likelihood, double asymmetry, double jagedness, double coloring) {
        this.likelihood = likelihood;
        this.asymmetry = asymmetry;
        this.jagedness = jagedness;
        this.coloring = coloring;
    }

    public double getLikelihood() {
        return likelihood;
    }

    public double getColoring() {
        return coloring;
    }

    public double getJagedness() {
        return jagedness;
    }

    public double getAsymmetry() {
        return asymmetry;
    }
}
