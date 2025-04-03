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
    public Path(String path) {
        this.sequence = path;
        updateForms();
    }

    public String getSequence() {
        return sequence;
    }

    /**
     * Return a string of the path in canonical form. 
     */
    public String getCanonical() {
        return canonicalForm;
    }

    /**
     * Return a string of the path in factorized form.
     */
    public String getFactorized() {
        return factorizedForm;
    }

    /**
     * Add a single move to the path.
     */
    public void addMove(Move move) {
        this.sequence = this.sequence + move.getChar();
        updateForms();
    }

    /**
     * Add a moveset to the path
     */
    public void addSteps(Path newSteps) {
        this.sequence = this.sequence + newSteps.getSequence();
        updateForms();
    }

  /**
	 * Update the canonical and factorized forms based on the current sequence.
	 */
	private void updateForms() {
		canonicalForm = ""; 
		factorizedForm = "";

		for (int i = 0; i < sequence.length(); i++) {
			char current = sequence.charAt(i);
			int count = 0; 
			while (current == sequence.charAt(i)) {
				count++;
				i++;
				canonicalForm = canonicalForm + current;
				if (i >= sequence.length()) break;
			}
			
			if (count == 1) {
				factorizedForm = factorizedForm + current + " ";
			}
			else {
				factorizedForm = factorizedForm + count + current + " ";
			}
			canonicalForm = canonicalForm + " ";
			i--;
		}
	}

}