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
package org.mobicents.slee.resource.diameter.rf.events.avp;

import net.java.slee.resource.diameter.rf.events.avp.InterOperatorIdentifier;

import org.mobicents.slee.resource.diameter.base.events.avp.GroupedAvpImpl;

/**
 * 
 * InterOperatorIdentifierImpl.java
 *
 * <br>Project:  mobicents
 * <br>8:03:55 PM Apr 11, 2009 
 * <br>
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 */
public class InterOperatorIdentifierImpl extends GroupedAvpImpl implements InterOperatorIdentifier {

  public InterOperatorIdentifierImpl() {
    super();
  }

  /**
   * @param code
   * @param vendorId
   * @param mnd
   * @param prt
   * @param value
   */
  public InterOperatorIdentifierImpl( int code, long vendorId, int mnd, int prt, byte[] value )
  {
    super( code, vendorId, mnd, prt, value );
    // TODO Auto-generated constructor stub
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.rf.events.avp.InterOperatorIdentifier#getOriginatingIoi()
   */
  public String getOriginatingIoi() {
    return getAvpAsUTF8String(DiameterRfAvpCodes.ORIGINATING_IOI, DiameterRfAvpCodes.TGPP_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.rf.events.avp.InterOperatorIdentifier#getTerminatingIoi()
   */
  public String getTerminatingIoi() {
    return getAvpAsUTF8String(DiameterRfAvpCodes.TERMINATING_IOI, DiameterRfAvpCodes.TGPP_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.rf.events.avp.InterOperatorIdentifier#hasOriginatingIoi()
   */
  public boolean hasOriginatingIoi() {
    return hasAvp(DiameterRfAvpCodes.ORIGINATING_IOI, DiameterRfAvpCodes.TGPP_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.rf.events.avp.InterOperatorIdentifier#hasTerminatingIoi()
   */
  public boolean hasTerminatingIoi() {
    return hasAvp(DiameterRfAvpCodes.TERMINATING_IOI, DiameterRfAvpCodes.TGPP_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.rf.events.avp.InterOperatorIdentifier#setOriginatingIoi(String)
   */
  public void setOriginatingIoi( String originatingIoi ) {
    addAvp(DiameterRfAvpCodes.ORIGINATING_IOI, DiameterRfAvpCodes.TGPP_VENDOR_ID, originatingIoi);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.rf.events.avp.InterOperatorIdentifier#setTerminatingIoi(String)
   */
  public void setTerminatingIoi( String terminatingIoi ) {
    addAvp(DiameterRfAvpCodes.TERMINATING_IOI, DiameterRfAvpCodes.TGPP_VENDOR_ID, terminatingIoi);
  }

}
