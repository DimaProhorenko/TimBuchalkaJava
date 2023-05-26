package challenge2;

public class Building implements Mappable {
    String name;
    BuildingType type;

    public Building(String name, BuildingType type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String getLabel() {
        return String.format("%s (%s)", name, type);
    }

    @Override
    public String getMarker() {
        return Color.RED + " " + PointMarkers.STAR;
    }

    @Override
    public Geometry getGeometry() {
        return Geometry.POINT;
    }

    @Override
    public String toJson() {
        return Mappable.super.toJson() + """
                "name": "%s", "usage": "%s"
                """.formatted(name, type);
    }
}
