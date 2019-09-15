package it.fago.experiments.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.fago.experiments.objwithexc.HighlightProcessor;
import it.fago.experiments.objwithexc.s0_basic.S0_Highlighter;
import it.fago.experiments.objwithexc.s1_translate.S1_Highlighter;
import it.fago.experiments.objwithexc.s2_throwingfunc.S2_Highlighter;
import it.fago.experiments.objwithexc.s3_sneakythrow_1.S3_Highlighter;
import it.fago.experiments.objwithexc.s4_sneakythrow_2.S4_Highlighter;
import it.fago.experiments.objwithexc.s5_optionaleither.S5_HighlighterWithEither;
import it.fago.experiments.objwithexc.s5_optionaleither.S5_HighlighterWithOptional;
import it.fago.experiments.objwithexc.s6_collector.S6_Highlighter;
import it.fago.experiments.objwithexc.s7_spliterator.S7_Highlighter;

/**
 * 
 * @author Stefano Fago
 *
 */
public class TestSolutions {
	//
	private List<String> arguments;
	//
	private static Logger logger = LoggerFactory.getLogger(TestSolutions.class);

	@Rule
	public TestName name = new TestName();

	// =====================================================
	//
	//
	//
	// =====================================================

	@Before
	public void setup() {
		arguments = Arrays.asList("1", "2", "3", "4", "5");
	}

	protected List<String> arguments() {
		return arguments;
	}

	protected HighlightProcessor noErrorProcessor() {
		logger.info("Test: {} ",name.getMethodName());
		return new HighlightProcessor(-1);
	}

	protected HighlightProcessor processorWithErrorAt(int at) {
		logger.info("Test: {} ",name.getMethodName());
		return new HighlightProcessor(at);
	}

	protected static final <T> ArrayList<T> asArrayList(List<T> arg) {
		return (ArrayList<T>) arg;
	}

	// =====================================================
	//
	//
	//
	// =====================================================

	// =================================================================================

	@Test
	public void testBasicSolutionNoError() {
		logger.info("list: {}", S0_Highlighter.highlight(arguments(), noErrorProcessor()));
	}

	@Test(expected = RuntimeException.class)
	public void testBasicSolution() {
		S0_Highlighter.highlight(arguments(), processorWithErrorAt(4));
	}

	// =================================================================================

	@Test
	public void testTransalteSolutionNoError() {
		logger.info("list: {}", S1_Highlighter.highlight(arguments(), noErrorProcessor()));
	}

	@Test(expected = RuntimeException.class)
	public void testTranslateSolution() {
		S1_Highlighter.highlight(arguments(), processorWithErrorAt(4));
	}

	// =================================================================================

	@Test
	public void testThrowingFunSolutionNoError() {
		logger.info("list: {}", S2_Highlighter.highlight(arguments(), noErrorProcessor()));
	}

	@Test(expected = RuntimeException.class)
	public void testThrowingFunSolution() {
		S2_Highlighter.highlight(arguments(), processorWithErrorAt(4));
	}

	// =================================================================================

	@Test
	public void testSneakyThrowSolutionNoError() {
		logger.info("list: {}", S3_Highlighter.highlight(arguments(), noErrorProcessor()));
	}

	@Test(expected = IOException.class)
	public void testSneakyThrowSolution() {
		S3_Highlighter.highlight(arguments(), processorWithErrorAt(4));
	}

	// =================================================================================

	@Test
	public void testSneakyThrow2SolutionNoError() {
		logger.info("list: {}", S4_Highlighter.highlight(arguments(), noErrorProcessor()));
	}

	@Test(expected = IOException.class)
	public void testSneakyThrow2Solution() {
		S4_Highlighter.highlight(arguments(), processorWithErrorAt(4));
	}

	// =================================================================================

	@Test
	public void testOptionalSolutionNoError() {
		logger.info("list: {}", S5_HighlighterWithOptional.highlight(arguments(), noErrorProcessor()));
	}

	@Test
	public void testOptionalSolution() {
		List<String> highlighted = S5_HighlighterWithOptional.highlight(arguments(), processorWithErrorAt(4));
		int argumentsLen = arguments().size();
		int highlightedLen = highlighted.size();
		logger.info("list: {}", highlighted);
		Assert.assertTrue("x must be < y: " + highlighted + " - " + argumentsLen, (highlightedLen < argumentsLen));
	}

	// =================================================================================

	@Test
	public void testEitherSolutionNoError() {
		logger.info("list: {}", S5_HighlighterWithEither.highlight(arguments(), noErrorProcessor()));
	}

	@Test
	public void testEitherSolution() {
		List<String> highlighted = S5_HighlighterWithEither.highlight(arguments(), processorWithErrorAt(4));
		int argumentsLen = arguments().size();
		int highlightedLen = highlighted.size();
		logger.info("list: {}", highlighted);
		Assert.assertTrue("x must be < y: " + highlighted + " - " + argumentsLen, (highlightedLen < argumentsLen));
	}

	// =================================================================================

	@Test
	public void testCollectorSolutionNoError() {
		logger.info("list: {}", S6_Highlighter.highlight(arguments(), noErrorProcessor()));
	}

	@Test
	public void testCollectorSolution() {
		List<String> highlighted = S6_Highlighter.highlight(arguments(), processorWithErrorAt(4));
		logger.info("list: {}", highlighted);
		String theFifth = asArrayList(highlighted).get(4);
		Assert.assertEquals("The elemenet must be void String ", "", theFifth);
	}

	// =================================================================================

	@Test
	public void testSpliteratorSolutionNoError() {
		logger.info("list: {}", S7_Highlighter.highlight(arguments(), noErrorProcessor()));
	}

	@Test(expected = IOException.class)
	public void testSpliteratorSolution() {
		S7_Highlighter.highlight(arguments(), processorWithErrorAt(4));
	}

	@Test
	public void testSpliteratorSafeSolutionNoError() {
		logger.info("list: {}", S7_Highlighter.highlightSafe(arguments(), noErrorProcessor()));
	}

	@Test
	public void testSpliteratorSafeSolution() {
		List<String> highlighted = S7_Highlighter.highlightSafe(arguments(), processorWithErrorAt(4));
		int argumentsLen = arguments().size();
		int highlightedLen = highlighted.size();
		logger.info("list: {}", highlighted);
		Assert.assertTrue("x must be < y: " + highlighted + " - " + argumentsLen, (highlightedLen < argumentsLen));
	}

	// =================================================================================

}// END
