package challenge.placeTypes;
import challenge.markers.Point;

public class Park extends Point {

    public Park(String name, String latitude, String longitude) {
        super(name, latitude, longitude);
    }

    public Park(String name, double latitude, double longitude) {
        super(name, String.valueOf(latitude), String.valueOf(longitude));
    }

    public Park(String name, String[] location) {
        super(name, location);
    }

    public Park(String name, double[] location) {
        this(name, String.valueOf(location[0]), String.valueOf(location[1]));
    }
}
