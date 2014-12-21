package ua.ishchenko.services.core.units;


import ua.ishchenko.common.unit.Unit;
import ua.ishchenko.common.weapon.Weapon;
import ua.ishchenko.services.core.weapons.Scythe;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso(Grenadier.class)
public class Grenadier extends Unit {

    @XmlElement
    private long unitId;
    @XmlElement
    public String name;
    @XmlElement(name = "weapon")
    public Scythe weapon;


    public Grenadier() {
        this("Grenadier");
    }

    public Grenadier(String name) {
        this(name, null);

    }

    /*public Grenadier(Weapon weapon) {
        //this.weapon = weapon;
    }
*/
    public Grenadier(String name, Scythe weapon) {
        unitId = Unit.getUniqueId();
        this.name = name;
        this.weapon = weapon == null ? new Scythe() : weapon;
    }

    @Override
    public void atack() {

    }

    @Override
    public void showTheWeapon() {

    }

    @Override
    public void stopAtack() {

    }

    @Override
    public void hitAnEnemy() {

    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Weapon getWeapon() {
        return weapon;
    }

    @Override
    public void setWeapon(Weapon weapon) {
        if (weapon instanceof Scythe)
            this.weapon = (Scythe) weapon;
        else
            throw new RuntimeException("setWeapon() method Supports only Scythe type");
    }

    @Override
    public boolean equals(Object a) {
        return (a instanceof Grenadier ? name.equals(((Grenadier) a).getName()) : false);

    }

    @Override
    public long getUnitId() {
        return unitId;
    }

    @Override
    public void setUnitId(long unitId) {
        this.unitId = unitId;
    }
}