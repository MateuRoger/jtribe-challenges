package service.impl;

import java.util.stream.Stream;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public class EightQueensScenariosArgumentProvider implements ArgumentsProvider {

  /**
   * Provide a {@link Stream} of {@link Arguments} to be passed to a {@code @ParameterizedTest}
   * method.
   *
   * @param context the current extension context; never {@code null}
   * @return a stream of arguments; never {@code null}
   */
  @Override
  public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
    return Stream.of(
        Arguments.of(new String[] {"(2,1)", "(4,2)", "(6,3)", "(8,4)", "(3,5)", "(1,6)", "(7,7)",
            "(5,8)"}, Boolean.TRUE.toString()),
        Arguments.of(new String[] {"(2,1)", "(4,3)", "(6,3)", "(8,4)", "(3,4)", "(1,6)", "(7,7)",
            "(5,8)"}, "(2,1)"),
        Arguments.of(new String[] {"(2,1)", "(5,3)", "(6,3)", "(8,4)", "(3,4)", "(1,8)", "(7,7)",
            "(5,8)"}, "(5,3)"),
        Arguments.of(new String[] {"(2,1)", "(4,2)", "(6,3)", "(8,4)", "(3,5)", "(1,6)", "(7,7)",
            "(7,8)"}, "(7,7)")
    );
  }
}
