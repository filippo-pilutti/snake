package main.java.com.controller;

import main.java.com.model.Model;
import main.java.com.view.View;

public class CollisionManagerImpl implements CollisionManager {

    private final ScoreManager sm;

    public CollisionManagerImpl(final ScoreManager scoreMan) {
        sm = scoreMan;
    }

    @Override
    public void manageAppleCollision(final View view, final Model model) {
        if (detectAppleCollision(view)) {
            model.eatApple();
            sm.updateScore();
            sm.saveScore();
            sm.showHiScore();
        }
    }

    @Override
    public void manageWallOrBodyCollision(final View view, final Model model) {
        if (detectWallCollision(view) || detectBodyCollision(view)) {
            model.getSnake().die();
            view.getFrame().setEnabled(false);
            view.showGameOver();
        }
    }

    private boolean detectAppleCollision(final View view) {
        return view.getMapView().getAppleView().getRect().contains(view.getMapView().getSnakeView().getHeadCenter());
    }

    private boolean detectWallCollision(final View view) {
        return !view.getMapView().getMapBounds().contains(view.getMapView().getSnakeView().getHeadCenter());
    }

    private boolean detectBodyCollision(final View view) {
        return view.getMapView().getSnakeView().getBodyRects().stream().anyMatch(r -> r.contains(view.getMapView().getSnakeView().getHeadCenter()));
    }

}
