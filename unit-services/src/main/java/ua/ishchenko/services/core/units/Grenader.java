package ua.ishchenko.services.core.units;


import ua.ishchenko.common.unit.Unit;
import ua.ishchenko.common.weapon.Weapon;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.io.Serializable;

@XmlRootElement
@XmlSeeAlso(Grenader.class)
public class Grenader implements Unit,Serializable {

    @XmlElement
    private String name;
    @XmlElement
    private Weapon weapon;

    public Grenader() {
        name = "Grenader";
    }

    public Grenader(String name) {
        this.name = name;
    }

    public Grenader(Weapon weapon) {
        this.weapon = weapon;
    }

    public Grenader(String name, Weapon weapon) {
        this.name = name;
        this.weapon = weapon;
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
    public String getName()
    {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}