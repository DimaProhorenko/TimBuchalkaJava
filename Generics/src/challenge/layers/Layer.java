package challenge.layers;

import challenge.markers.Mappable;
import java.util.List;
import java.util.ArrayList;

public class Layer<T extends Mappable> {
    private List<T> places;

    public Layer(List<T> places) {
        this.places = places;
    }

    public Layer() {
        this.places = new ArrayList<>();
    }

    public boolean addElementToLayer(T t) {
        if(places.size() == 0 || findPlace(t) == null) {
            places.add(t);
            return true;
        }
        return false;
    }

    public void addElemementsToLayer(T... args) {
        for(T place:args) {
            addElementToLayer(place);
        }
    }

    public List<T> getPlaces() {
        return places;
    }

    public void renderPlaces() {
        places.forEach(Mappable::render);
    }
    private T findPlace(T t) {
        int index = places.indexOf(t);
        return index == -1 ? null : places.get(index);
    }
}
