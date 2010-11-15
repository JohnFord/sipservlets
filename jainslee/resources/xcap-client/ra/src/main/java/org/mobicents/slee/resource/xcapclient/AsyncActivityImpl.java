package org.mobicents.slee.resource.xcapclient;

import java.net.URI;

import org.mobicents.slee.resource.xcapclient.AsyncActivity;
import org.mobicents.slee.resource.xcapclient.XCAPResourceAdaptorActivityHandle;
import org.mobicents.slee.resource.xcapclient.handler.AsyncDeleteHandler;
import org.mobicents.slee.resource.xcapclient.handler.AsyncDeleteIfMatchHandler;
import org.mobicents.slee.resource.xcapclient.handler.AsyncDeleteIfNoneMatchHandler;
import org.mobicents.slee.resource.xcapclient.handler.AsyncGetHandler;
import org.mobicents.slee.resource.xcapclient.handler.AsyncPutByteArrayContentHandler;
import org.mobicents.slee.resource.xcapclient.handler.AsyncPutIfMatchByteArrayContentHandler;
import org.mobicents.slee.resource.xcapclient.handler.AsyncPutIfMatchStringContentHandler;
import org.mobicents.slee.resource.xcapclient.handler.AsyncPutIfNoneMatchByteArrayContentHandler;
import org.mobicents.slee.resource.xcapclient.handler.AsyncPutIfNoneMatchStringContentHandler;
import org.mobicents.slee.resource.xcapclient.handler.AsyncPutStringContentHandler;
import org.mobicents.xcap.client.auth.Credentials;
import org.mobicents.xcap.client.header.Header;

public class AsyncActivityImpl implements AsyncActivity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final transient XCAPClientResourceAdaptor ra;
	private final XCAPResourceAdaptorActivityHandle handle;

	/**
	 * 
	 * @param ra
	 * @param handle
	 */
	public AsyncActivityImpl(XCAPClientResourceAdaptor ra,
			XCAPResourceAdaptorActivityHandle handle) {
		this.handle = handle;
		this.ra = ra;
	}

	/**
	 * 
	 * @return
	 */
	public XCAPClientResourceAdaptor getRA() {
		return ra;
	}

	/**
	 * 
	 * @return
	 */
	public XCAPResourceAdaptorActivityHandle getHandle() {
		return handle;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.mobicents.slee.resource.xcapclient.AsyncActivity#endActivity()
	 */
	public void endActivity() {
		ra.endActivity(handle);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object o) {
		if (o != null && o.getClass() == this.getClass()) {
			return ((AsyncActivityImpl) o).handle.equals(this.handle);
		} else {
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return handle.hashCode();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.mobicents.slee.resource.xcapclient.AsyncActivity#delete(java.net.URI,
	 * org.mobicents.xcap.client.header.Header[],
	 * org.mobicents.xcap.client.auth.Credentials)
	 */
	public void delete(URI uri, Header[] additionalRequestHeaders,
			Credentials credentials) {
		ra.getExecutorService().execute(
				new AsyncDeleteHandler(ra, handle, uri,
						additionalRequestHeaders, credentials));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.mobicents.slee.resource.xcapclient.AsyncActivity#deleteIfMatch(java
	 * .net.URI, java.lang.String, org.mobicents.xcap.client.header.Header[],
	 * org.mobicents.xcap.client.auth.Credentials)
	 */
	public void deleteIfMatch(URI uri, String eTag,
			Header[] additionalRequestHeaders, Credentials credentials) {
		ra.getExecutorService().execute(
				new AsyncDeleteIfMatchHandler(ra, handle, uri, eTag,
						additionalRequestHeaders, credentials));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.mobicents.slee.resource.xcapclient.AsyncActivity#deleteIfNoneMatch
	 * (java.net.URI, java.lang.String,
	 * org.mobicents.xcap.client.header.Header[],
	 * org.mobicents.xcap.client.auth.Credentials)
	 */
	public void deleteIfNoneMatch(URI uri, String eTag,
			Header[] additionalRequestHeaders, Credentials credentials) {
		ra.getExecutorService().execute(
				new AsyncDeleteIfNoneMatchHandler(ra, handle, uri, eTag,
						additionalRequestHeaders, credentials));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.mobicents.slee.resource.xcapclient.AsyncActivity#get(java.net.URI,
	 * org.mobicents.xcap.client.header.Header[],
	 * org.mobicents.xcap.client.auth.Credentials)
	 */
	public void get(URI uri, Header[] additionalRequestHeaders,
			Credentials credentials) {
		ra.getExecutorService().execute(
				new AsyncGetHandler(ra, handle, uri, additionalRequestHeaders,
						credentials));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.mobicents.slee.resource.xcapclient.AsyncActivity#put(java.net.URI,
	 * java.lang.String, java.lang.String,
	 * org.mobicents.xcap.client.header.Header[],
	 * org.mobicents.xcap.client.auth.Credentials)
	 */
	public void put(URI uri, String mimetype, String content,
			Header[] additionalRequestHeaders, Credentials credentials) {
		ra.getExecutorService().execute(
				new AsyncPutStringContentHandler(ra, handle, uri, mimetype,
						content, additionalRequestHeaders, credentials));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.mobicents.slee.resource.xcapclient.AsyncActivity#put(java.net.URI,
	 * java.lang.String, byte[], org.mobicents.xcap.client.header.Header[],
	 * org.mobicents.xcap.client.auth.Credentials)
	 */
	public void put(URI uri, String mimetype, byte[] content,
			Header[] additionalRequestHeaders, Credentials credentials) {
		ra.getExecutorService().execute(
				new AsyncPutByteArrayContentHandler(ra, handle, uri, mimetype,
						content, additionalRequestHeaders, credentials));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.mobicents.slee.resource.xcapclient.AsyncActivity#putIfMatch(java.
	 * net.URI, java.lang.String, java.lang.String, java.lang.String,
	 * org.mobicents.xcap.client.header.Header[],
	 * org.mobicents.xcap.client.auth.Credentials)
	 */
	public void putIfMatch(URI uri, String eTag, String mimetype,
			String content, Header[] additionalRequestHeaders,
			Credentials credentials) {
		ra.getExecutorService().execute(
				new AsyncPutIfMatchStringContentHandler(ra, handle, uri, eTag,
						mimetype, content, additionalRequestHeaders,
						credentials));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.mobicents.slee.resource.xcapclient.AsyncActivity#putIfMatch(java.
	 * net.URI, java.lang.String, java.lang.String, byte[],
	 * org.mobicents.xcap.client.header.Header[],
	 * org.mobicents.xcap.client.auth.Credentials)
	 */
	public void putIfMatch(URI uri, String eTag, String mimetype,
			byte[] content, Header[] additionalRequestHeaders,
			Credentials credentials) {
		ra.getExecutorService().execute(
				new AsyncPutIfMatchByteArrayContentHandler(ra, handle, uri,
						eTag, mimetype, content, additionalRequestHeaders,
						credentials));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.mobicents.slee.resource.xcapclient.AsyncActivity#putIfNoneMatch(java
	 * .net.URI, java.lang.String, java.lang.String, java.lang.String,
	 * org.mobicents.xcap.client.header.Header[],
	 * org.mobicents.xcap.client.auth.Credentials)
	 */
	public void putIfNoneMatch(URI uri, String eTag, String mimetype,
			String content, Header[] additionalRequestHeaders,
			Credentials credentials) {
		ra.getExecutorService().execute(
				new AsyncPutIfNoneMatchStringContentHandler(ra, handle, uri,
						eTag, mimetype, content, additionalRequestHeaders,
						credentials));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.mobicents.slee.resource.xcapclient.AsyncActivity#putIfNoneMatch(java
	 * .net.URI, java.lang.String, java.lang.String, byte[],
	 * org.mobicents.xcap.client.header.Header[],
	 * org.mobicents.xcap.client.auth.Credentials)
	 */
	public void putIfNoneMatch(URI uri, String eTag, String mimetype,
			byte[] content, Header[] additionalRequestHeaders,
			Credentials credentials) {
		ra.getExecutorService().execute(
				new AsyncPutIfNoneMatchByteArrayContentHandler(ra, handle, uri,
						eTag, mimetype, content, additionalRequestHeaders,
						credentials));
	}

}
