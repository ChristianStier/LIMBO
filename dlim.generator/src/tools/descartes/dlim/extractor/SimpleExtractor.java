package tools.descartes.dlim.extractor;

import java.util.List;

import tools.descartes.dlim.Sequence;
import tools.descartes.dlim.assistant.CalibrationException;
import tools.descartes.dlim.generator.ArrivalRateTuple;

/**
 * Default implementation of the IDlimExtractor interface for the Extractor extension point.
 * Use this when testing new arrival rate file readers.
 * @author J�akim G. v. Kistowski
 */
public class SimpleExtractor implements IDlimExtractor {

	/**
	 * Extracts the read arrival rate list into a DLIM Sequence.
	 * Seasonal period and Trend length are pre-set.
	 */
	@Override
	public void extractIntoSequence(Sequence root,
			List<ArrivalRateTuple> readArrivalRates) {
		try {
			ModelExtractor.extractArrivalRateFileIntoSequence(root, readArrivalRates, 24, 2, "SinTrend", "SinTrend", "MULT",false);
		} catch (CalibrationException e){
			System.out.println("Extration Parameter Exception: " + e.getMessage());
		}
		

	}

}
