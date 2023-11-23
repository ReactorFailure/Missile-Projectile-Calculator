package Project;

import java.util.ArrayList;

public class Physics {

    private double angleOfLaunch; //angle of launch
    private double gravAcceleration; //gravitational acceleration
    private double heightOfLaunch; //height of launch
    private double initialVelocity; //initial velocity


    //Can't believe I had to review my projectile motion for this lol
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

    //Calculate time until the missile hits target
    public double calcTime() {
        //Turning getters to physics variables
        double angle = getAngleOfLaunch();
        double a = getGravAcceleration();
        double vi = getInitialVelocity();

        return ((-(vi*Math.sin(angle))-(vi*Math.sin(angle)))/a);
        // v_fy = v_iy + a*t    Simplified to isolate t
    }

    //Calculate max height missile will reach
    public double calcMaxHeight() {
        double angle = getAngleOfLaunch();
        double a = getGravAcceleration();
        double vi = getInitialVelocity();
        double yi = getHeightOfLaunch();

        return ((((vi*Math.sin(angle))*(vi*Math.sin(angle)))/2*a)+yi);
        // (v_fy)^2 = (v_iy)^2 - 2*a*(y_f - y_i)   Simplified to isolate y_f. v_fy is zero since we are calculating max height
    }

    //Calculate distance of missile at y=0
    public double calcDistance() {
        double angle = getAngleOfLaunch();
        double vi = getInitialVelocity();

        return (vi*Math.cos(angle))*calcTime();
        // x_f = x_i + v_x*t    x_i is zero because that's the starting point and because of reference frames and what not
    }
}
