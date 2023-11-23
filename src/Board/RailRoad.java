package Board;

public class RailRoad extends Property {
    public RailRoad(String name){
        super(name, 200, 0);
    }

    @Override
    public int getRent() {
        int rent;

        switch(owner.getNumRailroads()){
            case 1:
                rent = 25;
                break;
            case 2:
                rent = 50;
                break;
            case 3:
                rent = 100;
                break;
            case 4:
                rent = 200;
                break;
            default:
                rent = -1;
                break;
        }

        return rent;
    }
}