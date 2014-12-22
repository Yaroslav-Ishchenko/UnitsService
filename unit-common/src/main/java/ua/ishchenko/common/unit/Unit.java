package ua.ishchenko.common.unit;

import ua.ishchenko.common.weapon.Weapon;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

/**
 * Created by Yaroslav on 11/22/2014.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso(Unit.class)
public abstract class Unit implements Serializable {
    protected static long uniqueIDCounter;

    static {
        uniqueIDCounter = 1;
    }

    public abstract void atack();

    public abstract void showTheWeapon();

    public abstract void stopAtack();

    public abstract void hitAnEnemy();

    public abstract String getName();

    public abstract void setName(String name);

    public abstract void setWeapon(Weapon weapon);

    public abstract Weapon getWeapon();

    public abstract void setUnitId(long id);

    public abstract long getUnitId();

    public long getUniqueID() {
        return uniqueIDCounter++;
    }


}
