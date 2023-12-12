package Board;

import Game.Player;
import java.util.Objects;

public class Square implements Comparable<Square>, Cloneable{
    protected int index;
    protected final String name;

    public Square(String name){
        this.name = name;
    }

    public void doAction(Player currentPlayer){};

    public String toString(){
        return name;
    }

    public int compareTo(Square s){
        if(index < s.index){
            return -1;
        } else if (index == s.index){
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public Square clone() {
        try {
            return (Square) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Cloning not supported for Square");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Square square = (Square) obj;
        return index == square.index &&
                Objects.equals(name, square.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, name);
    }
}

