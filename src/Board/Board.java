package Board;

import Cube.Cube;
import Game.Player;
import Game.PlayerInput;

import java.util.ArrayList;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final int sizeBoard = 40;
    private final int sizeDeck = 16;
    private final Square[] board = new Square[sizeBoard];
    private Deck communityChest = new Deck();
    private Deck chance = new Deck();
    public Jail jail;
    public Cube cube;
    public List<Player> players;

    public Board(Jail jail, Cube cube, List<Player> players){
        this.jail = jail;
        this.cube = cube;
        this.players = players;

        //creating all squares on the board
        for(int i = 0; i < sizeBoard; i++){
            board[i] = createSquare(i);
            board[i].index = i;
        }

        //create community chest/chance deck
        for(int c = 0; c < sizeDeck; c++){
            communityChest.addCard(createCommunityChestCard(c));
            chance.addCard(createChanceCard(c));
        }

        communityChest.shuffleDeck();
        chance.shuffleDeck();
    }

    public Square getSquareAt(int position){
        return board[position];
    }

    public Square getCurrentSquare(Player player){
        return getSquareAt(player.getPosition());
    }

    private Square createSquare(int position){
        switch(position){
            case 0:
                return new Square("GO");
            case 1:
                return new PropertyColors("Mediterranean Avenue", PropertyColors.Group.BROWN, 60, 2, 10, 30, 90, 160, 250);
            case 2:
                return new CardDraw(communityChest, "Community Chest");
            case 3:
                return new PropertyColors("Baltic Avenue", PropertyColors.Group.BROWN, 60, 4, 20, 60, 180, 320, 450);
            case 4:
                return new Tax("INCOME TAX", 200);
            case 5:
                return new RailRoad("Reading Railroad");
            case 6:
                return new PropertyColors("Oriental Avenue", PropertyColors.Group.SKY, 100, 6, 30, 90, 270, 400, 550);
            case 7:
                return new CardDraw(chance, "Chance");
            case 8:
                return new PropertyColors("Vermont Avenue", PropertyColors.Group.SKY, 100, 6, 30, 90, 270, 400, 550);
            case 9:
                return new PropertyColors("Connecticut Avenue", PropertyColors.Group.SKY, 120, 8, 40, 100, 300, 450, 600);
            case 10:
                return new Square("Just Visiting Jail");
            case 11:
                return new PropertyColors("St. Charles Place", PropertyColors.Group.PINK, 140, 10, 50, 150, 450, 625, 750);
            case 12:
                return new Utility("Electric Company", cube);
            case 13:
                return new PropertyColors("States Avenue", PropertyColors.Group.PINK, 140, 10, 50, 150, 450, 625, 750);
            case 14:
                return new PropertyColors("Virginia Avenue", PropertyColors.Group.PINK, 160, 12, 60, 180, 500, 700, 900);
            case 15:
                return new RailRoad("Pennsylvania Railroad");
            case 16:
                return new PropertyColors("St. James Place", PropertyColors.Group.ORANGE, 180, 14, 70, 200, 550, 750, 950);
            case 17:
                return new CardDraw(communityChest, "Community Chest");
            case 18:
                return new PropertyColors("Tennessee Avenue", PropertyColors.Group.ORANGE, 180, 14, 70, 200, 550, 750, 950);
            case 19:
                return new PropertyColors("New York Avenue", PropertyColors.Group.ORANGE, 200, 16, 80, 220, 600, 800, 1000);
            case 20:
                return new Square("Free Parking");
            case 21:
                return new PropertyColors("Kentucky Avenue", PropertyColors.Group.RED, 220, 18, 90, 250, 700, 875, 1050);
            case 22:
                return new CardDraw(chance, "Chance");
            case 23:
                return new PropertyColors("Indiana Avenue", PropertyColors.Group.RED, 220, 18, 90, 250, 700, 875, 1050);
            case 24:
                return new PropertyColors("Illinois Avenue", PropertyColors.Group.RED, 240, 20, 100, 300, 750, 925, 1100);
            case 25:
                return new RailRoad("B&O Railroad");
            case 26:
                return new PropertyColors("Atlantic Avenue", PropertyColors.Group.YELLOW, 260, 22, 110, 330, 800, 975, 1150);
            case 27:
                return new PropertyColors("Ventnor Avenue", PropertyColors.Group.YELLOW, 260, 22, 110, 330, 800, 975, 1150);
            case 28:
                return new Utility("Water Works", cube);
            case 29:
                return new PropertyColors("Marvin Gardens", PropertyColors.Group.YELLOW, 280, 24, 120, 360, 850, 1025, 1200);
            case 30:
                return new Square("Go to Jail"){
                    @Override
                    public void doAction(Player currentPlayer){
                        jail.sendPlayerToJail(currentPlayer);
                    }
                };
            case 31:
                return new PropertyColors("Pacific Avenue", PropertyColors.Group.GREEN, 300, 26, 130, 390, 900, 1100, 1275);
            case 32:
                return new PropertyColors("North Carolina Avenue", PropertyColors.Group.GREEN, 300, 26, 130, 390, 900, 1100, 1275);
            case 33:
                return new CardDraw(communityChest, "Community Chest");
            case 34:
                return new PropertyColors("Pennsylvania Avenue", PropertyColors.Group.GREEN, 320, 28, 150, 450, 1000, 1200, 1400);
            case 35:
                return new RailRoad("Short Line");
            case 36:
                return new CardDraw(chance, "Chance");
            case 37:
                return new PropertyColors("Park Place", PropertyColors.Group.BLUE, 350, 35, 175, 500, 1100, 1300, 1500);
            case 38:
                return new Tax("LUXURY TAX", 100);
            case 39:
                return new PropertyColors("Boardwalk", PropertyColors.Group.BLUE, 400, 50, 200, 600, 1400, 1700, 2000);
            default:
                return null;
        }
    }

    private Card createCommunityChestCard(int index){
        switch(index){
            case 0:
                return new MoveToCard(new int[]{0}, this, "Advance to GO");
            case 1:
                return new CollectCard(100, "Life Insurance Matures");
            case 2:
                return new CollectCard(10, "Won Second Prize in a Beauty Contest");
            case 3:
                return new CollectCard(200, "Bank Error in Your Favor");
            case 4:
                return new CollectCard(45, "Sale of Stock");
            case 5:
                return new CollectCard(20, "Income Tax Refund");
            case 6:
                return new CollectCard(25, "Receive For Services");
            case 7:
                return new CollectCard(100, "You Inherit");
            case 8:
                return new CollectCard(100, "Xmas Fund Matures");
            case 9:
                return new CollectEveryCard(players, 50, "Grand Opera Opening");
            case 10:
                return new CollectCard(-50, "Doctor's Fee");
            case 11:
                return new CollectCard(-100, "Hospital Fee");
            case 12:
                return new CollectCard(-150, "School Tax");
            case 13:
                return new HouseRepairCard(40, 115, "Assessed for Street Repairs");
            case 14:
                return new ToJailCard(jail);
            case 15:
                return new OutOfJailCard();
            default:
                return null;
        }
    }

    private Card createChanceCard(int index){
        switch(index){
            case 0:
                return new MoveToCard(new int[]{0}, this, "Advance to GO");
            case 1:
                return new MoveToCard(new int[]{39}, this, "Take a Walk on the Boardwalk");
            case 2:
                return new MoveToCard(new int[]{24}, this, "Advance to Illinois Avenue");
            case 3:
                return new MoveToCard(new int[]{11}, this, "Advance to St. Charles Place");
            case 4:
                return new MoveToCard(new int[]{5}, this, "Take a ride on the Reading Railroad");
            case 5:
            case 6:
                return new MoveToCard(new int[]{5, 15, 25, 35}, this, "Advance to nearest Railroad");
            case 7:
                return new MoveToCard(new int[]{12, 28}, this, "Advance to nearest Utility");
            case 8:
                return new MoveCard(-3, this, "Go Back 3 Spaces");
            case 9:
                return new CollectCard(50, "Bank pays Dividend");
            case 10:
                return new CollectCard(150, "Your Building and Loan Matures");
            case 11:
                return new CollectCard(-15, "Poor Tax");
            case 12:
                return new CollectEveryCard(players, 50, "You Have Been Elected Chairman of the Board");
            case 13:
                return new HouseRepairCard(25, 100, "Make General Repairs on your Property");
            case 14:
                return new ToJailCard(jail);
            case 15:
                return new OutOfJailCard();
            default:
                return null;
        }
    }
}