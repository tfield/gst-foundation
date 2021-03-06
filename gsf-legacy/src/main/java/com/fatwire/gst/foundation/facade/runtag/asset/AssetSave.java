/*
 * Copyright 2008 FatWire Corporation. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.fatwire.gst.foundation.facade.runtag.asset;

import com.fatwire.gst.foundation.facade.runtag.AbstractTagRunner;

/**
 * Wrapper around the ASSET.SAVE tag
 * 
 * @author Mike Field
 * @since Jun 11, 2008
 * @deprecated - com.fatwire.gst.foundation.facade and all subpackages have moved to the tools.gsf.facade package
 */
public final class AssetSave extends AbstractTagRunner {
    // Default Constructor
    public AssetSave() {
        super("ASSET.SAVE");
    }

    /**
     * Sets name to the value of <code>s</code>
     * 
     * @param s The name of the asset instance
     */
    public void setName(String s) {
        // validate first
        if (s == null || s.length() == 0) {
            throw new IllegalArgumentException("Invalid string for Name: " + s);
        }
        this.set("NAME", s);
    }

    /**
     * Sets the value of the flush field to <code>s</code>
     * 
     * @param s The name of the asset subtype
     */
    public void setFlush(String s) {
        // validate first
        if (s == null || s.length() == 0 || !s.equals("false") && !s.equals("true")) {
            throw new IllegalArgumentException("Invalid string for Flush: " + s
                    + ". Accepted values are 'true' and 'false'.");
        }
        this.set("FLUSH", s);
    }

}
