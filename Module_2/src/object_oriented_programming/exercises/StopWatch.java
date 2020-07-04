package object_oriented_programming.exercises;

import java.util.Date;
import java.util.Scanner;

public class StopWatch {
    private double startTime;
    private double endTime;
    public double start(){
        //this.startTime = System.currentTimeMillis();
        this.startTime = new Date().getTime();
        return this.startTime;
}

    public double end(){
        //this.endTime = System.currentTimeMillis();
        this.endTime = new Date().getTime();
        return this.endTime;
    }

    public double getElapsedTime(){
        return this.endTime - this.startTime;
    }

    public static int[] selectionSort(int...a){
        for(int i=0;i<a.length-1;i++){
            for(int j=i+1;j<a.length;j++){
                if(a[j]<a[i]){
                    int tempt = a[i];
                    a[i]=a[j];
                    a[j]=tempt;
                }
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int []a = new int [100000];
        for (int i = 0; i < 100000; i++) {
            a[i]=(int)(Math.random()*1000);
        }
        StopWatch test = new StopWatch();
        double start = test.start();
        a = selectionSort(a);
//        for (int i = 0; i < 100000; i++) {
//            System.out.print(a[i]+ " ");
//        }
        double end = test.end();
        System.out.println();
        System.out.println(test.getElapsedTime());
    }
}
