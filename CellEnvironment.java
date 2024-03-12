import java.util.ArrayList;
import java.util.List;

public class CellEnvironment {
    private static List<CellEnvironment> instances = new ArrayList<>();

    private ArrayList<Molecule> molecules = new ArrayList<>();
    private int molConcentration;

    private Location location;
    private int diameter;

    public CellEnvironment(Location location, int diameter) {
        this.location = location;
        this.diameter = diameter;
        instances.add(this);
    }

    public static List<CellEnvironment> getAllInstances() {
        return instances;
    }

    public void addMolecule(Molecule molecule) {
        molecules.add(molecule);
    }

    public void removeMolecule(Molecule molecule) {
        molecules.remove(molecule);
    }

    public List<Molecule> getMolecules() {
        return molecules;
    }

    public void setMolConcentration() {
        molConcentration = 0;
        for (@SuppressWarnings("unused") Molecule molecule : molecules) {
            molConcentration++;
        }
    }

    public int getMolConcentration() {
        return molConcentration;
    }

    public Location getLocation() {
        return location;
    }

    public int getDiameter() {
        return diameter;
    }

    public boolean contains(Location location) {
        double distance = this.location.distanceTo(location);
        return distance < diameter / 2;
    }

    public boolean onBorder(Location location) {
        double distance = this.location.distanceTo(location);
        System.out.println(distance);
        return Math.abs(distance - diameter / 2) < 0.00001;
    }
}
