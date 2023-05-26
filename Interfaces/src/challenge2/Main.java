package challenge2;

public class Main {
    public static void main(String[] args) {
        Mappable b = new Building("Sydney Town Hall", BuildingType.GOVERNMENT);
        Mappable u = new UtilityLine("College St", UtilityLineType.FIBER_OPTIC);
        Mappable.mapIt(b);
        Mappable.mapIt(u);
    }
}
