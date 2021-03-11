/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.vehicle.showroom.subjects;

import org.vehicle.showroom.observers.Observer;

/**
 *
 * @author pc
 */
public interface Subject {
    void register(Observer observer);
    void unregister(Observer observer);
    void notifyAllObservers(int input);
}
