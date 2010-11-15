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
package org.mobicents.slee.resource.diameter.ro.events.avp;

import net.java.slee.resource.diameter.ro.events.avp.EventType;

import org.mobicents.slee.resource.diameter.base.events.avp.GroupedAvpImpl;

/**
 * EventTypeImpl.java
 *
 * <br>Project:  mobicents
 * <br>11:20:17 AM Apr 11, 2009 
 * <br>
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 */
public class EventTypeImpl extends GroupedAvpImpl implements EventType {

  public EventTypeImpl() {
    super();
  }

  /**
   * @param code
   * @param vendorId
   * @param mnd
   * @param prt
   * @param value
   */
  public EventTypeImpl( int code, long vendorId, int mnd, int prt, byte[] value ) {
    super( code, vendorId, mnd, prt, value );
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.ro.events.avp.EventType#getEvent()
   */
  public String getEvent() {
    return getAvpAsUTF8String(DiameterRoAvpCodes.EVENT, DiameterRoAvpCodes.TGPP_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.ro.events.avp.EventType#getExpires()
   */
  public long getExpires() {
    return getAvpAsUnsigned32(DiameterRoAvpCodes.EXPIRES, DiameterRoAvpCodes.TGPP_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.ro.events.avp.EventType#getSipMethod()
   */
  public String getSipMethod() {
    return getAvpAsUTF8String(DiameterRoAvpCodes.SIP_METHOD, DiameterRoAvpCodes.TGPP_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.ro.events.avp.EventType#hasEvent()
   */
  public boolean hasEvent() {
    return hasAvp(DiameterRoAvpCodes.EVENT, DiameterRoAvpCodes.TGPP_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.ro.events.avp.EventType#hasExpires()
   */
  public boolean hasExpires() {
    return hasAvp(DiameterRoAvpCodes.EXPIRES, DiameterRoAvpCodes.TGPP_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.ro.events.avp.EventType#hasSipMethod()
   */
  public boolean hasSipMethod() {
    return hasAvp(DiameterRoAvpCodes.SIP_METHOD, DiameterRoAvpCodes.TGPP_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.ro.events.avp.EventType#setEvent(String)
   */
  public void setEvent( String event ) {
    addAvp(DiameterRoAvpCodes.EVENT, DiameterRoAvpCodes.TGPP_VENDOR_ID, event);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.ro.events.avp.EventType#setExpires(long)
   */
  public void setExpires( long expires ) {
    addAvp(DiameterRoAvpCodes.EXPIRES, DiameterRoAvpCodes.TGPP_VENDOR_ID, expires);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.ro.events.avp.EventType#setSipMethod(String)
   */
  public void setSipMethod( String sipMethod )
  {
    addAvp(DiameterRoAvpCodes.SIP_METHOD, DiameterRoAvpCodes.TGPP_VENDOR_ID, sipMethod);
  }

}
