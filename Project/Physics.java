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
    /**
     * Gets the value of the missile's angle of launch
     *
     * @return The angle of launch in the launchValues ArrayList
     * */
    public double getAngleOfLaunch() {
        return launchValues.get(0);
    }

    /**
     * Sets the angle of launch into the launchValues ArrayList
     *
     * @param angleOfLaunch The angle of launch of type double
     *
     * @return Returns nothing
     * */
    public void setAngleOfLaunch(double angleOfLaunch) {
        this.angleOfLaunch = launchValues.set(0, angleOfLaunch);
    }

    //setters and getters of gravitational acceleration
    /**
     * Gets the value of the missile's gravitational acceleration
     *
     * @return the value of the gravitational acceleration from the launchValues ArrayList
     * */
    public double getGravAcceleration() {
        return launchValues.get(1);
    }

    /**
     *  Sets the gravitational acceleration into the launchValues ArrayList
     *
     * @param gravAcceleration The gravitational acceleration of type double
     *
     * @return Returns nothing
     **/
    public void setGravAcceleration(double gravAcceleration) {
        this.gravAcceleration = launchValues.set(1, gravAcceleration);
    }

    //setters and getters of height of launch
    /**
     * Gets the value of the missile's height of launch
     *
     * @return the value of the height of launch from the launchValues ArrayList
     * */
    public double getHeightOfLaunch() {
        return launchValues.get(2);
    }

    /**
     * Sets the height of launch into the launchValues ArrayList
     *
     * @param heightOfLaunch The height of launch of type double
     *
     * @return Returns nothing
     * */
    public void setHeightOfLaunch(double heightOfLaunch) {
        this.heightOfLaunch = launchValues.set(2, heightOfLaunch);
    }

    //setters and getters of initial velocity
    /**
     * Gets the value of the missile's initial velocity
     *
     * @return the value of the initial velocity from the launchValues ArrayList
     * */
    public double getInitialVelocity() {
        return launchValues.get(3);
    }

    /**
     * Sets the initial velocity into the launchValues ArrayList
     *
     * @param initialVelocity The initial velocity of type double
     *
     * @return Returns nothing
     * */
    public void setInitialVelocity(double initialVelocity) {
        this.initialVelocity = launchValues.set(3, initialVelocity);
    }

    //setters and getters of launch values
    /**
     * Gets the missile's launch values
     *
     * @return the ArrayList of launchValues
     * */
    public ArrayList<Double> getLaunchValues() {
        return launchValues;
    }

    /**
     * Sets the launchValues ArrayList
     *
     * @param launchValues The ArrayList launchValues of type Double
     *
     * @returns Returns nothing
     * */
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
    /**
     * Clones the Physics object for the Prototype design pattern
     * */
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
     * @return the height the missile reaches
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