package com.testworldweb.zohotest;

import org.testng.Assert;
import org.testng.annotations.Test;



public class TestCases {


  @Test
  public void testPostSeenBySubordinate() throws InterruptedException {
     String postByUserAmya=ZohoFeatures.postByUser("Amya");
  Assert.assertEquals(true, ZohoFeatures.textfoundOnUserFeed("Bob","Amya"),"Amya word not found on subordinate's  feed");
     

  }
}