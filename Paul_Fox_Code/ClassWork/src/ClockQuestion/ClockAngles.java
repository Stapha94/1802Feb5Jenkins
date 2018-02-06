package ClockQuestion;

import java.util.*;

public class ClockAngles {

    public static void main(String[] args) {

        Scanner timeIn = new Scanner(System.in);
        System.out.println("Enter Time in format HH:MM to determine angle of hands: ");
        String time = timeIn.nextLine();
        String[] timeSArray = new String[2];
        timeSArray = time.split(":");
        int hours = Integer.parseInt(timeSArray[0]);
        int minutes = Integer.parseInt(timeSArray[1]);

        System.out.println("The Inner Angle is: " + calculateAngle(hours, minutes) + " Degrees");



    }

    public static int calculateAngle(int hours, int minutes){

        int hourPosition = hours*30;
        int minutePosition = minutes*6;

        int innerAngle = Math.abs((hourPosition - minutePosition));

        return innerAngle;

    }

}
