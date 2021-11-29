package main.java.com.model;

import java.util.Set;

import main.java.com.utility.Direction;
import main.java.com.utility.Position;

/**
 * The snake entity, which is able to move around the map and eat the eatable entities.
 *
 */
public interface Snake extends GameEntity {

    /**
     * 
     * @return the current direction in which the snake is moving.
     */
    Direction getDirection();

    /**
     * Set the new moving direction.
     * @param dir
     */
    void setDirection(Direction dir);

    /**
     * Computes the next position in which the snake would move. 
     * @return the next position.
     */
    Position nextPosition();

    /**
     * 
     * @return a set of Position of all of the snake's body.
     */
    Set<Position> getBodyPosition();

    /**
     * Increases the length of the snake by one unit.
     */
    void increaseLength();

    /**
     * Move the snake by one step and update all of its positions.
     */
    void move();
}