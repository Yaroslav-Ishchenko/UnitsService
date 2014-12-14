package ua.ishchenko.common;


import javax.ws.rs.core.Response;

import ua.ishchenko.common.unit.Unit;

import java.util.List;

public interface UnitServiceCommon {
    Response addUnit(Unit unit);/*add single user*/

    Response getUnits();/*get the whole list of users*/

    Response getUnit(String id);/*get the user*/

    Response updateUnit(Unit unit);/*if exists update the user if not just error*/

    Response deleteUnits();/*delete all units*/

    Response deleteUnit(String name);/*delete the user*/
}
