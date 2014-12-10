package tools.descartes.dlim.tests;

import junit.framework.TestCase;

import org.eclipse.emf.ecore.EObject;

/**
 * Test the custom implementation for a given modelElement.
 *
 * @author J�akim v. Kistowski
 */
public abstract class ModelElementTest extends TestCase {

	private EObject fixture = null;

	/**
	 * Constructs a new test case with the given name.
	 * @param name test case name
	 */
	public ModelElementTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this test case.
	 * @param fixture the model element to be tested
	 */
	protected void setFixture(EObject fixture) {
		this.fixture = fixture;
	}

	/**
	 * Gets the test case fixture.
	 *
	 * @return the model element to be tested.
	 */
	protected EObject getFixture() {
		return fixture;
	}

	/**
	 * Calls setupFixture.
	 */
	@Override
	protected void setUp() throws Exception {
		fixture = setupFixture();
	}

	/**
	 * Create your respective model element here.
	 *
	 * @return Your model element. Recommended: Create with CustomDlimFactory
	 */
	protected abstract EObject setupFixture();

	/**
	 * Removes the test case.
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

}