class Solution {
    public double angleClock(int hour, int minutes) {
        double hourHand = (hour%12)*30 + minutes/2.0;
        double minutesHand = minutes*6.0;
        
        return Math.min(Math.max(hourHand, minutesHand) - Math.min(hourHand, minutesHand), 360.0-Math.max(hourHand, minutesHand)+Math.min(hourHand, minutesHand));
    }
}