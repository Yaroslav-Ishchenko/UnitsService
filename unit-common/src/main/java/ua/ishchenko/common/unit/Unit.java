package ua.ishchenko.common.unit;

import ua.ishchenko.common.weapon.Weapon;

import java.io.Serializable;

/**
 * Created by Yaroslav on 11/22/2014.
 */
public abstract class Unit implements Serializable{
    private static long uniqueId;
    static{
        uniqueId = 1;
    }
    public static void setUniqueIdCounter(long uniqueId)
    {
        Unit.uniqueId = uniqueId;
    }
    public static long getUniqueId() {
        return Unit.uniqueId++;
    }

    public abstract void atack();

    public abstract void showTheWeapon();

    public abstract void stopAtack();

    public abstract void hitAnEnemy();

    public abstract String getName();

    public abstract void setName(String name);

    public abstract Weapon getWeapon();

    public abstract void setWeapon(Weapon weapon);

    public abstract long getUnitId();

    public abstract void setUnitId(long unitId);
}
