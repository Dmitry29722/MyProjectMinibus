package controller;


import java.util.Map;
import model.Minibus;
import model.Route;


public interface ControllerMenager {
	public void addMinibus(Minibus minibus);
	public void addRoute(Route route);
	public String[] getAllKeysInCollection(Map<String, ?> map);
	
}
