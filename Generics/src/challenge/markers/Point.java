package challenge.markers;

import java.util.*;

public abstract class Point extends Marker{
    private String[] location;
    public Point(String name, String latitude, String longitude) {
        super(MarkerType.POINT, name);
        location = new String[] {latitude, longitude};
    }

    public Point(String name, String[] location) {
        super(MarkerType.POINT, name);
        this.location = location;
    }

    public String[] getLocation() {
        return location;
    }

    @Override
    public void render() {
        System.out.printf("Render %s as %s (%s)\n", getName(), getType(), Arrays.toString(getLocation()));
    }
}
