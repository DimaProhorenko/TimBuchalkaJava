package challenge.markers;

import java.util.Objects;

public abstract class Marker implements Mappable{
    private String name;
    private MarkerType type;


    public Marker(MarkerType type, String name) {
        this.type = type;
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("'%s' (%f, %f)", name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Marker marker = (Marker) o;
        return Objects.equals(name, marker.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }

    public MarkerType getType() {
        return type;
    }
}
