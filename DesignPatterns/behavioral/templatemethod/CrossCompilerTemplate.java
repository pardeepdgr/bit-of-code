package templatemethod;

/**
 * Define the skeleton of an algorithm in an operation, deferring some steps to
 * client subclasses.
 * 
 * Application: Two different components have significant similarities, but
 * demonstrate no reuse of common interface or implementation. If a change
 * common to both components becomes necessary, duplicate effort must be
 * expended.
 * 
 * The invariant steps are implemented in an abstract base class, while the
 * variant steps are either given a default implementation, or no implementation
 * at all.
 */
public abstract class CrossCompilerTemplate {

	public final void crossCompile() {
		readSourceCode();
		validateSyntax();
		compile();
	}

	public abstract void readSourceCode();

	private void validateSyntax() {
		System.out.println("Code syntax has been checked.");
	}

	public abstract void compile();
}
