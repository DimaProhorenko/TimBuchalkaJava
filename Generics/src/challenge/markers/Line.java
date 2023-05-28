package challenge.markers;
import java.util.Arrays;
public abstract class Line extends Marker{
    String[][] location;

    public Line(String name, String[][] location) {
        super(MarkerType.LINE, name);
        this.location = location;
    }

    public Line(String name, String pointA, String pointB) {
        this(name, new String[][] {splitAndTrimPoint(pointA), splitAndTrimPoint(pointB)});
    }


    private static String[] splitAndTrimPoint(String point) {
        return Arrays.stream(point.split(",")).map(el -> el.trim()).toArray(String[]::new);
    }

    @Override
    public void render() {
        System.out.printf("Render %s as %s ([%s, %s])\n", getName(), getType(), Arrays.toString(getLocation()[0]), Arrays.toString(getLocation()[1]));
    }

    public String[][] getLocation() {
        return location;
    }
}
