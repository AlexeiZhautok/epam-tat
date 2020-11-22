package Planes;

import models.ClassificationLevel;
import models.ExperimentalTypes;

import java.util.Objects;

public class experimentalPlane extends Plane{
    private ExperimentalTypes type;
    private ClassificationLevel classificationLevel;

    public experimentalPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, ExperimentalTypes type, ClassificationLevel classificationLevel) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.type = type;
        this.classificationLevel = classificationLevel; }

    public ClassificationLevel getClassificationLevel(){
        return classificationLevel;
    }

    public void setClassificationLevel(ClassificationLevel classificationLevel){ this.classificationLevel = classificationLevel; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof experimentalPlane)) return false;
        if (!super.equals(o)) return false;
        experimentalPlane that = (experimentalPlane) o;
        return type == that.type && getClassificationLevel() == that.getClassificationLevel(); }


    @Override
    public int hashCode() { return Objects.hash(super.hashCode(), type, getClassificationLevel()); }

    @Override
    public String toString() {
        return "experimentalPlane{" +
                "model='" + model + '\'' +
                '}'; } }
