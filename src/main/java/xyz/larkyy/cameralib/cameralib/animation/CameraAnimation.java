package xyz.larkyy.cameralib.cameralib.animation;

import org.bukkit.util.Vector;
import xyz.larkyy.animationlib.animationlib.animation.Animation;
import xyz.larkyy.animationlib.animationlib.animation.LoopMode;
import xyz.larkyy.animationlib.animationlib.timeline.InterpolatedTimeline;
import xyz.larkyy.cameralib.cameralib.animation.keyframe.MovementKeyframe;
import xyz.larkyy.cameralib.cameralib.animation.keyframe.RotationKeyframe;

public class CameraAnimation extends Animation {
    public CameraAnimation(LoopMode loopMode, double length, double speed, CameraTimeline cameraTimeline) {
        super(loopMode, length, speed, cameraTimeline.toMap());
    }

    public Vector getRotation() {
        InterpolatedTimeline<RotationKeyframe> timeline = (InterpolatedTimeline<RotationKeyframe>) getTimeline("rotation");
        return timeline.getInterpolatedValue(getTime());
    }

    public Vector getMovement() {

        InterpolatedTimeline<MovementKeyframe> timeline = (InterpolatedTimeline<MovementKeyframe>) getTimeline("movement");
        return timeline.getInterpolatedValue(getTime());
    }
}
