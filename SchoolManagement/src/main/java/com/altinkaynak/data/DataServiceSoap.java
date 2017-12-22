/**
 * DataServiceSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.altinkaynak.data;

public interface DataServiceSoap extends java.rmi.Remote {

    /**
     * Anlık döviz kuru bilgileri
     */
    public java.lang.String getCurrency() throws java.rmi.RemoteException;

    /**
     * Anlık altın kuru bilgileri
     */
    public java.lang.String getGold() throws java.rmi.RemoteException;

    /**
     * Anlık seçilmiş doviz kuru altın kuru ve parite bilgileri
     */
    public java.lang.String getMain() throws java.rmi.RemoteException;

    /**
     * Anlık parite bilgileri
     */
    public java.lang.String getParity() throws java.rmi.RemoteException;
}
