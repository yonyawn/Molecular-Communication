public class Molecule {
    private Location location;
    private boolean isInCell;
    private boolean isOnCellBorder;

    public Molecule(Location location) {
        this.location = location;
        setCellLocation();
    }

    public Location getLocation() {
        return location;
    }

    public boolean isInCell() {
        return isInCell;
    }

    public boolean isOnCellBorder() {
        return isOnCellBorder;
    }

    public void setCellLocation() {
        for (CellEnvironment cellEnvironment : CellEnvironment.getAllInstances()) {
            if (cellEnvironment.onBorder(location)) {
                isOnCellBorder = true;
                isInCell = false;
            } else if (cellEnvironment.contains(location)) {
                isInCell = true;    
                cellEnvironment.addMolecule(this);
                isOnCellBorder = false;
            } else {
                isInCell = false;
                isOnCellBorder = false;
            }
        }
    }

    public void move() {
        location = location.randomAdjacentLocation();
        setCellLocation();
    }
}
