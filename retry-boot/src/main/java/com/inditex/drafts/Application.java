package com.inditex.drafts;

import com.inditex.aqsw.framework.amiga.service.AmigaBootServiceApplication;

import org.springframework.boot.SpringApplication;

/**
 * The AMIGA Application.
 */
@AmigaBootServiceApplication
public class Application {

  /**
   * Main.
   * 
   * @param args the args
   */
  public static void main(final String[] args) {
    SpringApplication.run(Application.class, args);
  }

}
