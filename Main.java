public class Main {
    public static void main(String[] args) {
        
        // Create a new molecule at location (15, 10)
        Location location = new Location(15, 10);
        Molecule molecule = new Molecule(location);
        System.out.println("New molecule created at X:" + molecule.getLocation().getX() + " Y:" + molecule.getLocation().getY());

        // Create a new cell at location (10, 10) with a diameter of 10
        CellEnvironment cellEnvironment = new CellEnvironment(new Location(10, 10), 10);
        System.out.println("Cell created at X:" + cellEnvironment.getLocation().getX() + " Y:" + cellEnvironment.getLocation().getY() 
        + " Diameter:" + cellEnvironment.getDiameter());
        
        // Create a new simulation environment and add the cell and molecule to it
        SimEnvironment simEnvironment = new SimEnvironment();
        System.out.println("Sim Environment created with width:" + SimEnvironment.WIDTH + " and height:" + SimEnvironment.HEIGHT);
        simEnvironment.addCell(cellEnvironment);
        simEnvironment.addMolecule(molecule);
        simEnvironment.setExtraConc();
        System.out.println("Cell and Molecule added to Sim Environment");

        //check if the molecule is in the cell or on the cell border
        molecule.setCellLocation();
        
        // check the extracellular concentration,
        // if the molecule is on the cell border and if the molecule is in the cell 
        System.out.println("Extracellular concentration:" + simEnvironment.getExtraConc());
        System.out.println("Is molecule on cell border?:" + molecule.isOnCellBorder());
        System.out.println("Is molecule in cell?:" + molecule.isInCell());

        // simulate the environment 10 times and check the extracellular concentration, 
        // if the molecule is on the cell border and if the molecule is in the cell while the cell moves
        int x = 0;
        while (x < 10) {
            simEnvironment.simulate();
            simEnvironment.setExtraConc();
            System.out.println("Extracellular concentration:" + simEnvironment.getExtraConc());
            System.out.println("Is molecule on cell border?:" + molecule.isOnCellBorder());
            System.out.println("Is molecule in cell?:" + molecule.isInCell());
            x++;
        }
    }
}
