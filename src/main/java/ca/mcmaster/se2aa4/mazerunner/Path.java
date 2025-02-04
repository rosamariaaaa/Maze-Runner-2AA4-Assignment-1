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

    public String getSequence() {
        return sequence;
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
     * Add a single move to the path.
     */
    public void addMove(Move move) {
        this.sequence = this.sequence + move.getChar();
        updateCanonical();
        updateFactorized();
    }

    /**
     * Add a moveset to the path
     */
    public void addSteps(Path newSteps) {
        this.sequence = this.sequence + newSteps.getSequence();
        updateCanonical();
        updateFactorized();
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