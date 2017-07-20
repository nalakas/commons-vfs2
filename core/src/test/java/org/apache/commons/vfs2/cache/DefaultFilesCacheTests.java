/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.vfs2.cache;

import org.apache.commons.vfs2.FileObject;

/**
 * Tests for {@link DefaultFilesCache} used by {@link DefaultFilesCacheTestCase}.
 */
public class DefaultFilesCacheTests extends AbstractFilesCacheTestsBase
{
    public void testFilesCache() throws Exception
    {
        final FileObject scratchFolder = getWriteFolder();

        final FileObject dir1 = scratchFolder.resolveFile("dir1");
        final FileObject dir1_2 = scratchFolder.resolveFile("dir1");

        assertSame(dir1, dir1_2);

        // now the same test, unreferenced (compare only hashCode)
        final int hc1 = getFileHashCode();
        final int hc2 = getFileHashCode();
        assertEquals("Hashcode of file changed, so most likely new instance", hc1, hc2);
    }
}
