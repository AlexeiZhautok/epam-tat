import Planes.experimentalPlane;
import models.MilitaryType;
import Planes.MilitaryPlane;
import Planes.PassengerPlane;
import Planes.Plane;

import java.util.*;

public class Airport {
    private List<? extends Plane> planes;


    public Airport(List<? extends Plane> planes) {
        this.planes = planes;
    }


    public List<PassengerPlane> getPassengerPlanes() {
        List<PassengerPlane> passengerPlanes = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane instanceof PassengerPlane) {
                passengerPlanes.add((PassengerPlane) plane);}}
        return passengerPlanes;
    }

    public List<MilitaryPlane> getMilitaryPlanes() {
        List<MilitaryPlane> militaryPlanes = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane instanceof MilitaryPlane) {
                militaryPlanes.add((MilitaryPlane) plane);}}
        return militaryPlanes;
    }

    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
        List<PassengerPlane> passengerPlanes = getPassengerPlanes();
        PassengerPlane planeWithMaxCapacity = passengerPlanes.get(0);
        for (int i = 0; i < passengerPlanes.size(); i++) {
            if (passengerPlanes.get(i).getPassengersCapacity() > planeWithMaxCapacity.getPassengersCapacity()) {
                planeWithMaxCapacity = passengerPlanes.get(i); } }
        return planeWithMaxCapacity; }

    public List<MilitaryPlane> getTransportMilitaryPlanes() {
    List<MilitaryPlane> transportMilitaryPlanes = new ArrayList<>();
    List<MilitaryPlane> militaryPlanes = getMilitaryPlanes();
    for (int i = 0; i < militaryPlanes.size(); i++) {
        if (militaryPlanes.get(i).getType() == MilitaryType.TRANSPORT) {
            transportMilitaryPlanes.add(militaryPlanes.get(i)); } }
    return transportMilitaryPlanes; }

    public List<MilitaryPlane> getBomberMilitaryPlanes() {
        List<MilitaryPlane> bomberMilitaryPlanes = new ArrayList<>();
        List<MilitaryPlane> militaryPlanes = getMilitaryPlanes();
        for (int i = 0; i < militaryPlanes.size(); i++) {
            if (militaryPlanes.get(i).getType() == MilitaryType.BOMBER) {
                bomberMilitaryPlanes.add(militaryPlanes.get(i)); } }
        return bomberMilitaryPlanes; }

    public List<experimentalPlane> getExperimentalPlanes() {
        List<experimentalPlane> experimentalPlanes = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane instanceof experimentalPlane) {
                experimentalPlanes.add((experimentalPlane) plane); } }
        return experimentalPlanes; }

    public Airport sortByMaxDistance() {
        Collections.sort(planes, new Comparator<Plane>() {
            public int compare(Plane o1, Plane o2) {
                return o1.getMaxFlightDistance() - o2.getMaxFlightDistance(); } } );
        return this; }


    public Airport sortByMaxSpeed() {
        Collections.sort(planes, new Comparator<Plane>() {
            public int compare(Plane firsPlane, Plane secondPlane) {
                return firsPlane.getMaxSpeed() - secondPlane.getMaxSpeed(); } } );
        return this; }

    public Airport sortByMaxLoadCapacity() {
        Collections.sort(planes, new Comparator<Plane>() {
            public int compare(Plane firsPlane, Plane secondPlane) {
                return firsPlane.getMaxLoadCapacity() - secondPlane.getMaxLoadCapacity(); } } );
        return this; }

    public List<? extends Plane> getPlanes() {
        return planes; }

    private void print(Collection<? extends Plane> collection) {
        while (collection.iterator().hasNext()) {
            Plane plane = collection.iterator().next();
            System.out.println(plane); } }

    @Override
    public String toString() {
        return "Airport{" +
                "Planes=" + planes.toString() +
                '}'; }
}
