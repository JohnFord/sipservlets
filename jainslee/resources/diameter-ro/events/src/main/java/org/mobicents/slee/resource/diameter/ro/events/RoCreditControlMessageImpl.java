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
package org.mobicents.slee.resource.diameter.ro.events;

import net.java.slee.resource.diameter.cca.events.avp.CcRequestType;
import net.java.slee.resource.diameter.cca.events.avp.CreditControlAVPCodes;
import net.java.slee.resource.diameter.cca.events.avp.MultipleServicesCreditControlAvp;
import net.java.slee.resource.diameter.ro.events.RoCreditControlMessage;
import net.java.slee.resource.diameter.ro.events.avp.ServiceInformation;

import org.jdiameter.api.Message;
import org.mobicents.slee.resource.diameter.base.events.DiameterMessageImpl;
import org.mobicents.slee.resource.diameter.cca.events.avp.MultipleServicesCreditControlAvpImpl;
import org.mobicents.slee.resource.diameter.ro.events.avp.DiameterRoAvpCodes;
import org.mobicents.slee.resource.diameter.ro.events.avp.ServiceInformationImpl;

/**
 * 
 * @author <a href="mailto:baranowb@gmail.com"> Bartosz Baranowski </a>
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 */
public abstract class RoCreditControlMessageImpl extends DiameterMessageImpl implements RoCreditControlMessage {

  /**
   * @param message
   */
  public RoCreditControlMessageImpl(Message message) {
    super(message);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.ro.events.RoCreditControlMessage#getCcRequestNumber()
   */
  @Override
  public long getCcRequestNumber() {
    return getAvpAsUnsigned32(CreditControlAVPCodes.CC_Request_Number);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.ro.events.RoCreditControlMessage#setCcRequestNumber(long)
   */
  @Override
  public void setCcRequestNumber(long ccRequestNumber) throws IllegalStateException {
    addAvp(CreditControlAVPCodes.CC_Request_Number, ccRequestNumber);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.ro.events.RoCreditControlMessage#hasCcRequestNumber()
   */
  @Override
  public boolean hasCcRequestNumber() {
    return hasAvp(CreditControlAVPCodes.CC_Request_Number);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.ro.events.RoCreditControlMessage#getCcRequestType()
   */
  @Override
  public CcRequestType getCcRequestType() {
    return (CcRequestType) getAvpAsEnumerated(CreditControlAVPCodes.CC_Request_Type, CcRequestType.class);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.ro.events.RoCreditControlMessage#setCcRequestType(net.java.slee.resource.diameter.cca.events.avp.CcRequestType)
   */
  @Override
  public void setCcRequestType(CcRequestType ccRequestType) throws IllegalStateException {
    addAvp(CreditControlAVPCodes.CC_Request_Type, (long) ccRequestType.getValue());
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.ro.events.RoCreditControlMessage#hasCcRequestType()
   */
  @Override
  public boolean hasCcRequestType() {
    return hasAvp(CreditControlAVPCodes.CC_Request_Type);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.ro.events.RoCreditControlMessage#hasMultipleServicesCreditControl()
   */
  @Override
  public boolean hasMultipleServicesCreditControl() {
    return hasAvp(CreditControlAVPCodes.Multiple_Services_Credit_Control);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.ro.events.RoCreditControlMessage#setMultipleServicesCreditControl(net.java.slee.resource.diameter.cca.events.avp.MultipleServicesCreditControlAvp)
   */
  @Override
  public void setMultipleServicesCreditControl(MultipleServicesCreditControlAvp multipleServicesCreditControl) throws IllegalStateException {
    addAvp(CreditControlAVPCodes.Multiple_Services_Credit_Control, multipleServicesCreditControl.byteArrayValue());
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.ro.events.RoCreditControlMessage#setMultipleServicesCreditControls(net.java.slee.resource.diameter.cca.events.avp.MultipleServicesCreditControlAvp[])
   */
  @Override
  public void setMultipleServicesCreditControls(MultipleServicesCreditControlAvp[] multipleServicesCreditControls) throws IllegalStateException {
    for (MultipleServicesCreditControlAvp multipleServicesCreditControl : multipleServicesCreditControls) {
      setMultipleServicesCreditControl(multipleServicesCreditControl);
    }
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.ro.events.RoCreditControlMessage#getMultipleServicesCreditControls()
   */
  @Override
  public MultipleServicesCreditControlAvp[] getMultipleServicesCreditControls() {
    return (MultipleServicesCreditControlAvp[]) getAvpsAsCustom(CreditControlAVPCodes.Multiple_Services_Credit_Control, MultipleServicesCreditControlAvpImpl.class);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.ro.events.RoCreditControlMessage#getServiceInformation()
   */
  @Override
  public ServiceInformation getServiceInformation() {
    return (ServiceInformation) super.getAvpAsCustom(DiameterRoAvpCodes.SERVICE_INFORMATION, DiameterRoAvpCodes.TGPP_VENDOR_ID, ServiceInformationImpl.class);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.ro.events.RoCreditControlMessage#setServiceInformation(net.java.slee.resource.diameter.ro.events.avp.ServiceInformation)
   */
  @Override
  public void setServiceInformation(ServiceInformation si) throws IllegalStateException {
    super.addAvp(DiameterRoAvpCodes.SERVICE_INFORMATION, DiameterRoAvpCodes.TGPP_VENDOR_ID, si.byteArrayValue());
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.ro.events.RoCreditControlMessage#hasServiceInformation()
   */
  @Override
  public boolean hasServiceInformation() {
    return super.hasAvp(DiameterRoAvpCodes.SERVICE_INFORMATION, DiameterRoAvpCodes.TGPP_VENDOR_ID);
  }

}
