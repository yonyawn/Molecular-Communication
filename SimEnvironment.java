import java.util.ArrayList;
import java.util.List;

public class SimEnvironment {
    public static final int WIDTH = 20;
    public static final int HEIGHT = 20;

    private List<CellEnvironment> cells = new ArrayList<>();
    private List<Molecule> molecules = new ArrayList<>();
    
    private int extraConc;

    public void simulate() {
        for (Molecule molecule : molecules) {
            molecule.move();
        }
    }

    public int getExtraConc() {
        return extraConc;
    }

    public void setExtraConc() {
        extraConc = 0;
        for (Molecule molecule : molecules) {
            if (!molecule.isInCell()) {
                extraConc++;
            }
        }
    }

    public static boolean isValidLocation(Location location) {
        return location.getX() >= 0 && location.getX() < WIDTH &&
               location.getY() >= 0 && location.getY() < HEIGHT;
    }

   public void addCell(CellEnvironment cell) {
        cells.add(cell);
    }

    public void removeCell(CellEnvironment cell) {
        cells.remove(cell);
    }

    public List<CellEnvironment> getCells() {
        return cells;
    }

    public void addMolecule(Molecule molecule) {
        molecules.add(molecule);
    } 
}
