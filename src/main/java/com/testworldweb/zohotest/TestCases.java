package com.testworldweb.zohotest;

import org.testng.Assert;
import org.testng.annotations.Test;


/**
 * Testcase suite for zoho web application
 * @author testworldweb
 *
 */
public class TestCases {

  /**
   * verify that the post by a manager is seen on the feed of a subordinate
   * @throws InterruptedException
   */
  @Test
  public void testPostSeenBySubordinate() throws InterruptedException {
     String postByUserAmya=ZohoFeatures.postByUser("Amya");
     Assert.assertEquals(true, ZohoFeatures.textfoundOnUserFeed("Bob","Amya"),"Amya word not found on subordinate's  feed");
 

  }
}