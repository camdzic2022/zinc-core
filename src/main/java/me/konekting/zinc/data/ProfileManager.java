package me.konekting.zinc.data;

import me.konekting.zinc.data.Profile;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ProfileManager {

    private Map<UUID, Profile> data = new HashMap<>();

    public Profile getByUUID(UUID uuid){
        return data.get(uuid);
    }
}
