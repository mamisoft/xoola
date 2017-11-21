/*
 * XoolA is a remote method call bridge between java and dotnet platforms.
 * Copyright (C) 2010 Muhammet YILDIZ, Doğan ERSÖZ
 *
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 *
 */
package org.interop.xoola.core;

/**
 * @author muhammet
 */
public interface XoolaProperty {
   /**
    * Default value: {@link XoolaPropertyDefaults#MODE}
    */
   String MODE = "MODE";
   /**
    * Default value: {@link XoolaPropertyDefaults#HOST}
    */
   String HOST = "HOST";
   /**
    * Default value: {@link XoolaPropertyDefaults#PORT}
    */
   String PORT = "PORT";
   /**
    * Default value: {@link XoolaPropertyDefaults#SERVERID}
    */
   String SERVERID = "SERVERID";
   /**
    * Default value: {@link XoolaPropertyDefaults#CLIENTID}
    */
   String CLIENTID = "CLIENTID";
   /**
    * Default value: {@link XoolaPropertyDefaults#NETWORK_RESPONSE_TIMEOUT}
    */
   String NETWORK_RESPONSE_TIMEOUT = "NETWORK_RESPONSE_TIMEOUT";
   /**
    * Default value {@link XoolaPropertyDefaults#PING_TIMEOUT}
    */
   String PING_TIMEOUT = "PING_TIMEOUT";
   /**
    * Default value: {@link XoolaPropertyDefaults#RECONNECT_RETRY_TIMEOUT}
    */
   String RECONNECT_RETRY_TIMEOUT = "RECONNECT_RETRY_TIMEOUT";
   /**
    * Default value: {@link XoolaPropertyDefaults#HANDSHAKE_TIMEOUT}
    */
   String HANDSHAKE_TIMEOUT = "HANDSHAKE_TIMEOUT";

   String CLIENT_ACCESS_CONTROLLER_CLASS = "CLIENT_ACCESS_CONTROLLER_CLASS";
   String CLASS_LOADER_PROVIDER_CLASS = "CLASS_LOADER_PROVIDER_CLASS";
}
