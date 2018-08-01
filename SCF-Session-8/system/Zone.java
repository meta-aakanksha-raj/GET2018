package system;

import java.util.ArrayList;
import java.util.List;

public class Zone {

	private AnimalCategory zoneType;
	private final int capacity;
	private boolean hasCanteen,hasPark;
	private List<Cage> listOfCages = new ArrayList<>();
	
	public Zone(AnimalCategory zoneType, int capacity, boolean hasPark, boolean hasCanteen)
	{
		this.zoneType = zoneType;
		this.capacity = capacity;
		this.hasPark = hasPark;
		this.hasCanteen = hasCanteen;
	}

	public AnimalCategory getZoneType() {
		return zoneType;
	}

	public void setZoneType(AnimalCategory zoneType) {
		this.zoneType = zoneType;
	}

	public boolean isHasPark() {
		return hasPark;
	}

	public void setHasPark(boolean hasPark) {
		this.hasPark = hasPark;
	}

	public boolean isHasCanteen() {
		return hasCanteen;
	}

	public void setHasCanteen(boolean hasCanteen) {
		this.hasCanteen = hasCanteen;
	}

	public int getCapacity() {
		return capacity;
	}
	
	public int spareCapacity() {
		return capacity - listOfCages.size();
	}
}
	

