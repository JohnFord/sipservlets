/*
 * Mobicents, Communications Middleware, Diameter Base
 * 
 * Copyright (c) 2008, Red Hat Middleware LLC or third-party contributors as
 * indicated by the @author tags or express copyright attribution
 * statements applied by the authors.  All third-party contributions are
 * distributed under license by Red Hat Middleware LLC.
 *
 * This copyrighted material is made available to anyone wishing to use, modify,
 * copy, or redistribute it subject to the terms and conditions of the GNU
 * Lesser General Public License, as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License
 * for more details.
 *
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this distribution; if not, write to:
 * Free Software Foundation, Inc.
 * 51 Franklin Street, Fifth Floor
 *
 * Boston, MA  02110-1301  USA
 */
package net.java.slee.resource.diameter.base;

import java.io.IOException;
import java.io.Serializable;

import net.java.slee.resource.diameter.base.events.DiameterMessage;
import net.java.slee.resource.diameter.base.events.avp.DiameterAvp;

/**
 * 
 * Represents a session with a Diameter peer. DiameterMessages (both requests
 * and responses) are received as events fired on DiameterActivity objects. 
 *
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 * @author <a href="mailto:baranowb@gmail.com"> Bartosz Baranowski </a>
 */
public interface DiameterActivity extends Serializable {

  /**
   * Return a DiameterMessageFactory implementation to be used to create
   * instances of {@link DiameterMessage} object to be fired on this
   * Activity. <br>
   * 
   * @return a DiameterMessageFactory implementation
   */
  DiameterMessageFactory getDiameterMessageFactory();

  /**
   * Returns a DiameterAvpFactory which can be used to create instances of  {@link DiameterAvp}.
   * 
   * @return a DiameterAvpFactory implementation
   */
  DiameterAvpFactory getDiameterAvpFactory();

  /**
   * Sends the given DiameterMessage on the DiameterActivity. The response to
   * the message (if any) will be fired on this activity. This method should
   * be used to send custom messages. Its application responsibility to
   * maintain FSM for those events.
   * 
   * @param message the Diameter message to send
   */
  void sendMessage(DiameterMessage message) throws IOException;

  /**
   * Return the Session ID for this activity.
   * 
   * @return the Session ID for this activity
   */
  String getSessionId();

  /**
   * Terminates underlying session
   */
  void endActivity();

}
