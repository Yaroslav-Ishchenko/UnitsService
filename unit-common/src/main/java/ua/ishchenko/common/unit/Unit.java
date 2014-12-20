package ua.ishchenko.common.unit;

import ua.ishchenko.common.weapon.Weapon;

import java.io.Serializable;

/**
 * Created by Yaroslav on 11/22/2014.
 */
public interface Unit extends Serializable{

    void atack();

    void showTheWeapon();

    void stopAtack();

    void hitAnEnemy();

    String getName();

    void setName(String name);

    Weapon getWeapon();

    void setWeapon(Weapon weapon);
}
