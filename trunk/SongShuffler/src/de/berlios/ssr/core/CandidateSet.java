package de.berlios.ssr.core;

import java.io.File;

/**
 * Definisce i metodi per gestire la lista di tutti i file che possono essere
 * scelti per venire copiati.
 * 
 * @author jack
 */
public interface CandidateSet {
    void addItem(MarkableFile... item);

    File getRandomItem();

    void removeItem(String path);

    void reset();

    void resetAllItemState();
}
