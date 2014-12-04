package ua.ishchenko.common;

import ua.ishchenko.common.unit.Unit;

import javax.ws.rs.core.Response;
import java.util.List;

public interface UnitServiceCommon {
    Response addUnit(Unit unit);/*add single user*/
    List getUnits();/*get the whole list of users*/
    Unit getUnit(String id);/*get the user*/
    Response updateUnit(Unit unit);/*if exists update the user if not just error*/
    Response deleteUnits();/*delete all units*/
    Response deleteUnit(String name);/*delete the user*/
}
