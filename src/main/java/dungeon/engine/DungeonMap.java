package dungeon.engine;

public class DungeonMap {
    private final int size;
    private final Cell[][] grid;

    public DungeonMap(int size) {
        this.size = size;
        this.grid = new Cell[size][size];
        fillWithEmptyCells();
    }

    private void fillWithEmptyCells() {
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                EmptyCell cell = new EmptyCell();
                cell.setPrefSize(60, 60);
                cell.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
                grid[y][x] = cell;
            }
        }
    }

    public int getSize() {
        return size;
    }

    public Cell getCell(int x, int y) {
        if (x < 0 || y < 0 || x >= size || y >= size) return null;
        return grid[y][x];
    }

    public void setCell(int x, int y, Cell cell) {
        if (x >= 0 && y >= 0 && x < size && y < size) {
            cell.setPrefSize(60, 60);
            cell.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
            grid[y][x] = cell;
        }
    }

    public Cell[][] getFullGrid() {
        return grid;
    }
}
