package Project;

import java.util.ArrayList;

/**
 * @author Kevin Wei
 */
public class Physics {
    double angleOfLaunch, gravAcceleration, heightOfLaunch, initialVelocity;
    ArrayList<Double> launchValues;

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

    /**
     * This method calculates the time it takes for the rocket to reach the ground.
     * 
     * @return The time it takes for the rocket to hit y=0.
     */
    public double calcTime() {

        double angle = this.angleOfLaunch;
        double a = this.gravAcceleration;
        double vi = this.initialVelocity;
        double yi = this.heightOfLaunch;

        double radians = Math.PI * angle / 180;
        double viY = vi * Math.sin(radians);

        double time = (viY + (Math.sqrt(viY * viY + 2 * a * yi))) / a;

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

        double radians = Math.PI * angle / 180;
        double viY = vi * Math.sin(radians);

        double maxHeight = (yi + (viY * viY)) / (2 * a);

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
