package ua.ishchenko.services.core.weapons;


import ua.ishchenko.common.weapon.Weapon;

import javax.xml.bind.annotation.*;

/**
 * Created by Yaroslav on 11/22/2014.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso(Scythe.class)
public class Scythe implements Weapon {
    @XmlElement
    String name;
    @XmlElement
    boolean sharp;

    public Scythe() {
        name = "Lucida";
        sharp = true;
    }

    @Override
    public boolean isSharp() {
        return sharp;
    }

    @Override
    public void setSharp(boolean sharp) {
        this.sharp = sharp;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

}
