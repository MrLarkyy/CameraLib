package xyz.larkyy.cameralib.cameralib.animation;

import org.bukkit.util.Vector;
import xyz.larkyy.cameralib.cameralib.animation.keyframe.MovementKeyframe;
import xyz.larkyy.cameralib.cameralib.animation.keyframe.RotationKeyframe;
import xyz.larkyy.timelinelib.timelinelib.Timeline;
import xyz.larkyy.timelinelib.timelinelib.interpolation.InterpolatedTimeline;

import java.util.HashMap;
import java.util.Map;

public class CameraTimeline {


    private final Map<String,Timeline<?>> map = new HashMap<>();

    public CameraTimeline() {
        map.put("movement",new InterpolatedTimeline<MovementKeyframe>());
        map.put("rotation",new InterpolatedTimeline<RotationKeyframe>());
    }

    public CameraTimeline(InterpolatedTimeline<MovementKeyframe> movementTimeline, InterpolatedTimeline<RotationKeyframe> rotationTimeline) {
        map.put("movement",movementTimeline);
        map.put("rotation",rotationTimeline);
    }

    public void addRotation(double time, Vector rotation) {
        InterpolatedTimeline<RotationKeyframe> timeline = (InterpolatedTimeline<RotationKeyframe>) map.get("rotation");
        timeline.addFrame(time,new RotationKeyframe(rotation));
    }
    public void addMovement(double time, Vector vector) {
        InterpolatedTimeline<MovementKeyframe> timeline = (InterpolatedTimeline<MovementKeyframe>) map.get("movement");
        timeline.addFrame(time,new MovementKeyframe(vector));
    }

    public Map<String, Timeline<?>> toMap() {
        return map;
    }
}
