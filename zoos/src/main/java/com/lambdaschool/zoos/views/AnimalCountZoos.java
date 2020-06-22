package com.lambdaschool.zoos.views;

/**
 * View to display the results of the getCountAnimalZoos() custom query
 * @see AnimalRepository#getCountAnimalZoos() AnimalRepository.getCountAnimalZoos()
 */
public interface AnimalCountZoos {
    String getAnimalType();
    long getAnimalId();
    int getCountZoos();
}
