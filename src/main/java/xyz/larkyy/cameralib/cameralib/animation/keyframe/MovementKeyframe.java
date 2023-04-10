package xyz.larkyy.cameralib.cameralib.animation.keyframe;

import org.bukkit.util.Vector;
import xyz.larkyy.animationlib.animationlib.timeline.InterpolatedKeyframe;

public class MovementKeyframe extends InterpolatedKeyframe implements CameraKeyframe {

    public MovementKeyframe(Vector vector) {
        super(vector);
    }

    @Override
    public void run() {
    }
}
