package ua.ishchenko.services.core.units;

import ua.ishchenko.unit.Unit;
import ua.ishchenko.weapon.Weapon;

import java.lang.Override;import java.lang.String;

public class Grenader implements Unit {
    private String name;
    private Weapon weapon;

    public Grenader() {
        name = "Unknown";
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
}