/**
 * Copyright 2017 ZTE Corporation.
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
package org.openo.holmes.common.utils;

import java.util.Locale;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class ExceptionUtil {

    private static final int EXCEPTION_CODE = 499;

    private ExceptionUtil() {

    }

    public static String getExceptionMsg(Locale locale, Exception e) {
        return I18nProxy.getInstance().getValue(locale, e.getMessage());
    }

    public static String getExceptionMsgByArgs(Locale locale, Exception e, String[] obj) {
        return I18nProxy.getInstance().getValueByArgs(locale, e.getMessage(), obj);
    }

    public static WebApplicationException buildExceptionResponse(String message) {
        Response response = Response.status(EXCEPTION_CODE).entity(message).type(MediaType.TEXT_PLAIN).build();
        return new WebApplicationException(response);
    }
}
