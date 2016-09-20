/*
 * XoolA is a remote method call bridge between java and dotnet platforms.
 * Copyright (C) 2010 Muhammet YILDIZ, Doğan ERSÖZ
 *
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 *
 */
package org.interop.xoola.java.test;

import junit.framework.Assert;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.interop.xoola.core.*;
import org.interop.xoola.tcpcom.connmanager.server.ClientAccessController;
import org.junit.*;
import org.junit.rules.TestName;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * Intended for tests.
 *
 * @author yerlibilgin
 */
@SuppressWarnings("unused")
public class TestXoolaLargeMessage {
  private static final Logger LOGGER = Logger.getLogger(TestXoolaLargeMessage.class);
  private static final int _1M = 1024*1024;
  private static Xoola server;
  private static Xoola client;

  public static class DummyControl implements ClientAccessController {

    /**
     * is the provided client id allowed to create connection to the system?
     *
     * @param id
     * @return
     */
    @Override
    public boolean clientIsAllowed(String id) {
      return true;
    }
  }

  @Rule
  public TestName name = new TestName();

  @BeforeClass
  public static void setUp() throws Throwable {
    PropertyConfigurator.configure("logging.properties");
    Properties serverProperties = new Properties();
    serverProperties.load(new FileReader("xoola.properties"));

    serverProperties.put(XoolaProperty.MODE, XoolaTierMode.SERVER);
    serverProperties.put(XoolaProperty.CLIENT_ACCESS_CONTROLLER_CLASS, DummyControl.class.getName());
    server = Xoola.init(serverProperties);

    Properties clientProperties = new Properties();
    clientProperties.load(new FileReader("xoola.properties"));
    clientProperties.put(XoolaProperty.MODE, XoolaTierMode.CLIENT);
    clientProperties.put(XoolaProperty.CLIENTID, "CLIIIIIENNNT");
    client = Xoola.init(clientProperties);

    server.registerObject("multiFace", new MultiFace());
    client.registerObject("multiFace", new MultiFace());
    server.start();
    client.start();
    Thread.sleep(1000);
  }

  @AfterClass
  public static void tearDown() {
    client.close();
    server.close();
  }

  @Before
  public void before() {
    System.out.println("Running test " + name.getMethodName());
  }

  @Test
  public void test1M() throws InterruptedException {
    ILargeMessageService imf = client.get(ILargeMessageService.class, "multiFace");
    byte []b = new byte[1*_1M];
    new Random().nextBytes(b);

    org.junit.Assert.assertArrayEquals(imf.call(b), b);
  }

  @Test
  public void test5M() throws InterruptedException {
    ILargeMessageService imf = client.get(ILargeMessageService.class, "multiFace");
    byte []b = new byte[5*_1M];
    new Random().nextBytes(b);

    org.junit.Assert.assertArrayEquals(imf.call(b), b);
  }

  @Test
  public void test10M() throws InterruptedException {
    ILargeMessageService imf = client.get(ILargeMessageService.class, "multiFace");
    byte []b = new byte[10*_1M];
    new Random().nextBytes(b);

    org.junit.Assert.assertArrayEquals(imf.call(b), b);
  }

  @Test
  public void test25M() throws InterruptedException {
    ILargeMessageService imf = client.get(ILargeMessageService.class, "multiFace");
    byte []b = new byte[25*_1M];
    new Random().nextBytes(b);

    org.junit.Assert.assertArrayEquals(imf.call(b), b);
  }

  @Test
  public void test50M() throws InterruptedException {
    ILargeMessageService imf = client.get(ILargeMessageService.class, "multiFace");
    byte []b = new byte[50*_1M];
    new Random().nextBytes(b);

    org.junit.Assert.assertArrayEquals(imf.call(b), b);
  }

  @Test
  public void test100M() throws InterruptedException {
    ILargeMessageService imf = client.get(ILargeMessageService.class, "multiFace");
    byte []b = new byte[100*_1M];
    new Random().nextBytes(b);

    org.junit.Assert.assertArrayEquals(imf.call(b), b);
  }


  public interface ILargeMessageService {
    public byte[] call(byte[] param);
  }

  public static class MultiFace implements ILargeMessageService {
    @Override
    public synchronized byte[] call(byte[] param) {
      return param;
    }

  }
}
