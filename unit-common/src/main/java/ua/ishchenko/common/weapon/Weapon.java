package ua.ishchenko.common.weapon;

import java.io.Serializable;

/**
 * Created by Yaroslav on 11/22/2014.
 */
public interface Weapon extends Serializable{

    boolean isSharp();

    void setSharp(boolean sharp);

    String getName();

    void setName(String name);
}

