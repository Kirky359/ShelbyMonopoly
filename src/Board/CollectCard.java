package Board;

import Game.Player;

class CollectCard extends Card {
    protected Integer amount;

    public CollectCard(int amount, String text) {
        super(createCollectMessage(amount, text));
        this.amount = amount;
    }

    protected static String createCollectMessage(int amount, String text) {
        String collectMessage = text + ". Collect $" + amount;
        String payMessage = text + ". Pay $" + -amount;
        return (amount > 0) ? collectMessage : payMessage;
    }

    public void doAction(Player player) {
        player.addMoney(amount);
    }
}
