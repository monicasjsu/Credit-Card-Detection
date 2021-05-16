package com.monica.creditcard;

import static org.junit.Assert.*;

import org.junit.Test;

public class ApplicationTest {

  @Test
  public void testValidGetPath() {
    assertNotNull(Application.getPath("src/test/resources/Sample.xml"));
  }

  @Test
  public void testValidGetPath2() {
    assertNotNull(Application.getPath("Sample.xml"));
  }

  @Test
  public void testFileExists() {
    assertTrue(Application.fileExists(Application.getPath("src/test/resources/Sample.xml")));
  }

  @Test
  public void testFileNotExists() {
    assertFalse(Application.fileExists(Application.getPath("Sample.xml")));
  }
}