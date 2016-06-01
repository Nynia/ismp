/**
 * PortalEngineService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package utils.portalEngine;

public interface PortalEngineService extends javax.xml.rpc.Service {
    public java.lang.String getPortalEngineAddress();

    public utils.portalEngine.PortalEngine getPortalEngine() throws javax.xml.rpc.ServiceException;

    public utils.portalEngine.PortalEngine getPortalEngine(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
