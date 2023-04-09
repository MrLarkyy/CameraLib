package xyz.larkyy.cameralib.cameralib;

import org.bukkit.Location;
import xyz.larkyy.cameralib.cameralib.animation.CameraAnimation;
import xyz.larkyy.cameralib.cameralib.animation.CameraAnimationHandler;

public class Camera {

    private Location location;
    private final CameraHolder cameraHolder;
    private final CameraAnimationHandler animationHandler;

    public Camera(Location location, CameraHolder cameraHolder) {
        this.location = location;
        this.cameraHolder = cameraHolder;
        this.animationHandler = new CameraAnimationHandler();
    }

    public void runAnimation(String id, CameraAnimation animation) {
        animationHandler.run(id,animation);
    }

    public void stopAnimation(String id) {
        animationHandler.stop(id);
    }

    public void stopAnimations() {
        animationHandler.stopAll();
    }

    public CameraAnimationHandler getAnimationHandler() {
        return animationHandler;
    }

    public void tick() {
        animationHandler.update();

        var running = animationHandler.getRunning();
        if (running == null) {
            return;
        }

        var newLocation = location.clone();

        var move = animationHandler.getMovement();
        var rotate = animationHandler.getRotation();

        if (move == null && rotate == null) {
            return;
        }

        if (move != null) {
            newLocation.add(move);
        }
        if (rotate != null) {
            newLocation.setPitch((float) rotate.getX());
            newLocation.setYaw((float) rotate.getY());
        }

        cameraHolder.move(newLocation);
    }

    public void teleport(Location location) {
        animationHandler.stopAll();
        this.location = location;
        cameraHolder.teleport(location);
    }

    public void remove() {
        cameraHolder.remove();
    }


    public Location getLocation() {
        return location;
    }
}
