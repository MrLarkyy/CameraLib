package xyz.larkyy.cameralib.cameralib.animation;

import org.bukkit.util.Vector;

import java.util.HashMap;
import java.util.Map;

public class CameraAnimationHandler {

    private final Map<String, CameraAnimation> animations = new HashMap<>();

    public void update() {
        var set = this.animations.keySet();
        if (set.size() < 1) {
            return;
        }

        var id = set.stream().findFirst().get();
        var animation = animations.get(id);
        if (!animation.update()) {
            animations.remove(id);
        }
    }

    public void run(String identifier, CameraAnimation animation) {
        animations.put(identifier,animation);
    }

    public Vector getMovement() {
        var running = getRunning();
        if (running == null) {
            return null;
        }
        return running.getMovement();
    }

    public Vector getRotation() {
        var running = getRunning();
        if (running == null) {
            return null;
        }
        return running.getRotation();
    }

    public boolean isRunning(String identifier) {
        var first = animations.keySet().stream().findFirst();
        return first.map(s -> (s.equals(identifier))).orElse(false);
    }

    public CameraAnimation getRunning() {
        var first = animations.keySet().stream().findFirst();
        return first.map(animations::get).orElse(null);
    }

    public boolean isQueued(String identifier) {
        return animations.containsKey(identifier);
    }

    public void stopAll() {
        animations.clear();
    }

    public void stop(String identifier) {
        animations.remove(identifier);
    }

    public void stopRunning() {
        var first = animations.keySet().stream().findFirst();
        if (!first.isPresent()) {
            return;
        }
        animations.remove(first.get());
    }

}
