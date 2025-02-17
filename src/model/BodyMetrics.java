package model;

public class BodyMetrics {

    private double weight; // in lbs
    private double height; // in inches
    private double bodyFatPercentage;

    public BodyMetrics(double weight, double height, double bodyFatPercentage) {
        this.weight = weight;
        this.height = height;
        this.bodyFatPercentage = bodyFatPercentage;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getBodyFatPercentage() {
        return bodyFatPercentage;
    }

    public void setBodyFatPercentage(double bodyFatPercentage) {
        this.bodyFatPercentage = bodyFatPercentage;
    }

    @Override
    public String toString() {
        return "BodyMetrics{" +
                "weight=" + weight +
                ", height=" + height +
                ", bodyFatPercentage=" + bodyFatPercentage +
                '}';
    }
}
