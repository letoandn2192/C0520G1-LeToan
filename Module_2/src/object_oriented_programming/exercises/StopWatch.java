package object_oriented_programming.exercises;

import java.util.Date;

public class StopWatch {
    private double startTime;
    private double endTime;
    public double start(){
        this.startTime = new Date().getTime();
        return this.startTime;
    }

    public double end(){
        this.endTime = new Date().getTime();
        return this.endTime;
    }
}
