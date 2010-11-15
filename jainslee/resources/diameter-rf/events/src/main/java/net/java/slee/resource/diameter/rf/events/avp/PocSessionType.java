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
package net.java.slee.resource.diameter.rf.events.avp;

import java.io.StreamCorruptedException;

/**
 * Java class to represent the PocSessionType enumerated type.
 */
public class PocSessionType implements net.java.slee.resource.diameter.base.events.avp.Enumerated, java.io.Serializable{

  private static final long serialVersionUID = 1L;

  public static final int _ONE_TO_ONE_POC_SESSION = 0;

  public static final int _CHAT_POC_GROUP_SESSION = 1;

  public static final int _PRE_ARRANGED_POC_GROUP_SESSION = 2;

  public static final int _AD_HOC_POC_GROUP_SESSION = 3;

  public static final PocSessionType ONE_TO_ONE_POC_SESSION = new PocSessionType(_ONE_TO_ONE_POC_SESSION);

  public static final PocSessionType CHAT_POC_GROUP_SESSION = new PocSessionType(_CHAT_POC_GROUP_SESSION);

  public static final PocSessionType PRE_ARRANGED_POC_GROUP_SESSION = new PocSessionType(_PRE_ARRANGED_POC_GROUP_SESSION);

  public static final PocSessionType AD_HOC_POC_GROUP_SESSION = new PocSessionType(_AD_HOC_POC_GROUP_SESSION);

  private PocSessionType(int v) {
    value = v;
  }

  /**
   * Return the value of this instance of this enumerated type.
   */
  public static PocSessionType fromInt(int type) {
    switch(type) {
    case _AD_HOC_POC_GROUP_SESSION: return AD_HOC_POC_GROUP_SESSION;

    case _CHAT_POC_GROUP_SESSION: return CHAT_POC_GROUP_SESSION;

    case _ONE_TO_ONE_POC_SESSION: return ONE_TO_ONE_POC_SESSION;

    case _PRE_ARRANGED_POC_GROUP_SESSION: return PRE_ARRANGED_POC_GROUP_SESSION;
    default: throw new IllegalArgumentException("Invalid PocSessionType value: " + type);
    }
  }

  public int getValue() {
    return value;
  }

  public String toString() {
    switch(value) {
    case _AD_HOC_POC_GROUP_SESSION: return "AD_HOC_POC_GROUP_SESSION";

    case _CHAT_POC_GROUP_SESSION: return "CHAT_POC_GROUP_SESSION";

    case _ONE_TO_ONE_POC_SESSION: return "ONE_TO_ONE_POC_SESSION";

    case _PRE_ARRANGED_POC_GROUP_SESSION: return "PRE_ARRANGED_POC_GROUP_SESSION";
    default: return "<Invalid Value>";
    }
  }

  private Object readResolve() throws StreamCorruptedException {
    try {
      return fromInt(value);
    }
    catch (IllegalArgumentException iae) {
      throw new StreamCorruptedException("Invalid internal state found: " + value);
    }
  }

  private int value = 0;

}
