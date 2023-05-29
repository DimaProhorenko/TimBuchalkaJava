package challenge.model;

import java.util.Comparator;

class LPAStudentCompletionComparator implements Comparator<LPAStudent> {

    @Override
    public int compare(LPAStudent o1, LPAStudent o2) {
        return (int) (o1.getPercentComplete() - o2.getPercentComplete());
    }
}
public class LPAStudent extends Student{
    private double percentComplete;

    public LPAStudent() {
        percentComplete = random.nextDouble(0, 100.001);
    }

    @Override
    public String toString() {
        return "%s %8.1f%%".formatted(super.toString(), percentComplete);
    }

    @Override
    public boolean matchFieldValue(String fieldName, String value) {
        String fName = fieldName.toUpperCase();
        return switch(fName) {
            case "NAME" -> getName().equalsIgnoreCase(value);
            case "COURSE" -> getCourse().equalsIgnoreCase(value);
            case "YEARSTARTED" -> getYearStarted() == Integer.parseInt(value);
            case "COMPLETED" -> percentComplete >= 0 && percentComplete <= Double.parseDouble(value);
            default -> false;
        };
    }

    public double getPercentComplete() {
        return percentComplete;
    }

    public static LPAStudentCompletionComparator getCompletionComparator() {
        return new LPAStudentCompletionComparator();
    }
}
