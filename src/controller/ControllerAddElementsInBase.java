package controller;

import java.util.Map;
import model.Minibus;
import model.Route;

public class ControllerAddElementsInBase implements ControllerMenager {

	@Override
	public void addMinibus(Minibus minibus) {
		ControllerBase.getMinibuses().put(minibus.getCarNumber(), minibus);
	}

	@Override
	public void addRoute(Route route) {
		ControllerBase.getRoutes().put(
				route.getDeparturePoint() + "-" + route.getPlaceOfArrival(),
				route);
	}

	@Override
	public String[] getAllKeysInCollection(Map<String, ?> map) {
		return map.keySet().toArray(new String[map.keySet().size()]);
	}
	
	
}
