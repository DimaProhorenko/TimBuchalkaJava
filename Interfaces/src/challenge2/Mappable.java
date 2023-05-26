package challenge2;

public interface Mappable {
    String JSON_PROPERTY = """
            "properties": {%s}"
            """;

    String getLabel();

    String getMarker();

    Geometry getGeometry();

    default String toJson() {
        return """
                "type": "%s", "label": "%s", "marker": "%s"
                """.formatted(getGeometry(), getLabel(), getMarker());
    }

    static void mapIt(Mappable m) {
        System.out.println(JSON_PROPERTY.formatted(m.toJson()));
    }
}
