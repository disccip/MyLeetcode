// 539. Minimum Time Difference -------- medium
// Convert every time into minutes then sort the array
// Be careful about the corner case, check the head and tail

class LC539 {
    public int findMinDifference(List<String> timePoints) {
        int[] time = new int[timePoints.size()];
        for (int i = 0; i < timePoints.size(); i++)
        {
            String t = timePoints.get(i);
            int minute = Integer.parseInt(t.substring(0, 2)) * 60 + Integer.parseInt(t.substring(3, 5));
            time[i] = minute;
        }
        Arrays.sort(time);
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < time.length - 1; i++)
        {
            diff = Math.min(diff, time[i + 1] - time[i]);
        }
        diff = Math.min(diff, time[0] + 1440 - time[time.length - 1]);
        return diff;
    }
}