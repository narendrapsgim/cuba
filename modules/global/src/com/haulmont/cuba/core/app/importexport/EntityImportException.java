/*
 * Copyright (c) 2008-2016 Haulmont.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.haulmont.cuba.core.app.importexport;

import com.haulmont.cuba.core.global.Logging;
import com.haulmont.cuba.core.global.SupportedByClient;

/**
 */
@SupportedByClient
@Logging(Logging.Type.BRIEF)
public class EntityImportException extends RuntimeException {

    public EntityImportException(String message) {
        super(message);
    }

    public EntityImportException(String message, Throwable cause) {
        super(message, cause);
    }
}
