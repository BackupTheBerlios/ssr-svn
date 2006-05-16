package de.berlios.ssr.core;

import java.io.File;
import java.net.URI;

public class MarkableFile extends File {

    private boolean marked;

    /**
     * Ereditato da File.
     */
    private static final long serialVersionUID = 1L;

    /**
     * @return ritorna vero se l'oggetto è impostato come marcato, falso
     *         altrimenti.
     */
    public boolean isMarked() {
        return marked;
    }

    /**
     * @param mark
     *            imposta l'oggetto marcato o meno a seconda del valore di mark.
     */
    public void setMarked(boolean mark) {
        this.marked = mark;
    }

    /**
     * @param arg0
     * @param arg1
     */
    public MarkableFile(File arg0, String arg1) {
        super(arg0, arg1);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param arg0
     * @param arg1
     */
    public MarkableFile(String arg0, String arg1) {
        super(arg0, arg1);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param arg0
     */
    public MarkableFile(String arg0) {
        super(arg0);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param arg0
     */
    public MarkableFile(URI arg0) {
        super(arg0);
        // TODO Auto-generated constructor stub
    }

}
