package ru.sample.model;

import javax.ejb.Local;

@Local
public interface GetReportLocal {
  
  public void ShowData (String s);
  
}
