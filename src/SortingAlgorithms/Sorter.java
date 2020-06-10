package SortingAlgorithms;

import GUI.SortVisualizer;

/**
 * Base interface for the sort algorithms
 * @author Matt Hopson
 */
public abstract class Sorter
{
    public abstract void sort(SortVisualizer array);
    public abstract String toString();
    public abstract long getDelay();
}