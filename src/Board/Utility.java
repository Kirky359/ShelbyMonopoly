package Board;
import Cube.*;
public class Utility extends Property {
    private  Cube cube;

    public Utility(String name,Cube cube){
        super(name, 150, 0);
        this.cube = cube;
    }

    @Override
    public int getRent() {
        int rent;
        int roll = cube.rollCube();

        switch(owner.getNumUtilities()){
            case 1:
                rent = 4 * roll;
                break;
            case 2:
                rent = 10 * roll;
                break;
            default:
                rent = -1;
                break;
        }

        return rent;
    }
}
