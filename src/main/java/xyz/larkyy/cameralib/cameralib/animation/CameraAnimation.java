package xyz.larkyy.cameralib.cameralib.animation;

import org.bukkit.util.Vector;
import xyz.larkyy.animationlib.animationlib.Animation;
import xyz.larkyy.animationlib.animationlib.LoopMode;
import xyz.larkyy.cameralib.cameralib.animation.keyframe.MovementKeyframe;
import xyz.larkyy.cameralib.cameralib.animation.keyframe.RotationKeyframe;
import xyz.larkyy.timelinelib.timelinelib.interpolation.InterpolatedTimeline;

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
