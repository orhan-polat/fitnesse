// Copyright (C) 2003-2009 by Object Mentor, Inc. All rights reserved.
// Released under the terms of the CPL Common Public License version 1.0.
package fitnesse;

import java.io.File;
import java.util.Properties;

import fitnesse.authentication.Authenticator;
import fitnesse.components.Logger;
import fitnesse.html.template.PageFactory;
import fitnesse.responders.ResponderFactory;
import fitnesse.testrunner.RunningTestingTracker;
import fitnesse.testsystems.TestSystemFactory;
import fitnesse.testsystems.TestSystemListener;
import fitnesse.wiki.RecentChanges;
import fitnesse.wiki.SystemVariableSource;
import fitnesse.wiki.WikiPage;
import fitnesse.wiki.fs.VersionsController;

public class FitNesseContext {
  public final static String recentChangesDateFormat = "kk:mm:ss EEE, MMM dd, yyyy";
  public final static String rfcCompliantDateFormat = "EEE, d MMM yyyy HH:mm:ss Z";
  public static final String testResultsDirectoryName = "testResults";

  public final FitNesseVersion version;
  public final FitNesse fitNesse;
  public final WikiPage root;

  public final TestSystemFactory testSystemFactory;
  public final TestSystemListener testSystemListener;

  public final int port;
  public final String rootPath;
  private final String rootDirectoryName;
  public final String contextRoot;
  public final ResponderFactory responderFactory;
  public final PageFactory pageFactory;
  public final SystemVariableSource variableSource;

  public final VersionsController versionsController;
  public final RecentChanges recentChanges;
  public final Logger logger;
  public final Authenticator authenticator;
  private final Properties properties;

  protected FitNesseContext(FitNesseVersion version, WikiPage root, String rootPath,
                            String rootDirectoryName, String contextRoot, VersionsController versionsController,
                            RecentChanges recentChanges, int port,
                            Authenticator authenticator, Logger logger,
                            TestSystemFactory testSystemFactory, TestSystemListener testSystemListener,
                            Properties properties) {
    super();
    this.version = version;
    this.root = root;
    this.rootPath = rootPath;
    this.rootDirectoryName = rootDirectoryName;
    this.contextRoot = contextRoot;
    this.versionsController = versionsController;
    this.recentChanges = recentChanges;
    this.port = port;
    this.authenticator = authenticator;
    this.logger = logger;
    this.testSystemFactory = testSystemFactory;
    this.testSystemListener = testSystemListener;
    this.properties = properties;
    responderFactory = new ResponderFactory(getRootPagePath());
    variableSource = new SystemVariableSource(properties);
    fitNesse = new FitNesse(this);
    pageFactory = new PageFactory(this);
  }

  public File getTestHistoryDirectory() {
    return new File(String.format("%s/files/%s", getRootPagePath(), testResultsDirectoryName));
  }

  public String getTestProgressPath() {
    return String.format("%s/files/testProgress/", getRootPagePath());
  }

  public String getRootPagePath() {
    return String.format("%s%s%s", rootPath, File.separator, rootDirectoryName);
  }

  public Properties getProperties() {
    return properties;
  }

  public String getProperty(String name) {
    return variableSource.getProperty(name);
  }
}
