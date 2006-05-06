package de.berlios.ssr.core;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

/**
 * Definisce le operazioni basilari per configurare il core e metodi per
 * reperire l'attuale configurazione.
 * 
 * @author jack
 */
public interface Configuration {

    /**
     * Imposta tutti i valori a quelli di default.
     */
    public void setDefault();

    /**
     * Imposta come predefinita la configurazione corrente.
     */
    public void setCurrentAsDefault();

    /**
     * Aggiunge un percorso di partenza, deve essere una directory.
     * 
     * @param pathname
     *            il percorso.
     * @throws IllegalArgumentException
     *             se pathname non è una directory.
     */
    public void addSourcePath(File pathname) throws IllegalArgumentException;

    /**
     * Aggiunge un percorso di partenza, deve essere una directory.
     * 
     * @param pathname
     *            un array di percorsi.
     * @throws IllegalArgumentException
     *             se uno dei percorsi non è una directory.
     */
    public void addSourcePath(File[] pathname) throws IllegalArgumentException;

    /**
     * Imposta il percorso di destinazione, deve essere una directory.
     * 
     * @param pathname
     *            il percorso.
     * @throws IllegalArgumentException
     *             se pathname non è una directory.
     */
    public void setTargetPath(File pathname) throws IllegalArgumentException;

    /**
     * La dimensione massima che l'insieme di file scelti può raggiungere.
     * 
     * @param size
     *            la dimensione in byte
     */
    public void setMaximumSize(long size);

    /**
     * Aggiunge un filtro per la selezione dei file nelle directory di partenza.
     * 
     * @param filter
     *            il filtro.
     */
    public void addFileFilter(FileFilter filter);

    /**
     * Aggiunge un array di filtri per la selezione dei file nelle directory di
     * partenza.
     * 
     * @param filter
     *            l'array di filtri.
     */
    public void addFileFilter(FileFilter[] filter);

    /**
     * Aggiunge un filtro di nomi di file per la selezione dei file nelle
     * directory di partenza.
     * 
     * @param filter
     *            il filtro.
     */
    public void addFilenameFilter(FilenameFilter filter);

    /**
     * Aggiunge un array di filtri di nomi di file per la selezione dei file
     * nelle directory di partenza.
     * 
     * @param filter
     *            l'array di filtri.
     */
    public void addFilenameFilter(FilenameFilter[] filter);

    /**
     * @return una stringa rappresentante il percorso assoluto della directory
     *         di destinazione.
     */
    public String getTargetFilename();

    /**
     * @return un'array di stringhe, ognuna rappresentante una directory di
     *         partenza.
     */
    public String[] getSourceFilename();

    /**
     * @return un array di stringhe rappresentanti i filtri impostati
     */
    public String[] getFilter();

    /**
     * @return la dimensione massima impostata, in byte
     */
    public long getMaximumSize();

}
