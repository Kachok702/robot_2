import java.math.*;
import java.util.Arrays;

public class robot2 {
    public static void main(String[] args) {
        Robot robot = new Robot(2, -6, Direction.RIGHT);
        moveRobot(robot, -3, 12);
    }

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    public static class Robot {
        int x;
        int y;
        Direction dir;

        public Robot(int x, int y, Direction dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }

        public Direction getDirection() {
            return dir;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void turnLeft() {
            if (dir == Direction.UP) {
                dir = Direction.LEFT;
            } else if (dir == Direction.DOWN) {
                dir = Direction.RIGHT;
            } else if (dir == Direction.LEFT) {
                dir = Direction.DOWN;
            } else if (dir == Direction.RIGHT) {
                dir = Direction.UP;
            }
        }

        public void turnRight() {
            if (dir == Direction.UP) {
                dir = Direction.RIGHT;
            } else if (dir == Direction.DOWN) {
                dir = Direction.LEFT;
            } else if (dir == Direction.LEFT) {
                dir = Direction.UP;
            } else if (dir == Direction.RIGHT) {
                dir = Direction.DOWN;
            }
        }

        public void stepForward() {
            if (dir == Direction.UP) {
                y++;
            }
            if (dir == Direction.DOWN) {
                y--;
            }
            if (dir == Direction.LEFT) {
                x--;
            }
            if (dir == Direction.RIGHT) {
                x++;
            }
        }
    }

    public static void moveRobot(Robot robot, int toX, int toY) {
        // your code
        int x = robot.getX();
        int y = robot.getY();
        var dir = robot.dir;
        if (toX > x) {
            switch (dir) {
                case UP:
                    robot.turnRight();
                    dir = robot.dir;
                    break;
                case DOWN:
                    robot.turnLeft();
                    dir = robot.dir;
                    break;
                case RIGHT:
                    break;
                case LEFT:
                    robot.turnLeft();
                    robot.turnLeft();
                    dir = robot.dir;
                    break;
            }
            while (x != toX) {
                robot.stepForward();
                x = robot.getX();
            }
        } else if (toX < x) {
            switch (dir) {
                case UP:
                    robot.turnLeft();
                    dir = robot.dir;
                    break;
                case DOWN:
                    robot.turnRight();
                    dir = robot.dir;
                    break;
                case RIGHT:
                    robot.turnLeft();
                    robot.turnLeft();
                    dir = robot.dir;
                    break;
                case LEFT:
                    break;
            }
            while (x != toX) {
                robot.stepForward();
                x = robot.getX();
            }
        }
        if (toY > y) {
            switch (dir) {
                case UP:
                    break;
                case DOWN:
                    robot.turnRight();
                    robot.turnRight();
                    dir = robot.dir;
                    break;
                case RIGHT:
                    robot.turnLeft();
                    dir = robot.dir;
                    break;
                case LEFT:
                    robot.turnRight();
                    dir = robot.dir;
                    break;
            }
            while (y != toY) {
                robot.stepForward();
                y = robot.getY();
            }
        } else if (toY < y) {
            switch (dir) {
                case UP:
                    robot.turnLeft();
                    robot.turnLeft();
                    dir = robot.dir;
                    break;
                case DOWN:
                    break;
                case RIGHT:
                    robot.turnRight();
                    dir = robot.dir;
                    break;
                case LEFT:
                    robot.turnLeft();
                    dir = robot.dir;
                    break;
            }
            while (y != toY) {
                robot.stepForward();
                y = robot.getY();
            }
        }
        System.out.println((x == toX) & (y == toY));
        System.out.print("х: " + x + " у: " + y);
    }
}
