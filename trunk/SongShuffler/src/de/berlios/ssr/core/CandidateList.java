package de.berlios.ssr.core;

/**
 * Definisce i metodi per gestire la lista di tutti i file che possono essere
 * scelti per venire copiati
 * 
 * @author jack
 */
public interface CandidateList {
    void addItem();

    void addList();

    void getRandomItem();

    void removeItem();

    void reset();

    void resetAllItemState();
}
