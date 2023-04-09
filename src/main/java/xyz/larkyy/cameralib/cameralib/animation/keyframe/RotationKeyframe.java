package xyz.larkyy.cameralib.cameralib.animation.keyframe;

import org.bukkit.util.Vector;
import xyz.larkyy.timelinelib.timelinelib.interpolation.InterpolatedKeyframe;

public class RotationKeyframe extends InterpolatedKeyframe implements CameraKeyframe {
    public RotationKeyframe(Vector vector) {
        super(vector);
    }

    @Override
    public void run() {

    }
}
