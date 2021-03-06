/*
 * Copyright (c) 2008-2020 Haulmont.
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

package com.haulmont.cuba.web.exception;

import com.haulmont.cuba.core.global.AccessDeniedException;
import com.haulmont.cuba.core.global.Messages;
import com.haulmont.cuba.gui.WindowManager;
import com.haulmont.cuba.gui.components.Frame;
import com.haulmont.cuba.gui.exception.AbstractGenericExceptionHandler;
import com.haulmont.cuba.web.WebConfig;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import javax.annotation.Nullable;
import javax.inject.Inject;

/**
 * Handles {@link AccessDeniedException}
 */
@Component("cuba_AccessDeniedHandler")
public class AccessDeniedHandler extends AbstractGenericExceptionHandler implements Ordered {

    @Inject
    protected Messages messages;

    @Inject
    protected WebConfig webConfig;

    public AccessDeniedHandler() {
        super(AccessDeniedException.class.getName());
    }

    @Override
    protected void doHandle(String className, String message, @Nullable Throwable throwable, WindowManager windowManager) {
        String msg;
        if (throwable != null && !webConfig.getProductionMode()) {
            AccessDeniedException e = (AccessDeniedException) throwable;
            msg = messages.formatMessage(getClass(), "accessDenied.detailedMessage", e.getTarget(),
                    messages.getMessage(e.getType()) + (e.getEntityOp() != null ? " (" + messages.getMessage(e.getEntityOp()) + ")" : ""));
        } else {
            msg = messages.getMessage(getClass(), "accessDenied.message");
        }

        windowManager.showNotification(msg, Frame.NotificationType.ERROR);
    }

    @Override
    public int getOrder() {
        return HIGHEST_PLATFORM_PRECEDENCE + 20;
    }
}
