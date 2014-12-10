package ua.ishchenko.common.unit;

import java.io.Serializable;

/**
 * Created by Yaroslav on 11/22/2014.
 */
public interface Unit extends Serializable{

    void atack();

    void showTheWeapon();

    void stopAtack();

    void hitAnEnemy();
}
