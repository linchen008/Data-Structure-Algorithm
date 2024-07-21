package GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ActivitiesSelection {

    static void Selection(ArrayList<Activity> activityList) {

        /*
         * // Lambda expression
         * Comparator<Activity> comparator = (o1, o2) -> o1.getEndTime() -
         * o2.getEndTime();
         */

        Comparator<Activity> compartor = new Comparator<Activity>() {
            @Override
            public int compare(Activity o1, Activity o2) {
                return o1.getEndTime() - o2.getEndTime();
            }
        };
        // Sort the by end time
        Collections.sort(activityList, compartor);
        // Select the first activity
        Activity currentActivity = activityList.get(0);

        System.out.println("Selected : " + currentActivity);

        // Iterate through the rest of the activities
        for (int i = 1; i < activityList.size(); i++) {
            Activity activity = activityList.get(i);
            if (activity.getStartTime() >= currentActivity.getEndTime()) {
                System.out.println("Selected : " + activity);
                currentActivity = activity;
            }
        }

    }
}