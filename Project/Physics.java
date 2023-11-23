package Project;

import java.util.ArrayList;

public class Physics {

    private double angleOfLaunch; //angle of launch
    private double gravAcceleration; //gravitational acceleration
    private double heightOfLaunch; //height of launch
    private double initialVelocity; //initial velocity


    public Physics(ArrayList<Double> launchValues) {
        angleOfLaunch = launchValues.indexOf(0);
        gravAcceleration = launchValues.indexOf(1);
        heightOfLaunch = launchValues.indexOf(2);
        initialVelocity = launchValues.indexOf(3);
    }

    //Getter and Setter for angleOfLaunch
    public double getAngleOfLaunch() {
        return angleOfLaunch;
    }
    public void setAngleOfLaunch(double angleOfLaunch) {
        this.angleOfLaunch = angleOfLaunch;
    }

    //Getter and Setter for gravAcceleration
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

    public double calcMissileTime() {
        //Turning getters to physics variables
        double angle = getAngleOfLaunch();
        double a = getGravAcceleration();
        double vi = getInitialVelocity();

        return (-(vi*Math.sin(angle))-(vi*Math.sin(angle)))/a;
        //V_fy = V_iy + a*t (simplified to isolate t)
    }

}
