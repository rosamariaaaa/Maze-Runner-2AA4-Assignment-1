package ca.mcmaster.se2aa4.mazerunner;

public class Path {

    String sequence;
    String canonicalForm;
    String factorizedForm;

    /**
     * Create a new Path
     */
    public Path() {
        this.sequence = "";
        this.canonicalForm = "";
        this.factorizedForm = "";
    }

        /**
     * Create a new Path
     */
    public Path(String instructionSequence) {
        this.sequence = instructionSequence;
        updateCanonical();
        updateFactorized();
    }

    /**
     * Return a string of the path in canonical form. 
     */
    public String getCanonical() {
        return factorizedForm;
    }

    /**
     * Return a string of the path in factorized form.
     */
    public String getFactorized() {
        return canonicalForm;
    }

    /**
     * Add a direction to the path
     */
    public void addStep(char direction) {
        this.sequence = this.sequence + direction;
    }

    /**
     * Update the canonical form based on the current sequence.
     */
    private void updateCanonical() {

    }

    /**
     * Update the factorized form based on the current sequence.
     */
    private void updateFactorized() {

    }
}