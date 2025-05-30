package dungeon.engine;

public class Player {
    private int x;
    private int y;
    private int hp;
    private int gold;
    private int steps;
    private int score;

    public Player(int startX, int startY) {
        this.x = startX;
        this.y = startY;
        this.hp = 10;
        this.gold = 0;
        this.steps = 0;
        this.score = 0;
    }

    public void moveTo(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void incrementSteps() {
        this.steps++;
    }

    public void addGold(int amount) {
        this.gold += amount;
        this.score += amount * 2;
    }

    public void addHp(int amount) {
        this.hp = Math.min(10, this.hp + amount);
    }

    public void reduceHp(int amount) {
        this.hp -= amount;
    }

    public void addScore(int amount) {
        this.score += amount;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public int getHp() { return hp; }
    public int getGold() { return gold; }
    public int getSteps() { return steps; }
    public int getScore() { return score; }
}
