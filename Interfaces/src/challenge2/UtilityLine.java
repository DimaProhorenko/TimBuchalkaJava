package challenge2;

public class UtilityLine implements Mappable{
    private String name;
    private UtilityLineType type;

    public UtilityLine(String name, UtilityLineType type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String getLabel() {
        return String.format("%s (%s)", name, type);
    }

    @Override
    public String getMarker() {
        return Color.CYAN + " " + LineMarkers.DOTTED;
    }

    @Override
    public Geometry getGeometry() {
        return Geometry.LINE;
    }

    @Override
    public String toJson() {
        return Mappable.super.toJson() + """
                "name": "%s", "utility": "%s"
                """.formatted(name, type);
    }
}
