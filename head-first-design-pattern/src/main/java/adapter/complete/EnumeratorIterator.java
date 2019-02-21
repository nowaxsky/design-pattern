package adapter.complete;

import java.util.Enumeration;
import java.util.Iterator;

public class EnumeratorIterator implements Iterator<Object>{

  private Enumeration<?> enumeration;
  
  public EnumeratorIterator(Enumeration<?> enumeration) {
    super();
    this.enumeration = enumeration;
  }

  @Override
  public boolean hasNext() {
    return enumeration.hasMoreElements();
  }

  @Override
  public Object next() {
    return enumeration.nextElement();
  }
  
  public void remove() {
    throw new UnsupportedOperationException();
  }

}
