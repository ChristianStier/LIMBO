package tools.descartes.dlim.extractor;

import java.util.List;

import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import tools.descartes.dlim.Sequence;
import tools.descartes.dlim.extractor.IDlimExtractor;
import tools.descartes.dlim.extractor.dialogs.LaunchExtractionDialog;
import tools.descartes.dlim.generator.ArrivalRateTuple;
/**
 * Extracts a DLIM instance based on the Simple Extraction Model.
 * @author J�akim G. v. Kistowski
 */
public class SimpleProcessExtractor implements IDlimExtractor {

	/**
	 * Extracts a DLIM instance based on the Simple Extraction Model.
	 */
	@Override
	public void extractIntoSequence(Sequence root,
			List<ArrivalRateTuple> readArrivalRates) {
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		LaunchExtractionDialog dialog = new LaunchExtractionDialog(shell, root, readArrivalRates);
		dialog.open();

		/*if (!dialog.wasCanceled()) {
			try {
				ModelExtractor.extractArrivalRateFileIntoSequence(root,
						readArrivalRates,dialog.getSeasonalPeriod(),
						dialog.getSeasonalsPerTrend(),dialog.getSeasonalShape(),dialog.getTrendShape(),
						dialog.getOperatorLiteral(), dialog.isExtractNoise());
			} catch (ExtractionParameterException e) {
				MessageDialog.openError(
						shell,
						"Extraction Error",
						"Extraction Error: " + e.getMessage());
			}
		}*/
	}

}
