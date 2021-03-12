
package org.vehicle.showroom.subjects;

import org.vehicle.showroom.constants.Enums.VehicleState;
import org.vehicle.showroom.observers.IObserver;


public interface ISubject {
    void register(IObserver observer);
    void unregister(IObserver observer);
    void notifyAllObservers(VehicleState state);
}
