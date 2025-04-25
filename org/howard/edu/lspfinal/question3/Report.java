package org.howard.edu.lspfinal.question3;

/**
 * abs class for generating the report
 */
public abstract class Report {
    /**
     * workflow so it doesn't overriddde
     */
    public final void generateReport() {
        loadData();
        formatData();
        printReport();
    }

    /**
     * Load daata for repor
     */
    protected abstract void loadData();

    /**
     * formats
     */
    protected abstract void formatData();

    /**
     * prints the formattted report
     */
    protected abstract void printReport();
}