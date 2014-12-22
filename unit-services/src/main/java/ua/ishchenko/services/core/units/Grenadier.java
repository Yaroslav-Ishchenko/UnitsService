package ua.ishchenko.services.core.units;


import ua.ishchenko.common.unit.Unit;
import ua.ishchenko.common.weapon.Weapon;
import ua.ishchenko.services.core.weapons.Scythe;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.Objects;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso(Grenadier.class)
public class Grenadier extends Unit {

    @XmlElement(name = "warriorUniqueId")
    public long id;
    @XmlElement
    public String name;
    @XmlElement(name = "weap")
    public Scythe weapon;


    public Grenadier() {
        this("Grenadier");
    }

    public Grenadier(String name) {
        this(name, new Scythe());
    }

    /*public Grenadier(Weapon weapon) {
        //this.weapon = weapon;
    }
*/
    public Grenadier(String name, Scythe weapon) {
        this.name = name;
        this.weapon = weapon;
        id = getUniqueID();
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
    public void setWeapon(Weapon weapon) {
        if(weapon instanceof  Scythe)
        this.weapon = (Scythe)weapon;
    }

    @Override
    public Weapon getWeapon() {
        return weapon;
    }

    @Override
    public void setUnitId(long id) {
        this.id = id;
    }
    @Override
    public long getUnitId() {
        return this.id;
    }
    @Override
    public boolean equals(Object a) {
        return (a instanceof Grenadier ? name.equals(((Grenadier) a).getName()) : false);

    }
}