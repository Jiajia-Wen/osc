package org.eclipse.osc.orchestrator.plugin.huaweicloud;

import java.util.Optional;
import org.eclipse.osc.services.ocl.loader.Ocl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BuilderFactoryTest {

    @Test
    public void basicBuilderTest() {
        BuilderFactory builderFactory = new BuilderFactory();

        Optional<AtomBuilder> builder = builderFactory.createBuilder(BuilderFactory.BASIC_BUILDER,
            new Ocl());

        Assertions.assertTrue(builder.isPresent());
    }

    @Test
    public void unsupportedBuilderTest() {
        BuilderFactory builderFactory = new BuilderFactory();

        Optional<AtomBuilder> builder = builderFactory.createBuilder("invalid", new Ocl());

        Assertions.assertTrue(builder.isEmpty());
    }
}
