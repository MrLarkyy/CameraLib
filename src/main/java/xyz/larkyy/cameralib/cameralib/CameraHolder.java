package xyz.larkyy.cameralib.cameralib;

import org.bukkit.Location;

public interface CameraHolder {
    void teleport(Location location);
    void move(Location location);
    void remove();
}
