package org.eclipse.osc.services.ocl.loader;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

public class OclTest {
    @Test
    public void testDeepCopyAnEmptyOcl() throws Exception {
        Ocl ocl = new Ocl();
        Ocl aCopy = ocl.deepCopy();
        assertNull(aCopy.getName());
    }

    @Test
    public void testDeepCopy() throws Exception {
        Ocl ocl = new Ocl();
        ocl.setName("foo");
        Storage storage = new Storage();
        storage.setName("bar");
        ocl.setStorage(Arrays.asList(storage));
        Ocl aCopy = ocl.deepCopy();
        assertEquals("foo", aCopy.getName());
        assertNotSame(ocl, aCopy);
        assertNotSame(ocl.getName(), aCopy.getName());
        assertNotSame(ocl.getStorage(), aCopy.getStorage());
        Storage aCopiedStorage = aCopy.getStorage().get(0);
        assertNotSame(aCopiedStorage, storage);
        assertEquals("bar", aCopiedStorage.getName());
    }
}
