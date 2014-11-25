package com.moon.listener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.event.internal.DefaultLoadEventListener;
import org.hibernate.event.spi.LoadEvent;

public class MyLoadEventListener extends DefaultLoadEventListener {

	protected final Log logger = LogFactory.getLog(getClass());

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -1023499481469367161L;

	@Override
	public void onLoad(LoadEvent event, LoadType loadType)
			throws HibernateException {

		logger.info("loading " + event.getEntityClassName() + " that OID is "
				+ event.getEntityId());

		super.onLoad(event, loadType);
	}
}
