package org.rhq.plugins.jslee;

import java.util.HashSet;
import java.util.Set;

import javax.management.MBeanServerConnection;
import javax.management.MBeanServerInvocationHandler;
import javax.management.ObjectName;
import javax.security.auth.login.LoginException;
import javax.slee.SbbID;
import javax.slee.ServiceID;
import javax.slee.management.DeploymentMBean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.rhq.core.domain.configuration.PropertySimple;
import org.rhq.core.domain.resource.ResourceType;
import org.rhq.core.pluginapi.inventory.DiscoveredResourceDetails;
import org.rhq.core.pluginapi.inventory.InvalidPluginConfigurationException;
import org.rhq.core.pluginapi.inventory.ResourceDiscoveryComponent;
import org.rhq.core.pluginapi.inventory.ResourceDiscoveryContext;
import org.rhq.plugins.jslee.utils.MBeanServerUtils;

public class ServiceSbbDiscoveryComponent implements ResourceDiscoveryComponent<ServiceComponent> {

  private final Log log = LogFactory.getLog(ServiceSbbDiscoveryComponent.class);

  private ServiceID serviceId = null;
  
  public Set<DiscoveredResourceDetails> discoverResources(ResourceDiscoveryContext<ServiceComponent> context) throws InvalidPluginConfigurationException, Exception {
    if(log.isTraceEnabled()) {
      log.trace("discoverResources() called");
    }

    // Get the connection up and ready
    MBeanServerUtils mbeanUtils = context.getParentResourceComponent().getMBeanServerUtils();
    try {
      MBeanServerConnection connection = mbeanUtils.getConnection();
      mbeanUtils.login();

      ObjectName depMBeanObj = new ObjectName(DeploymentMBean.OBJECT_NAME);

      Set<DiscoveredResourceDetails> discoveredSBBs = new HashSet<DiscoveredResourceDetails>();

      DeploymentMBean depMBean = (DeploymentMBean) MBeanServerInvocationHandler.newProxyInstance(connection, depMBeanObj, DeploymentMBean.class, false);

      if(serviceId == null) {
        serviceId = context.getParentResourceComponent().getServiceID();
      }
      
      SbbID[] sbbIds = depMBean.getSbbs(serviceId);

      addSbb(sbbIds, discoveredSBBs, context.getResourceType());

      if(log.isInfoEnabled()) {
        log.info("Discovered " + discoveredSBBs.size() + " JAIN SLEE SBB Components for " + serviceId + ".");
      }
      return discoveredSBBs;
    }
    finally {
      try {
        mbeanUtils.logout();
      }
      catch (LoginException e) {
        if(log.isDebugEnabled()) {
          log.debug("Failed to logout from secured JMX", e);
        }
      }
    }
  }

  private void addSbb(SbbID[] sbbIds, Set<DiscoveredResourceDetails> discoveredSbbs, ResourceType resourceType) {
    for (SbbID sbbId : sbbIds) {
      String key = sbbId.toString() + "@" + serviceId;
      String description = sbbId.toString();

      // Create new Service resource
      DiscoveredResourceDetails discoveredSbb = new DiscoveredResourceDetails(resourceType, key, sbbId.getName(), sbbId.getVersion(), 
          description, null, null);

      // Add properties to Service resource
      discoveredSbb.getPluginConfiguration().put(new PropertySimple("name", sbbId.getName()));
      discoveredSbb.getPluginConfiguration().put(new PropertySimple("version", sbbId.getVersion()));
      discoveredSbb.getPluginConfiguration().put(new PropertySimple("vendor", sbbId.getVendor()));

      discoveredSbbs.add(discoveredSbb);
    }
  }
}
