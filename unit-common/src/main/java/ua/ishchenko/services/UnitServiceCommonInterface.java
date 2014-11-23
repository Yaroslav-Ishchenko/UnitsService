package ua.ishchenko.services;

import ua.ishchenko.unit.Unit;

import javax.ws.rs.core.Response;
import java.util.List;

/**
 *
 * Created by Yaroslav on 11/26/2014.
 */
public interface UnitServiceCommonInterface {


    Response addUnits(List<Unit> list);/*add list consist of users*/

    Response addUnit(Unit unit);/*add single user*/

    List getUnits();/*get the whole list of users*/

    Unit getUnit(String name);/*get the user*/

    Response updateUnit(Unit unit);/*if exists update the user if not just error*/

    Response deleteUnits();/*delete all units*/

    Response deleteUnit(String name);/*delete the user*/
}
