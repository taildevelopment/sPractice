package xyz.damt.util;

import lombok.experimental.UtilityClass;
import org.bukkit.ChatColor;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@UtilityClass
public class CC {

    public String translate(String input) {
        return ChatColor.translateAlternateColorCodes('&', input);
    }

    public List<String> translate(List<String> strings) {
        return strings.stream().map(CC::translate).collect(Collectors.toList());
    }

    public List<String> serializePotionEffects(List<PotionEffect> effects) {
        List<String> strings = new ArrayList<>();
        effects.forEach(effect -> {
            strings.add(effect.getType().getName() + ":" + effect.getAmplifier() + ":" + effect.getDuration());
        });
        return strings;
    }

    public List<PotionEffect> deserializePotionEffects(List<String> strings) {
        List<PotionEffect> effects = new ArrayList<>();
        strings.forEach(string -> {
            String[] args = string.split(":");
            effects.add(new PotionEffect(PotionEffectType.getByName(args[0]), Integer.parseInt(args[2]), Integer.parseInt(args[1])));
        });
        return effects;
    }

    public boolean isNumber(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public List<String> listUUIDToString(List<UUID> uuids) {
        return uuids.stream().map(UUID::toString).collect(Collectors.toList());
    }

    public List<UUID> listStringToUUID(List<String> strings) {
        return strings.stream().map(UUID::fromString).collect(Collectors.toList());
    }

    public boolean isDouble(double number) {
        return !((number % 1) == 0);
    }

}
