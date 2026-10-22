import java.util.ArrayDeque;
import java.util.Deque;

class SnakeGame {

    int height;
    int width;
    int[][] food;
    int score;
    boolean[][] occupied;
    int foodCounter = 0;
    Deque<int[]> snake = new ArrayDeque<>();

    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;
        this.occupied = new boolean[height][width];
        this.snake.offerFirst(new int[] {0,0});
        this.occupied[0][0] = true;
    }
    
    public int move(String direction) {
        int[] head = snake.peekFirst();
        int r = head[0];
        int c = head[1];
        switch (direction) {
            case "R":
                c++;
                break;
            case "L":
                c--;
                break;
            case "U":
                r--;
                break;
            case "D":
                r++;
                break;            

        }

        return validateMove(r,c);
    }

    private int validateMove(int r, int c) {

        if (r >= height || r < 0 || c >= width || c < 0) return -1;

        boolean eatingFood = false;
        if (foodCounter < food.length && food[foodCounter][0] == r && food[foodCounter][1] == c) eatingFood = true;

        if (!eatingFood) {
            int[] tail = snake.pollLast();
            occupied[tail[0]][tail[1]] = false;
        } else {
            score++;
            foodCounter++;
        }

        if (occupied[r][c]) return -1;

        snake.offerFirst(new int[] {r,c});
        occupied[r][c] = true;
        
        return score;
    }

    public static void main(String[] args) {
        SnakeGame obj = new SnakeGame(3, 2, new int[][]{{1, 2}, {0, 1}});
        System.out.println(obj.move("R"));
        System.out.println(obj.move("D"));
        System.out.println(obj.move("R"));
        System.out.println(obj.move("U"));
        System.out.println(obj.move("L"));
        System.out.println(obj.move("U"));
    }
}

