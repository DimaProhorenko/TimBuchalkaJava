package challenge;
import challenge.layers.Layer;
import challenge.markers.*;
import challenge.placeTypes.*;

public class Main {
    public static void main(String[] args) {
        Layer<Marker> l = new Layer();
        Marker yellowStone = new Park("YellowStone National Park", 44.86523296709904, -110.4510451731469);
        Marker arches = new Park("Arches National Park", 38.989720913165065, -109.24095083883941);
        Marker coloradoRiver = new River("Colorado River", "34.264783647245636, -114.1306205794618", "34.183851650154, -114.23996379403859");
        l.addElemementsToLayer(yellowStone, arches, yellowStone, arches, arches, coloradoRiver);
        l.renderPlaces();
    }
}
