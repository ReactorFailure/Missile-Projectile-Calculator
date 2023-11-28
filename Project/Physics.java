package Project;

import java.util.ArrayList;

public class Physics {
    double angleOfLaunch, gravAcceleration, heightOfLaunch, initialVelocity;

    public Physics(ArrayList<Double> launchValues) {
        this.angleOfLaunch = launchValues.get(0);
        this.gravAcceleration = launchValues.get(1);
        this.heightOfLaunch = launchValues.get(2);
        this.initialVelocity = launchValues.get(3);
    }

    // Getter and Setter for angleOfLaunch
    public double getAngleOfLaunch() {
        return angleOfLaunch;
    }

    public void setAngleOfLaunch(double angleOfLaunch) {
        this.angleOfLaunch = angleOfLaunch;
    }

    // Getter and Setter for gravAcceleration
    public double getGravAcceleration() {
        return gravAcceleration;
    }

    public void setGravAcceleration(double gravAcceleration) {
        this.gravAcceleration = gravAcceleration;
    }

    public double getHeightOfLaunch() {
        return heightOfLaunch;
    }

    public void setHeightOfLaunch(double heightOfLaunch) {
        this.heightOfLaunch = heightOfLaunch;
    }

    public double getInitialVelocity() {
        return initialVelocity;
    }

    public void setInitialVelocity(double initialVelocity) {
        this.initialVelocity = initialVelocity;
    }

    // Calculate time until the missile hits target
    public double calcTime() {
        // Turning getters to physics variables
        double angle = getAngleOfLaunch();
        double a = getGravAcceleration();
        double vi = getInitialVelocity();
        double h1 = getHeightOfLaunch();

        return (((vi*Math.sin(angle))+Math.sqrt(Math.pow(vi,2)*Math.pow(Math.sin(angle),2)+2*a*h1))/a);
    }

    // Calculate max height missile will reach
    public double calcMaxHeight() {
        double angle = getAngleOfLaunch();
        double a = getGravAcceleration();
        double vi = getInitialVelocity();
        double yi = getHeightOfLaunch();

        return (((Math.pow(vi,2)*Math.pow(Math.sin(angle),2))/(2*a))+yi);
    }

    // Calculate distance of missile at y=0
    public double calcDistance() {
        double angle = getAngleOfLaunch();
        double vi = getInitialVelocity();
        double a = getGravAcceleration();

        return ((Math.pow(vi,2)*Math.sin(2*angle))/a);
    }

}
