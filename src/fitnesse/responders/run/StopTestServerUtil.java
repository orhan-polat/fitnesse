/*******************************************************************************
 * Copyright (c) 2012, 2013 Signal Iduna Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Signal Iduna Corporation - initial API and implementation
 * akquinet AG
 *******************************************************************************/
/**
 * 
 */
package fitnesse.responders.run;

/**
 * TODO: Add a class description!
 * 
 * @author u095471
 */
public class StopTestServerUtil {

	public static final String CANCEL_METHOD = "tearDown";
	public static final String SUSPEND_METHOD = "suspendTest";
	public static final String RESUME_METHOD = "resumeTest";
	public static final String STEPWISE_METHOD = "stepwiseTest";
	
	public static final String CANCEL_FIXTURE = "stoppableFixture";

	public static int getStopTestServerPort() {

		String stopTestServerPort = System.getProperty("STOPTEST_SERVER_PORT");

		if (stopTestServerPort == null) {
			return 18091;
		}

		return Integer.parseInt(stopTestServerPort);

	}
}
