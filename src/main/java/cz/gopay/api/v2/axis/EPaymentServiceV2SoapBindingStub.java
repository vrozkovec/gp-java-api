/**
 * EPaymentServiceV2SoapBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cz.gopay.api.v2.axis;

import java.rmi.RemoteException;

import cz.gopay.api.v2.EBuyerCreate;
import cz.gopay.api.v2.EBuyerCreateResult;
import cz.gopay.api.v2.ECustomerData;
import cz.gopay.api.v2.EPaymentCommand;
import cz.gopay.api.v2.EPaymentMethod;
import cz.gopay.api.v2.EPaymentResult;
import cz.gopay.api.v2.EPaymentSessionInfo;
import cz.gopay.api.v2.EPaymentStatus;
import cz.gopay.api.v2.ERecurrenceRequest;
import cz.gopay.api.v2.ERefundRequest;

public class EPaymentServiceV2SoapBindingStub extends
		org.apache.axis.client.Stub implements AxisEPaymentProviderV2 {
	private java.util.Vector cachedSerClasses = new java.util.Vector();
	private java.util.Vector cachedSerQNames = new java.util.Vector();
	private java.util.Vector cachedSerFactories = new java.util.Vector();
	private java.util.Vector cachedDeserFactories = new java.util.Vector();

	static org.apache.axis.description.OperationDesc[] _operations;

	static {
		_operations = new org.apache.axis.description.OperationDesc[11];
		_initOperationDesc1();
	}

	private static void _initOperationDesc1() {
		org.apache.axis.description.OperationDesc oper;
		org.apache.axis.description.ParameterDesc param;
		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("createPayment");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "paymentCommand"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName("http://gate.gopay.cz/ws",
						"EPaymentCommand"), EPaymentCommand.class, false, false);
		oper.addParameter(param);
		oper.setReturnType(new javax.xml.namespace.QName(
				"http://gate.gopay.cz/ws", "EPaymentStatus"));
		oper.setReturnClass(EPaymentStatus.class);
		oper.setReturnQName(new javax.xml.namespace.QName("",
				"createPaymentReturn"));
		oper.setStyle(org.apache.axis.constants.Style.RPC);
		oper.setUse(org.apache.axis.constants.Use.ENCODED);
		_operations[0] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("paymentStatus");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "paymentSessionInfo"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName("http://gate.gopay.cz/ws",
						"EPaymentSessionInfo"), EPaymentSessionInfo.class,
				false, false);
		oper.addParameter(param);
		oper.setReturnType(new javax.xml.namespace.QName(
				"http://gate.gopay.cz/ws", "EPaymentStatus"));
		oper.setReturnClass(EPaymentStatus.class);
		oper.setReturnQName(new javax.xml.namespace.QName("",
				"paymentStatusReturn"));
		oper.setStyle(org.apache.axis.constants.Style.RPC);
		oper.setUse(org.apache.axis.constants.Use.ENCODED);
		_operations[1] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("createBuyer");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "buyerCreate"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName("http://gate.gopay.cz/ws",
						"EBuyerCreate"), EBuyerCreate.class, false, false);
		oper.addParameter(param);
		oper.setReturnType(new javax.xml.namespace.QName(
				"http://gate.gopay.cz/ws", "EBuyerCreateResult"));
		oper.setReturnClass(EBuyerCreateResult.class);
		oper.setReturnQName(new javax.xml.namespace.QName("",
				"createBuyerReturn"));
		oper.setStyle(org.apache.axis.constants.Style.RPC);
		oper.setUse(org.apache.axis.constants.Use.ENCODED);
		_operations[2] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("touch");
		oper.setReturnType(new javax.xml.namespace.QName(
				"http://schemas.xmlsoap.org/soap/encoding/", "string"));
		oper.setReturnClass(java.lang.String.class);
		oper.setReturnQName(new javax.xml.namespace.QName("", "touchReturn"));
		oper.setStyle(org.apache.axis.constants.Style.RPC);
		oper.setUse(org.apache.axis.constants.Use.ENCODED);
		_operations[3] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("refundPayment");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "sessionInfo"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName("http://gate.gopay.cz/ws",
						"EPaymentSessionInfo"), EPaymentSessionInfo.class,
				false, false);
		oper.addParameter(param);
		oper.setReturnType(new javax.xml.namespace.QName(
				"http://gate.gopay.cz/ws", "EPaymentResult"));
		oper.setReturnClass(EPaymentResult.class);
		oper.setReturnQName(new javax.xml.namespace.QName("",
				"refundPaymentReturn"));
		oper.setStyle(org.apache.axis.constants.Style.RPC);
		oper.setUse(org.apache.axis.constants.Use.ENCODED);
		_operations[4] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("capturePayment");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "sessionInfo"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName("http://gate.gopay.cz/ws",
						"EPaymentSessionInfo"), EPaymentSessionInfo.class,
				false, false);
		oper.addParameter(param);
		oper.setReturnType(new javax.xml.namespace.QName(
				"http://gate.gopay.cz/ws", "EPaymentResult"));
		oper.setReturnClass(EPaymentResult.class);
		oper.setReturnQName(new javax.xml.namespace.QName("",
				"capturePaymentReturn"));
		oper.setStyle(org.apache.axis.constants.Style.RPC);
		oper.setUse(org.apache.axis.constants.Use.ENCODED);
		_operations[5] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("paymentMethodList");
		oper.setReturnType(new javax.xml.namespace.QName(
				"http://gate.gopay.cz/ws", "ArrayOfEPaymentMethod"));
		oper.setReturnClass(EPaymentMethod[].class);
		oper.setReturnQName(new javax.xml.namespace.QName("",
				"paymentMethodListReturn"));
		oper.setStyle(org.apache.axis.constants.Style.RPC);
		oper.setUse(org.apache.axis.constants.Use.ENCODED);
		_operations[6] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("voidAuthorization");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "sessionInfo"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName("http://gate.gopay.cz/ws",
						"EPaymentSessionInfo"), EPaymentSessionInfo.class,
				false, false);
		oper.addParameter(param);
		oper.setReturnType(new javax.xml.namespace.QName(
				"http://gate.gopay.cz/ws", "EPaymentResult"));
		oper.setReturnClass(EPaymentResult.class);
		oper.setReturnQName(new javax.xml.namespace.QName("",
				"voidAuthorizationReturn"));
		oper.setStyle(org.apache.axis.constants.Style.RPC);
		oper.setUse(org.apache.axis.constants.Use.ENCODED);
		_operations[7] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("voidRecurrentPayment");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "sessionInfo"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName("http://gate.gopay.cz/ws",
						"EPaymentSessionInfo"), EPaymentSessionInfo.class,
				false, false);
		oper.addParameter(param);
		oper.setReturnType(new javax.xml.namespace.QName(
				"http://gate.gopay.cz/ws", "EPaymentResult"));
		oper.setReturnClass(EPaymentResult.class);
		oper.setReturnQName(new javax.xml.namespace.QName("",
				"voidRecurrentPaymentReturn"));
		oper.setStyle(org.apache.axis.constants.Style.RPC);
		oper.setUse(org.apache.axis.constants.Use.ENCODED);
		_operations[8] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("createRecurrentPayment");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "recurrenceRequest"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName("http://gate.gopay.cz/ws",
						"EPaymentRecurrenceRequest"), ERecurrenceRequest.class,
				false, false);
		oper.addParameter(param);
		oper.setReturnType(new javax.xml.namespace.QName(
				"http://gate.gopay.cz/ws", "EPaymentStatus"));
		oper.setReturnClass(EPaymentStatus.class);
		oper.setReturnQName(new javax.xml.namespace.QName("",
				"createRecurrentPaymentReturn"));
		oper.setStyle(org.apache.axis.constants.Style.RPC);
		oper.setUse(org.apache.axis.constants.Use.ENCODED);
		_operations[9] = oper;
		
		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("refundPayment");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "request"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName("http://gate.gopay.cz/ws",
						"ERefundRequest"), ERefundRequest.class,
				false, false);
		oper.addParameter(param);
		oper.setReturnType(new javax.xml.namespace.QName(
				"http://gate.gopay.cz/ws", "EPaymentResult"));
		oper.setReturnClass(EPaymentResult.class);
		oper.setReturnQName(new javax.xml.namespace.QName("",
				"refundPaymentReturn"));
		oper.setStyle(org.apache.axis.constants.Style.RPC);
		oper.setUse(org.apache.axis.constants.Use.ENCODED);
		_operations[10] = oper;

	}

	public EPaymentServiceV2SoapBindingStub() throws org.apache.axis.AxisFault {
		this(null);
	}

	public EPaymentServiceV2SoapBindingStub(java.net.URL endpointURL,
			javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
		this(service);
		super.cachedEndpoint = endpointURL;
	}

	public EPaymentServiceV2SoapBindingStub(javax.xml.rpc.Service service)
			throws org.apache.axis.AxisFault {
		if (service == null) {
			super.service = new org.apache.axis.client.Service();
		} else {
			super.service = service;
		}
		((org.apache.axis.client.Service) super.service)
				.setTypeMappingVersion("1.2");
		java.lang.Class cls;
		javax.xml.namespace.QName qName;
		javax.xml.namespace.QName qName2;
		java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
		java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
		java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
		java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
		java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
		java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
		java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
		java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
		java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
		java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
		qName = new javax.xml.namespace.QName("http://gate.gopay.cz/ws",
				"ArrayOfEPaymentMethod");
		cachedSerQNames.add(qName);
		cls = EPaymentMethod[].class;
		cachedSerClasses.add(cls);
		qName = new javax.xml.namespace.QName("http://gate.gopay.cz/ws",
				"EPaymentMethod");
		qName2 = null;
		cachedSerFactories
				.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(
						qName, qName2));
		cachedDeserFactories
				.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

		qName = new javax.xml.namespace.QName("http://gate.gopay.cz/ws",
				"EBuyerCreate");
		cachedSerQNames.add(qName);
		cls = EBuyerCreate.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName("http://gate.gopay.cz/ws",
				"EBuyerCreateResult");
		cachedSerQNames.add(qName);
		cls = EBuyerCreateResult.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName("http://gate.gopay.cz/ws",
				"ECustomerData");
		cachedSerQNames.add(qName);
		cls = ECustomerData.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName("http://gate.gopay.cz/ws",
				"EPaymentCommand");
		cachedSerQNames.add(qName);
		cls = EPaymentCommand.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName("http://gate.gopay.cz/ws",
				"EPaymentMethod");
		cachedSerQNames.add(qName);
		cls = EPaymentMethod.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName("http://gate.gopay.cz/ws",
				"EPaymentResult");
		cachedSerQNames.add(qName);
		cls = EPaymentResult.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName("http://gate.gopay.cz/ws",
				"EPaymentSessionInfo");
		cachedSerQNames.add(qName);
		cls = EPaymentSessionInfo.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName("http://gate.gopay.cz/ws",
				"EPaymentStatus");
		cachedSerQNames.add(qName);
		cls = EPaymentStatus.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		
		qName = new javax.xml.namespace.QName("http://gate.gopay.cz/ws",
		"ERecurrenceRequest");
		cachedSerQNames.add(qName);
		cls = ERecurrenceRequest.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);
		
		qName = new javax.xml.namespace.QName("http://gate.gopay.cz/ws",
		"ERefundRequest");
		cachedSerQNames.add(qName);
		cls = ERefundRequest.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

	}

	protected org.apache.axis.client.Call createCall()
			throws java.rmi.RemoteException {
		try {
			org.apache.axis.client.Call _call = super._createCall();
			if (super.maintainSessionSet) {
				_call.setMaintainSession(super.maintainSession);
			}
			if (super.cachedUsername != null) {
				_call.setUsername(super.cachedUsername);
			}
			if (super.cachedPassword != null) {
				_call.setPassword(super.cachedPassword);
			}
			if (super.cachedEndpoint != null) {
				_call.setTargetEndpointAddress(super.cachedEndpoint);
			}
			if (super.cachedTimeout != null) {
				_call.setTimeout(super.cachedTimeout);
			}
			if (super.cachedPortName != null) {
				_call.setPortName(super.cachedPortName);
			}
			java.util.Enumeration keys = super.cachedProperties.keys();
			while (keys.hasMoreElements()) {
				java.lang.String key = (java.lang.String) keys.nextElement();
				_call.setProperty(key, super.cachedProperties.get(key));
			}
			// All the type mapping information is registered
			// when the first call is made.
			// The type mapping information is actually registered in
			// the TypeMappingRegistry of the service, which
			// is the reason why registration is only needed for the first call.
			synchronized (this) {
				if (firstCall()) {
					// must set encoding style before registering serializers
					_call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
					_call.setEncodingStyle(org.apache.axis.Constants.URI_SOAP11_ENC);
					for (int i = 0; i < cachedSerFactories.size(); ++i) {
						java.lang.Class cls = (java.lang.Class) cachedSerClasses
								.get(i);
						javax.xml.namespace.QName qName = (javax.xml.namespace.QName) cachedSerQNames
								.get(i);
						java.lang.Object x = cachedSerFactories.get(i);
						if (x instanceof Class) {
							java.lang.Class sf = (java.lang.Class) cachedSerFactories
									.get(i);
							java.lang.Class df = (java.lang.Class) cachedDeserFactories
									.get(i);
							_call.registerTypeMapping(cls, qName, sf, df, false);
						} else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
							org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory) cachedSerFactories
									.get(i);
							org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory) cachedDeserFactories
									.get(i);
							_call.registerTypeMapping(cls, qName, sf, df, false);
						}
					}
				}
			}
			return _call;
		} catch (java.lang.Throwable _t) {
			throw new org.apache.axis.AxisFault(
					"Failure trying to get the Call object", _t);
		}
	}

	public EPaymentStatus createPayment(EPaymentCommand paymentCommand)
			throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[0]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName(
				"http://gate.gopay.cz/ws", "createPayment"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call
					.invoke(new java.lang.Object[] { paymentCommand });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return (EPaymentStatus) _resp;
				} catch (java.lang.Exception _exception) {
					return (EPaymentStatus) org.apache.axis.utils.JavaUtils
							.convert(_resp, EPaymentStatus.class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

	public EPaymentStatus paymentStatus(EPaymentSessionInfo paymentSessionInfo)
			throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[1]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName(
				"http://gate.gopay.cz/ws", "paymentStatus"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call
					.invoke(new java.lang.Object[] { paymentSessionInfo });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return (EPaymentStatus) _resp;
				} catch (java.lang.Exception _exception) {
					return (EPaymentStatus) org.apache.axis.utils.JavaUtils
							.convert(_resp, EPaymentStatus.class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

	public EBuyerCreateResult createBuyer(EBuyerCreate buyerCreate)
			throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[2]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName(
				"http://gate.gopay.cz/ws", "createBuyer"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call
					.invoke(new java.lang.Object[] { buyerCreate });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return (EBuyerCreateResult) _resp;
				} catch (java.lang.Exception _exception) {
					return (EBuyerCreateResult) org.apache.axis.utils.JavaUtils
							.convert(_resp, EBuyerCreateResult.class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

	public java.lang.String touch() throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[3]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName(
				"http://gate.gopay.cz/ws", "touch"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return (java.lang.String) _resp;
				} catch (java.lang.Exception _exception) {
					return (java.lang.String) org.apache.axis.utils.JavaUtils
							.convert(_resp, java.lang.String.class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

	public EPaymentResult refundPayment(EPaymentSessionInfo sessionInfo)
			throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[4]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName(
				"http://gate.gopay.cz/ws", "refundPayment"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call
					.invoke(new java.lang.Object[] { sessionInfo });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return (EPaymentResult) _resp;
				} catch (java.lang.Exception _exception) {
					return (EPaymentResult) org.apache.axis.utils.JavaUtils
							.convert(_resp, EPaymentResult.class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}
	
	public EPaymentResult refundPayment(ERefundRequest request)
			throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[10]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName(
				"http://gate.gopay.cz/ws", "refundPayment"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call
					.invoke(new java.lang.Object[] { request });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return (EPaymentResult) _resp;
				} catch (java.lang.Exception _exception) {
					return (EPaymentResult) org.apache.axis.utils.JavaUtils
							.convert(_resp, EPaymentResult.class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

	public EPaymentResult capturePayment(EPaymentSessionInfo sessionInfo)
			throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[5]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName(
				"http://gate.gopay.cz/ws", "capturePayment"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call
					.invoke(new java.lang.Object[] { sessionInfo });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return (EPaymentResult) _resp;
				} catch (java.lang.Exception _exception) {
					return (EPaymentResult) org.apache.axis.utils.JavaUtils
							.convert(_resp, EPaymentResult.class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

	public EPaymentMethod[] paymentMethodList() throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[6]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName(
				"http://gate.gopay.cz/ws", "paymentMethodList"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return (EPaymentMethod[]) _resp;
				} catch (java.lang.Exception _exception) {
					return (EPaymentMethod[]) org.apache.axis.utils.JavaUtils
							.convert(_resp, EPaymentMethod[].class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

	public EPaymentResult voidAuthorization(EPaymentSessionInfo sessionInfo)
			throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[7]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName(
				"http://gate.gopay.cz/ws", "voidAuthorization"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call
					.invoke(new java.lang.Object[] { sessionInfo });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return (EPaymentResult) _resp;
				} catch (java.lang.Exception _exception) {
					return (EPaymentResult) org.apache.axis.utils.JavaUtils
							.convert(_resp, EPaymentResult.class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

	public EPaymentResult voidRecurrentPayment(EPaymentSessionInfo sessionInfo)
			throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[8]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName(
				"http://gate.gopay.cz/ws", "voidRecurrentPayment"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call
					.invoke(new java.lang.Object[] { sessionInfo });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return (EPaymentResult) _resp;
				} catch (java.lang.Exception _exception) {
					return (EPaymentResult) org.apache.axis.utils.JavaUtils
							.convert(_resp, EPaymentResult.class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

	public EPaymentStatus createRecurrentPayment(
			ERecurrenceRequest recurrenceRequest) throws RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[9]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName(
				"http://gate.gopay.cz/ws", "createRecurrentPayment"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call
					.invoke(new java.lang.Object[] { recurrenceRequest });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return (EPaymentStatus) _resp;
				} catch (java.lang.Exception _exception) {
					return (EPaymentStatus) org.apache.axis.utils.JavaUtils
							.convert(_resp, EPaymentStatus.class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

}
