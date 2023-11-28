package Project;

import java.util.ArrayList;

public class Physics {
    double angleOfLaunch, gravAcceleration, heightOfLaunch, initialVelocity;
    ArrayList<Double> launchValues;

    public Physics(ArrayList<Double> launchValues) {
        this.angleOfLaunch = launchValues.get(0);
        this.gravAcceleration = launchValues.get(1);
        this.heightOfLaunch = launchValues.get(2);
        this.initialVelocity = launchValues.get(3);
        
        this.launchValues = launchValues;
    }

    // Calculate time until the missile hits target
    public double calcTime() {
        
        double angle = this.angleOfLaunch;
        double a = this.gravAcceleration;
        double vi = this.initialVelocity;
        double yi = this.heightOfLaunch;
        
        double radians = Math.PI*angle/180;
        double viY = vi*Math.sin(radians);
        
        double time = (viY+(Math.sqrt(viY*viY+2*a*yi)))/a;

        return time;
    }

    // Calculate max height missile will reach
    public double calcMaxHeight() {

        double angle = this.angleOfLaunch;
        double a = this.gravAcceleration;
        double vi = this.initialVelocity;
        double yi = this.heightOfLaunch;
        
        double radians = Math.PI*angle/180;
        double viY = vi*Math.sin(radians);
        
        double maxHeight = (yi+(viY*viY))/(2*a);

        return maxHeight;
    }

    // Calculate distance travelled on x by missile
    public double calcDistance() {

        double angle = this.angleOfLaunch;
        double a = this.gravAcceleration;
        double vi = this.initialVelocity;
        double yi = this.heightOfLaunch;
        
        double radians = Math.PI*angle/180;
        double viY = vi*Math.sin(radians);
        double viX = vi*Math.cos(radians);
        
        double distance = (viX*(viY+(Math.sqrt(viY*viY+2*a*yi))))/a;

        return distance;
    }

}
