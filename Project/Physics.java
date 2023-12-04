package Project;

import java.util.ArrayList;

/**
 * @author Kevin Wei
 */
// Prototype design pattern
public class Physics implements Cloneable{
    private double angleOfLaunch;
    private double gravAcceleration;
    private double heightOfLaunch;
    private double initialVelocity;
    private ArrayList<Double> launchValues;

    //setters and getters of angle of launch
    public double getAngleOfLaunch() {
        return launchValues.get(0);
    }
    public void setAngleOfLaunch(double angleOfLaunch) {
        this.angleOfLaunch = launchValues.set(0, angleOfLaunch);
    }

    //setters and getters of gravitational acceleration
    public double getGravAcceleration() {
        return launchValues.get(1);
    }
    public void setGravAcceleration(double gravAcceleration) {
        this.gravAcceleration = launchValues.set(1, gravAcceleration);
    }

    //setters and getters of height of launch
    public double getHeightOfLaunch() {
        return launchValues.get(2);
    }
    public void setHeightOfLaunch(double heightOfLaunch) {
        this.heightOfLaunch = launchValues.set(2, heightOfLaunch);
    }

    //setters and getters of initial velocity
    public double getInitialVelocity() {
        return launchValues.get(3);
    }
    public void setInitialVelocity(double initialVelocity) {
        this.initialVelocity = launchValues.set(3, initialVelocity);
    }

    //setters and getters of launch values
    public ArrayList<Double> getLaunchValues() {
        return launchValues;
    }
    public void setLaunchValues(ArrayList<Double> launchValues) {
        this.launchValues = launchValues;
    }

    //Physics constructor
    /**
     * Stores the values contained inside the launchValues object into the parameter
     * of the physics object.
     * 
     * @param launchValues An arrayList that contains information about the
     *                     trajectory of the rocket.
     * @return Returns nothing
     */
    public Physics(ArrayList<Double> launchValues) {
        this.angleOfLaunch = launchValues.get(0);
        this.gravAcceleration = launchValues.get(1);
        this.heightOfLaunch = launchValues.get(2);
        this.initialVelocity = launchValues.get(3);

        this.launchValues = launchValues;
    }

    //For cloneing prototype
    //200,000 units are ready, with a million more well on the way
    //Magnificent, aren't they?
    @Override
    public Physics clone() {
        try {
            Physics clone = (Physics) super.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    // Calculate time until the missile hits target
    public double calcTime() {

        double angle = this.angleOfLaunch;
        double a = this.gravAcceleration;
        double vi = this.initialVelocity;
        double yi = this.heightOfLaunch;
        
        double radians = (Math.PI*angle)/180;
        double viY = vi*Math.sin(radians);
        
        double time = (viY+(Math.sqrt(viY*viY+2*a*yi)))/a;

        return time;
    }

    /**
     * This method calculate max height missile will reach
     * 
     * @return the height the missle reaches
     */
    public double calcMaxHeight() {

        double angle = this.angleOfLaunch;
        double a = this.gravAcceleration;
        double vi = this.initialVelocity;
        double yi = this.heightOfLaunch;
        
        double radians = (Math.PI*angle)/180;
        double viY = vi*Math.sin(radians);
        
        double maxHeight = (yi+(viY*viY))/(2*a);

        return maxHeight;
    }

    /**
     * This method calculate distance travelled on x by missile
     * 
     * @return the distance travelled on the x-axis
     */
    public double calcDistance() {

        double angle = this.angleOfLaunch;
        double a = this.gravAcceleration;
        double vi = this.initialVelocity;
        double yi = this.heightOfLaunch;

        double radians = Math.PI * angle / 180;
        double viY = vi * Math.sin(radians);
        double viX = vi * Math.cos(radians);

        double distance = (viX * (viY + (Math.sqrt(viY * viY + 2 * a * yi)))) / a;

        return distance;
    }
}