/*
 * JBoss, Home of Professional Open Source
 * 
 * Copyright 2010, Red Hat Middleware LLC, and individual contributors
 * as indicated by the @authors tag. All rights reserved.
 * See the copyright.txt in the distribution for a full listing
 * of individual contributors.
 *
 * This copyrighted material is made available to anyone wishing to use,
 * modify, copy, or redistribute it subject to the terms and conditions
 * of the GNU General Public License, v. 2.0.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License,
 * v. 2.0 along with this distribution; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301, USA.
 */
package net.java.slee.resource.diameter.sh.server;

import net.java.slee.resource.diameter.sh.MessageFactory;
import net.java.slee.resource.diameter.sh.events.ProfileUpdateAnswer;
import net.java.slee.resource.diameter.sh.events.ProfileUpdateRequest;
import net.java.slee.resource.diameter.sh.events.PushNotificationRequest;
import net.java.slee.resource.diameter.sh.events.SubscribeNotificationsAnswer;
import net.java.slee.resource.diameter.sh.events.SubscribeNotificationsRequest;
import net.java.slee.resource.diameter.sh.events.UserDataAnswer;
import net.java.slee.resource.diameter.sh.events.UserDataRequest;
import net.java.slee.resource.diameter.sh.events.avp.UserIdentityAvp;

/**
 * The Sh Server Message Factory used to create Diameter Sh messages.
 */
public interface ShServerMessageFactory extends MessageFactory {

  /**
   * Create a UserDataAnswer using the given parameter to populate the
   * User-Data AVP. The Result-Code AVP is automatically set to
   * {@link org.mobicents.slee.resource.diameter.base.DiameterResultCode#DIAMETER_SUCCESS}
   * .
   * 
   * @return a UserDataAnswer object that can be sent using
   *         {@link ShServerActivity#sendUserDataAnswer(net.java.slee.resource.diameter.sh.types.UserDataAnswer)}
   */
  UserDataAnswer createUserDataAnswer(UserDataRequest request, byte[] userData);

  /**
   * Create a UserDataAnswer containing a Result-Code or Experimental-Result
   * AVP populated with the given value. If
   * <code>isExperimentalResultCode</code> is <code>true</code>, the
   * <code>resultCode</code> parameter will be set in a
   * {@link org.mobicents.slee.resource.diameter.base.types.ExperimentalResultAvp}
   * AVP, if it is <code>false</code> the result code will be set in a
   * Result-Code AVP.
   * 
   * @return a UserDataAnswer object that can be sent using
   *         {@link ShServerActivity#sendUserDataAnswer(net.java.slee.resource.diameter.sh.types.UserDataAnswer)}
   */
  UserDataAnswer createUserDataAnswer(UserDataRequest request, long resultCode, boolean isExperimentalResult);

  /**
   * Create an empty UserDataAnswer that will need to have AVPs set on it
   * before being sent.
   * 
   * @return a UserDataAnswer object that can be sent using
   *         {@link ShServerActivity#sendUserDataAnswer(net.java.slee.resource.diameter.sh.types.UserDataAnswer)}
   */
  UserDataAnswer createUserDataAnswer(UserDataRequest request);

  /**
   * Create a ProfileUpdateAnswer containing a Result-Code or
   * Experimental-Result AVP populated with the given value. If
   * <code>isExperimentalResultCode</code> is <code>true</code>, the
   * <code>resultCode</code> parameter will be set in a
   * {@link org.mobicents.slee.resource.diameter.base.types.ExperimentalResultAvp}
   * AVP, if it is <code>false</code> the result code will be set in a
   * Result-Code AVP.
   * 
   * @return a ProfileUpdateAnswer object that can be sent using
   *         {@link ShServerActivity#sendProfileUpdateAnswer(net.java.slee.resource.diameter.sh.types.ProfileUpdateAnswer)}
   */
  ProfileUpdateAnswer createProfileUpdateAnswer(ProfileUpdateRequest request, long resultCode, boolean isExperimentalResult);

  /**
   * Create an empty ProfileUpdateAnswer that will need to have AVPs set on it
   * before being sent.
   * 
   * @return a ProfileUpdateAnswer object that can be sent using
   *         {@link ShServerActivity#sendProfileUpdateAnswer(net.java.slee.resource.diameter.sh.types.ProfileUpdateAnswer)}
   */
  ProfileUpdateAnswer createProfileUpdateAnswer(ProfileUpdateRequest request);

  /**
   * Create a SubscribeNotificationsAnswer containing a Result-Code or
   * Experimental-Result AVP populated with the given value. If
   * <code>isExperimentalResultCode</code> is <code>true</code>, the
   * <code>resultCode</code> parameter will be set in a
   * {@link org.mobicents.slee.resource.diameter.base.types.ExperimentalResultAvp}
   * AVP, if it is <code>false</code> the result code will be set in a
   * Result-Code AVP.
   * 
   * @return a SubscribeNotificationsAnswer object that can be sent using
   *         {@link ShServerActivity#sendSubscribeNotificationsAnswer(net.java.slee.resource.diameter.sh.types.SubscribeNotificationsAnswer)}
   */
  SubscribeNotificationsAnswer createSubscribeNotificationsAnswer(SubscribeNotificationsRequest request, long resultCode, boolean isExperimentalResult);

  /**
   * Create an empty SubscribeNotificationsAnswer that will need to have AVPs
   * set on it before being sent.
   * 
   * @return a SubscribeNotificationsAnswer object that can be sent using
   *         {@link ShServerActivity#sendSubscribeNotificationsAnswer(net.java.slee.resource.diameter.sh.types.SubscribeNotificationsAnswer)}
   */
  SubscribeNotificationsAnswer createSubscribeNotificationsAnswer(SubscribeNotificationsRequest request);

  /**
   * Create a UserDataAnswer using the given parameters to populate the
   * User-Identity and User-Data AVPs.
   * 
   * @return a PushNotificationRequest object that can be sent using
   *         {@link ShServerNotificationActivity#sendPushNotificationRequest(net.java.slee.resource.diameter.sh.types.PushNotificationRequest)}
   */
  PushNotificationRequest createPushNotificationRequest(UserIdentityAvp userIdentity, byte[] userData);

  /**
   * Create an empty PushNotificationRequest.
   * 
   * @return a PushNotificationRequest object that can be sent using
   *         {@link ShServerNotificationActivity#sendPushNotificationRequest(net.java.slee.resource.diameter.sh.types.PushNotificationRequest)}
   */
  PushNotificationRequest createPushNotificationRequest();
}
